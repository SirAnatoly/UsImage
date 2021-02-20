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

package com.siranatoliy.usimage.ejb.service.bean;

import com.siranatoliy.usimage.common.annotation.cdi.Property;
import com.siranatoliy.usimage.ejb.repository.ProfileRepository;
import com.siranatoliy.usimage.exception.ObjectNotFoundException;
import com.siranatoliy.usimage.model.AsyncOperation;
import com.siranatoliy.usimage.model.ImageResource;
import com.siranatoliy.usimage.model.domain.Profile;
import com.siranatoliy.usimage.service.ProfileService;
import java.util.Optional;
import javax.ejb.Asynchronous;
import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;


/**
 * 
 * 
 * @author Anatoliy Kovalv
 * @version 1.0 
 */ 
@Stateless
@LocalBean
@Local(ProfileService.class)
public class ProfileServiceBean implements ProfileService{
    
    @Inject
    @Property("usimage.profile.avatar.placeholder.url")
    private String avatarPlaceHolderUrl;
    
    @Inject
    private ProfileRepository profileRepository;

    @Override
    public Profile findById(Long id) throws ObjectNotFoundException {
        Optional<Profile> profile = profileRepository.findById(id);
        if (!profile.isPresent()) {
            throw new ObjectNotFoundException(String.format("Profile not found by id: %s", id));
        }
        return profile.get();
    }

    @Override
    public Profile findByUid(String uid) throws ObjectNotFoundException {
        Optional<Profile> profile = profileRepository.findByUid(uid);
        if (!profile.isPresent()) {
            throw new ObjectNotFoundException(String.format("Profile not found by uid: %s", uid));
        }
        return profile.get();
    }

    @Override
    public Optional<Profile> findByEmail(String email) {
        return profileRepository.findByEmail(email);
    }

    @Override
    public void signUp(Profile profile, boolean uploadProfileAvatar) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    @Override
    public void translitSocialProfile(Profile profile) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    @Override
    public void update(Profile profile) {
        profileRepository.update(profile);
    }

    @Override
    @Asynchronous
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public void uploadNewAvatar(Profile currentProfile, ImageResource imageResource, AsyncOperation<Profile> asyncOperation) {
        try {
            uploadNewAvatar(currentProfile, imageResource);
            asyncOperation.onSuccess(currentProfile);
        } catch (Throwable throwable) {
            setAvatarPlaceHolder(currentProfile);
            asyncOperation.onFailed(throwable);
        }
    }
    
    public void uploadNewAvatar(Profile currentProfile, ImageResource imageResource) {
        
    }
    
    public void setAvatarPlaceHolder(Long profileId) {
        setAvatarPlaceHolder(profileRepository.findById(profileId).get());
    }

    public void setAvatarPlaceHolder(Profile currentProfile) {
        if (currentProfile.getAvatarUrl() == null) {
            currentProfile.setAvatarUrl(avatarPlaceHolderUrl);
            profileRepository.update(currentProfile);
        }
    }

}
