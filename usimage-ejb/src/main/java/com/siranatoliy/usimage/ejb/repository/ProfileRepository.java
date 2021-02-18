
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

import com.siranatoliy.usimage.model.domain.Profile;
import java.util.List;
import java.util.Optional;

/**
 * 
 * @author Anatoliy Kovalv
 * @version 1.0 
 */  
public interface ProfileRepository extends EntityRepository<Profile, Long>{

    Optional<Profile> findByUid(String uid);
    
    Optional<Profile> findByEmail(String email);
    
    /**
     * Calling procedure from DB
     */
    void updateRating();
    
    List<String> findUids(List<String> uids);
}
