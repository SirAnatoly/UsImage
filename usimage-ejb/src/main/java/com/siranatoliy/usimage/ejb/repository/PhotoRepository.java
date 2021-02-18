

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

package com.siranatoliy.usimage.ejb.repository;

import com.siranatoliy.usimage.model.domain.Image;
import java.util.List;

/**
 * 
 * @author Anatoliy Kovalv
 * @version 1.0 
 */  
public interface PhotoRepository extends EntityRepository<Image, Long>{

    List<Image> findProfileImagesLatestFirst(Long profileId, int offset, int limit);
    
    int countProfileImages(Long profileId);
    
    List<Image> findAllOrderByViewsDesc(int offset, int limit);
    
    List<Image> findAllOrderByAuthorRatingDesc(int offset, int limit);
    
    long countAll();
}
