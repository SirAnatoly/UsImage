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

import com.siranatoliy.usimage.ejb.repository.PhotoRepository;
import com.siranatoliy.usimage.ejb.repository.ProfileRepository;
import com.siranatoliy.usimage.exception.ObjectNotFoundException;
import com.siranatoliy.usimage.exception.ValidationException;
import com.siranatoliy.usimage.model.AsyncOperation;
import com.siranatoliy.usimage.model.ImageResource;
import com.siranatoliy.usimage.model.OriginalImage;
import com.siranatoliy.usimage.model.Pageable;
import com.siranatoliy.usimage.model.SortMode;
import static com.siranatoliy.usimage.model.SortMode.POPULAR_AUTHOR;
import static com.siranatoliy.usimage.model.SortMode.POPULAR_PHOTO;
import com.siranatoliy.usimage.model.domain.Image;
import com.siranatoliy.usimage.model.domain.Profile;
import com.siranatoliy.usimage.service.ImageService;
import static java.lang.String.format;
import java.math.BigInteger;
import java.util.List;
import java.util.Optional;
import javax.annotation.Resource;
import javax.ejb.Asynchronous;
import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.SessionContext;
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
@Local(ImageService.class)
public class ImageServiceBean implements ImageService {
    
    @Inject
    private PhotoRepository photoRepository;

    @Inject
    private ProfileRepository profileRepository;
    
    @Resource
    private SessionContext sessionContext;

    @Override
    public List<Image> findProfileImage(Long profileId, Pageable pageable) {
        return photoRepository.findProfileImagesLatestFirst(profileId, pageable.getOffset(), pageable.getLimit());
    }

    @Override
    public List<Image> findPopularImage(SortMode sortMode, Pageable pageable) {
        switch (sortMode) {
            case POPULAR_AUTHOR:
                return photoRepository.findAllOrderByAuthorRatingDesc(pageable.getOffset(), pageable.getLimit());
            case POPULAR_PHOTO:
                return photoRepository.findAllOrderByViewsDesc(pageable.getOffset(), pageable.getLimit());
            default:
                throw new ValidationException("Unsupported sort mode: " + sortMode);
        }
    }

    @Override
    public long countAllImage() {
        return photoRepository.countAll();
    }

   @Override
    public String viewLargeImage(Long photoId) throws ObjectNotFoundException {
        Image image = getImage(photoId);
        image.setViews(image.getViews().add(BigInteger.ONE));
        photoRepository.update(image);
        return image.getLargeUrl();
    }

    public Image getImage(Long photoId) throws ObjectNotFoundException {
        Optional<Image> image = photoRepository.findById(photoId);
        if (!image.isPresent()) {
            throw new ObjectNotFoundException(format("Photo not found by id: %s", photoId));
        }
        return image.get();
    }
    
    @Override
    public OriginalImage downloadOriginalImage(Long photoId) throws UnsupportedOperationException {
        Image image = getImage(photoId);
        image.setViews(image.getViews().add(BigInteger.ONE));
        photoRepository.update(image);
        
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    @Asynchronous
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public void uploadNewImage(Profile currentProfile, ImageResource imageResource, AsyncOperation<Image> asyncOperation) {
        try {
            Image image = null; //FIXME
            asyncOperation.onSuccess(image);
        } catch (Throwable throwable) {
            sessionContext.setRollbackOnly();
            asyncOperation.onFailed(throwable);
        }
    }

}
