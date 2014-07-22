package eu.trentorise.game.plugin.point.model;

import eu.trentorise.game.plugin.model.CustomizedGamificationPlugin;

/**
 *
 * @author Luca Piras
 */
public class PointPlugin extends CustomizedGamificationPlugin {
    
    protected Typology typology;

    public Typology getTypology() {
        return typology;
    }

    public void setTypology(Typology typology) {
        this.typology = typology;
    }

    @Override
    public String toString() {
        return "PointPlugin{" + "typology=" + typology + '}';
    }
}