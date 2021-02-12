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

import java.util.Optional;
import com.siranatoliy.usimage.exception.ObjectNotFoundException;
import com.siranatoliy.usimage.model.AsyncOperation;
import com.siranatoliy.usimage.model.ImageResource;
import com.siranatoliy.usimage.model.domain.Profile;

/**
 * Interface is responsible for performing the action with domain knowledge.
 * 
 * @author Anatoliy Kovalv
 * @version 1.0 
 */ 
public interface ProfileService {

    /**
     * Find profile by profile ID,
     * method added as an additional way to search for a profile.
     */
    Profile findById(Long id) throws ObjectNotFoundException;
    
    /**
     * Find profile by profile UID
     */
    Profile findByUid(String uid) throws ObjectNotFoundException;
    
    /**
     * Find a profile by E-mail. If the user is not found,
     * an empty profile will be returned 
     * (since the profile may not have an email address)
     */
    Optional<Profile> findByEmail(String email);
    
    /**
     * Register a user profile.
     * @param uploadProfileAvatar    points out whether the user has an avatar.
     */
    void signUp(Profile profile, boolean uploadProfileAvatar);
    
    /**
     * Translates the user name from any language to English.
     */
    void translitSocialProfile(Profile profile);
    
    /**
     * Updates profile changes.
     */
    void update(Profile profile);
    
    void uploadNewAvatar(Profile currentProfile, ImageResource imageResource, AsyncOperation<Profile> asyncOperation);
}
