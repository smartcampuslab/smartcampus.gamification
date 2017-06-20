package it.smartcommunitylab.gamification.log_converter.manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.log4j.Logger;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import it.smartcommunitylab.gamification.log_converter.beans.Record;
import it.smartcommunitylab.gamification.log_converter.beans.RecordType;

public class RecordManager {
	private final static Logger logger = Logger.getLogger(RecordManager.class);
	Map<String, List<String>> badgesDictionary = new HashMap<String, List<String>>();
	Map<String, Double> scoresDictionary = new HashMap<String, Double>();

	public RecordManager() {
	}

	public Record analizza(String record) {
		Record result = null;
		if (record != null) {
			// logger.debug("Analisi record: " + record);
			result = new Record();
			result.setContent(record);
			int indiceDelCampo = record.indexOf("type=");
			if (indiceDelCampo > 0) {
				result.setIndexType(indiceDelCampo);
				indiceDelCampo = indiceDelCampo + 5;
				String type = record.substring(indiceDelCampo, record.indexOf(" ", indiceDelCampo));
				// logger.debug(String.format("Valore di type %s", type));
				result.setType(valueOf(type));
			} else {
				logger.warn("il record non contiene type=");
			}
		}
		return result;
	}

	public String analizzaPointConcept(Record record) {
		String out = "";
		String splitXSpazi = record.getContent().substring(0, record.getIndexType());
		String splitDiverso = record.getContent().substring(record.getIndexType());
		String[] campi = { "type=", "ruleName=", "name=", "score=" };
		String[] info = estraiInformazioni(splitDiverso, campi);
		String s = info[3].substring(info[3].indexOf("=") + 1);
		Double score = Double.valueOf(s);
		// logger.debug("SCORE=" + s);
		String name = info[2].substring(campi[2].length() + 1, info[2].length() - 2);
		// logger.debug("name: " + name);
		Double delta = score - scoresDictionary.get(name);
		out = splitXSpazi + splitDiverso + " deltaScore=" + delta;
		// logger.debug("Nuovo messaggio Point: " + out);
		return out;
	}

	public String analizzaBadgeCollection(Record record) {
		String out = "";
		String splitXSpazi = record.getContent().substring(0, record.getIndexType());
		String splitDiverso = record.getContent().substring(record.getIndexType());
		String[] campi = { "type=", "ruleName=", "name=", "badges=" };
		String[] info = estraiInformazioni(splitDiverso, campi);
		List<String> newBadges = trovaBadgeIniziali(campi, info);
		out = splitXSpazi + info[0] + info[1] + info[2] + "new_badge=" + "\"" + newBadges.get(0) + "\"";
		// logger.info("Nuovo messaggio Badge: " + out);
		return out;
	}

	private String[] estraiInformazioni(String splitDiverso, String[] campi) {
		int[] indiciCampi = new int[campi.length];
		int[] indiciInformazioni = new int[campi.length];
		String[] info = new String[4];
		for (int i = 0; i < campi.length; i++) {
			if (splitDiverso.contains(campi[i])) {
				indiciCampi[i] = splitDiverso.indexOf(campi[i]);
				indiciInformazioni[i] = indiciCampi[i] + campi[i].length();
			}
		}
		for (int i = 0; i < campi.length; i++) {
			// coltrollo toglire ultimo spazio
			if (i < campi.length - 1) {
				info[i] = splitDiverso.substring(indiciCampi[i], indiciCampi[i + 1]);
			} else {
				info[i] = splitDiverso.substring(indiciCampi[i], splitDiverso.length() - 1);
			}
		}
		return info;
	}

	private List<String> trovaBadgeIniziali(String[] campi, String[] info) {
		String badgeColl = info[3].substring(campi[3].length() + 1);// ,
		badgeColl = badgeColl.substring(badgeColl.indexOf("[") + 1, badgeColl.indexOf("]"));
		String[] vettore = badgeColl.split(",");
		List<String> newBadges = new ArrayList<>();
		for (String b : vettore) {
			newBadges.add(b.trim());
		}
		String nome = info[2].substring(campi[2].length() + 1);
		nome = nome.substring(0, nome.indexOf("\""));
		if (badgesDictionary.get(nome) != null) {
			logger.debug("valore per badgeCollection: " + nome + " - " + newBadges);
			logger.debug("Valore oldState: " + badgesDictionary.get(nome));
			newBadges = new ArrayList<String>(CollectionUtils.subtract(newBadges, badgesDictionary.get(nome)));
			logger.debug("nuovo badge: " + newBadges);
		} else {
			logger.debug("nessun valore per badgeCollection: " + nome);
		}
		return newBadges;
	}

	public String analizzaClassification(Record record) {
		String out = null;
		String splitXSpazi = record.getContent().substring(0, record.getIndexType());
		String splitDiverso = record.getContent().substring(record.getIndexType());
		String[] campi = { "type=", "action=", "internalData=", "oldState=" };
		String[] info = estraiInformazioni(splitDiverso, campi);
		badgesDictionary = creaDizionarioBadges(campi, info);
		scoresDictionary = creaDizionarioScore(campi, info);
		logger.debug("oldState classification: " + info[3]);
		// creazione nuovi campi classifica(da migliorare)
		String classificationPosition = "" + info[2].split(",")[1].substring(13) + "";
		String classificationName = info[2].split(",")[0].substring(campi[2].length() + 3 + 10,
				info[2].split(",")[0].length() - 2) + "\"";
		out = splitXSpazi + info[0] + "classificationName=" + classificationName + " classificationPosition="
				+ classificationPosition;
		logger.info("il nuovo messaggio per Classification �: " + out);
		return out;
	}

	public String analizzaAction(Record record) {
		String out = null;
		String splitXSpazi = record.getContent().substring(0, record.getIndexType());
		String splitDiverso = record.getContent().substring(record.getIndexType());
		String[] campi = { "type=", "action=", "payload=", "oldState=" };
		String[] info = estraiInformazioni(splitDiverso, campi);
		badgesDictionary = creaDizionarioBadges(campi, info);
		scoresDictionary = creaDizionarioScore(campi, info);
		logger.debug("dizionario score: " + scoresDictionary);
		out = splitXSpazi + info[0] + info[1];
		out = out.substring(0, out.length() - 1);
		logger.info("il nuovo messaggio per action �: " + out);
		return out;
	}

	private Map<String, Double> creaDizionarioScore(String[] campi, String[] info) {
		logger.debug("inizializzo dizionario per scores");
		Map<String, Double> dizionario = new HashMap<>();
		String json = puliziaJson(campi, info);
		JsonParser parser = new JsonParser();
		logger.debug("inizio parsing oldState");
		JsonArray jsonArray = parser.parse(json).getAsJsonArray();
		for (JsonElement element : jsonArray) {
			JsonObject obj = element.getAsJsonObject();
			if (obj.get("score") != null) {
				// logger.debug("oggetto: " + obj.toString());
				String scoreName = obj.get("name").getAsString();
				// nome badge
				logger.debug("nomeScore==" + scoreName);
				Double value = obj.get("score").getAsDouble();
				logger.debug("value: " + value);
				dizionario.put(scoreName, value);
			}
		}
		logger.debug("dizionario valori badges: " + badgesDictionary);
		return dizionario;
	}

	private Map<String, List<String>> creaDizionarioBadges(String[] campi, String[] info) {
		logger.debug("inizializzo dizionario per badges");
		Map<String, List<String>> dizionario = new HashMap<>();
		String json = puliziaJson(campi, info);
		JsonParser parser = new JsonParser();
		logger.debug("inizio parsing oldState");
		JsonArray jsonArray = parser.parse(json).getAsJsonArray();
		for (JsonElement element : jsonArray) {
			JsonObject obj = element.getAsJsonObject();
			if (obj.get("badgeEarned") != null) {
				logger.debug("oggetto: " + obj.toString());
				String badgeCollectionName = obj.get("name").getAsString();
				// nome badge
				logger.debug("nomeBadge==" + badgeCollectionName);
				JsonArray badges = obj.get("badgeEarned").getAsJsonArray();
				logger.debug("badges: " + badges.toString());
				List<String> listaValori = new ArrayList<String>();
				for (JsonElement badgeElement : badges) {
					listaValori.add(badgeElement.getAsString());
				}
				logger.debug("badges array size: " + listaValori.size());
				dizionario.put(badgeCollectionName, listaValori);
			}
		}
		logger.debug("dizionario valori badges: " + badgesDictionary);
		return dizionario;
	}

	private String puliziaJson(String[] campi, String[] info) {
		return StringEscapeUtils.unescapeJava(info[3].substring(campi[3].length() + 1));
	}

	private RecordType valueOf(String type) {
		switch (type) {
		case "Action":
			return RecordType.ACTION;
		case "PointConcept":
			return RecordType.RULE_POINTCONCEPT;
		case "BadgeCollectionConcept":
			return RecordType.RULE_BADGECOLLECTIONCONCEPT;
		case "Classification":
			return RecordType.CLASSIFICATION;
		default:
			throw new IllegalArgumentException(type + " non � supportato");
		}
	}
}