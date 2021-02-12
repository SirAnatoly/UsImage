/* 
 * Copyright 2021 Anatoliy Kovalv
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.siranatoliy.usimage.service;

import com.siranatoliy.usimage.exception.RetrieveSocialDataFailedException;
import com.siranatoliy.usimage.model.domain.Profile;

/**
 * Service for interacting with social services
 * 
 * @author Anatoliy Kovalv
 * @version 1.0 
 */ 
public interface SocialService {

    /**
     * retrieves the profile object by the specified code
     * 
     * @param code     social network response
     * @throws RetrieveSocialDataFailedException    if there are problems from when receiving data from a social network
     */
    Profile fetchProfile(String code) throws RetrieveSocialDataFailedException;
    
    String getClientId();
    
    /**
     * Not all social networks support this feature by default.
     * 
     * @return URL by which the user is authorized.
     */
    default String getAuthorizeUrl() {
        throw new UnsupportedOperationException();
    }
}

        