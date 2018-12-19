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

import org.junit.Ignore;
import org.junit.Test;

import it.smartcommunitylab.ApiException;
import it.smartcommunitylab.model.ExecutionDataDTO;

/**
 * API tests for DomainExecutionControllerApi
 */
@Ignore
public class DomainExecutionControllerApiTest {

    private final DomainExecutionControllerApi api = new DomainExecutionControllerApi();

    
    /**
     * Execute an action
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void executeActionUsingPOSTTest() throws ApiException {
        String domain = null;
        String gameId = null;
        String actionId = null;
        ExecutionDataDTO data = null;
        api.executeActionUsingPOST(domain, gameId, actionId, data);

        // TODO: test validations
    }
    
}
