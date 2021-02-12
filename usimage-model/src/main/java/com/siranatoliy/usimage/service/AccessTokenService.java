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

import com.siranatoliy.usimage.exception.AccessForbiddenException;
import com.siranatoliy.usimage.exception.InvalidAccessTokenException;
import com.siranatoliy.usimage.model.domain.AccessToken;
import com.siranatoliy.usimage.model.domain.Profile;

/**
 * Interface is responsible for managing access tokens.
 * 
 * @author Anatoliy Kovalv
 * @version 1.0 
 */ 
public interface AccessTokenService {

    /**
     * Generates a new access token in the database for the user.
     */
    AccessToken generateAccessToken(Profile profile);
    
    /**
     * Finds information about the current profile.
     * 
     * @param token     user access token
     * @param profileId user ID
     * @throws AccessForbiddenException         no token in the database, or an invalid token
     * @throws InvalidAccessTokenException      if profile Id does not match the token
     */
    Profile findProfile(String token, Long profileId) throws AccessForbiddenException, InvalidAccessTokenException;
    
    /**
     * Deletes the token from the database.
     * 
     * @throws InvalidAccessTokenException      token does not exist in the database.
     */
    void invalidateAccessToken(String token) throws InvalidAccessTokenException;
}
