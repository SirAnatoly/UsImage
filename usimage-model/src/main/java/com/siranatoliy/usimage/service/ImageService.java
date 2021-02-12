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

import java.util.List;
import com.siranatoliy.usimage.exception.ObjectNotFoundException;
import com.siranatoliy.usimage.model.AsyncOperation;
import com.siranatoliy.usimage.model.ImageResource;
import com.siranatoliy.usimage.model.OriginalImage;
import com.siranatoliy.usimage.model.Pageable;
import com.siranatoliy.usimage.model.SortMode;
import com.siranatoliy.usimage.model.domain.Image;
import com.siranatoliy.usimage.model.domain.Profile;

/**
 * Interface is responsible for interacting with images.
 * 
 * @author Anatoliy Kovalv
 * @version 1.0 
 */ 
public interface ImageService {

/**
 * Find user images profile.
 * 
 * @param profileId     user ID.
 * @param pageable      to specify which pieces of images is required.
 */ 
    List<Image> findProfileImage(Long profileId, Pageable pageable);
    
    List<Image> findPopularImage(SortMode sortMode, Pageable pageable);
    
    /**
     * number of images in the database
     */
    long countAllImage();
    
    /**
     * return the URL to large image 
     */    
    String viewLargeImage(Long photoId) throws ObjectNotFoundException; 
    
    OriginalImage downloadOriginalImage(Long photoId) throws ObjectNotFoundException; 
    
    void uploadNewImage(Profile currentProfile, ImageResource imageResource, AsyncOperation<Image> asyncOperation);
}
