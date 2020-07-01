/**
 * Copyright 2018-2019 SmartCommunity Lab(FBK-ICT).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

/*
 * Gamification Engine API
 * No description provided (generated by Swagger Codegen https://github.com/swagger-api/swagger-codegen)
 *
 * OpenAPI spec version: v1.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package it.smartcommunitylab.oauth.api;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import it.smartcommunitylab.ApiClient;
import it.smartcommunitylab.ApiException;
import it.smartcommunitylab.auth.OAuth;
import it.smartcommunitylab.model.ChallengeConcept;
import it.smartcommunitylab.model.Inventory;
import it.smartcommunitylab.model.ItemChoice;
import it.smartcommunitylab.model.PagePlayerStateDTO;
import it.smartcommunitylab.model.PlayerStateDTO;
import it.smartcommunitylab.model.WrapperQuery;
import it.smartcommunitylab.model.ext.GameConcept;
import it.smartcommunitylab.model.ext.PlayerLevel;
import it.smartcommunitylab.model.ext.PointConcept;
import it.smartcommunitylab.model.ext.TeamDTO;

/**
 * API tests for DomainPlayerControllerApi
 */
@org.junit.Ignore
public class DomainPlayerControllerApiTest {

    private final DomainPlayerControllerApi api = new DomainPlayerControllerApi();
    
    private ApiClient apiClient;
    private String baseUrl = "http://localhost:6060/gamification";
    private String gameId = "57ac710fd4c6ac7872b0e7a1";
    private String playerId = "341";
    private String conceptName = "green leaves";
    private String domain = "demo-domain";
    
    @Before
    public void init() {
    	 apiClient = new ApiClient(baseUrl);
    	
    	 // Configure OAuth2 access token for authorization: oauth2
    	 OAuth oauth2 = (OAuth) apiClient.getAuthentication("oauth2");
    	 oauth2.setAccessToken("ef11debc-19cc-4477-84c4-15ce540075f7");
    	 
    	 // Configure basic auth. 
    	 api.setApiClient(apiClient);
    }

    
    /**
     * Accept challenge
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void acceptChallengeUsingPOSTTest() throws ApiException {
        String domain = null;
        String gameId = null;
        String playerId = null;
        String challengeName = null;
        ChallengeConcept response = api.acceptChallengeUsingPOST(domain, gameId, playerId, challengeName);

        // TODO: test validations
    }
    
    /**
     * Activate a choice
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void activateChoiceUsingPOSTTest() throws ApiException {
        String domain = null;
        String gameId = null;
        String playerId = null;
        ItemChoice choice = null;
        Inventory response = api.activateChoiceUsingPOST(domain, gameId, playerId, choice);

        // TODO: test validations
    }
    
    /**
     * Assign challenge
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    @Ignore("update oauth client")
    public void assignChallengeUsingPOSTTest() throws ApiException {
        // ChallengeAssignmentDTO challengeData = null;
        // String gameId = null;
        // String playerId = null;
        // api.assignChallengeUsingPOST(domain, challengeData, gameId, playerId);

        // TODO: test validations
    }
    
    /**
     * Create player
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void createPlayerUsingPOST1Test() throws ApiException {
        String gameId = null;
        PlayerStateDTO player = null;
        api.createPlayerUsingPOST1(domain, gameId, player);

        // TODO: test validations
    }
    
    /**
     * Delete player state
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void deletePlayerUsingDELETE1Test() throws ApiException {
        String gameId = null;
        String playerId = null;
        api.deletePlayerUsingDELETE1(domain, gameId, playerId);

        // TODO: test validations
    }
    
    /**
     * Get player challenges
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getPlayerChallengeUsingGETTest() throws ApiException {
       
    	List<ChallengeConcept> response = api.getPlayerChallengeUsingGET(domain, gameId, playerId);

    	System.out.println(response.size());
   
    }
    
    /**
     * Get player custom data
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void readCustomDataUsingGETTest() throws ApiException {
        String gameId = null;
        String playerId = null;
        PlayerStateDTO response = api.readCustomDataUsingGET(domain, gameId, playerId);

        // TODO: test validations
    }
    
    /**
     * Get player inventory
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void readInventoryUsingGETTest() throws ApiException {
        Inventory response = api.readInventoryUsingGET(domain, gameId, playerId);

        // TODO: test validations
    }
    
    /**
     * Get player levels
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void readLevelsUsingGETTest() throws ApiException {
        String gameId = null;
        String playerId = null;
        List<PlayerLevel> response = api.readLevelsUsingGET(domain, gameId, playerId);

        // TODO: test validations
    }
    
    /**
     * Get player state
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void readPlayerUsingGETTest() throws ApiException {
        PlayerStateDTO response = api.readPlayerUsingGET(domain, gameId, playerId);

        // TODO: test validations
    }
    
    /**
     * Get player state
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     * @throws IOException 
     * @throws JsonMappingException 
     * @throws JsonParseException 
     */
    @Test
    public void readStateUsingGETTest() throws ApiException, JsonParseException, JsonMappingException, IOException {
        PlayerStateDTO response = api.readStateUsingGET(domain, gameId, playerId);
        System.out.println(response.getGameId());
        
        Set<GameConcept> scores = response.getState().get("PointConcept");
        scores.stream().filter(score -> "green leaves".equals(score.getName())).findFirst()
        .map(concept -> (PointConcept) concept)
        .ifPresent(score -> System.out.println(score.getScore()));
    }
    
    /**
     * Get player teams
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void readTeamsByMemberUsingGET1Test() throws ApiException {
    	gameId = "5719e700e4b0bc2cc4677cb3";
    	playerId = "dff57c45-b3b0-419c-8435-3d8b488c45b8";
        List<TeamDTO> response = api.readTeamsByMemberUsingGET1(domain, gameId, playerId);

        System.out.println(response.size());
    }
    
    /**
     * Search player states
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void searchByQueryUsingPOSTTest() throws ApiException {
        String gameId = null;
        WrapperQuery query = null;
        String page = null;
        String size = null;
        PagePlayerStateDTO response = api.searchByQueryUsingPOST(domain, gameId, query, page, size);

        // TODO: test validations
    }
    
    /**
     * Edit player state
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void updatePlayerUsingPUTTest() throws ApiException {
        String gameId = null;
        String playerId = null;
        api.updatePlayerUsingPUT(domain, gameId, playerId);

        // TODO: test validations
    }
    
}
