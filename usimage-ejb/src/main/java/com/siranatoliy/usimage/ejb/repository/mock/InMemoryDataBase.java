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

package com.siranatoliy.usimage.ejb.repository.mock;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Random;
import com.siranatoliy.usimage.model.domain.Image;
import com.siranatoliy.usimage.model.domain.Profile;
import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * 
 * @author Anatoliy Kovalv
 * @version 1.0 
 */  
public final class InMemoryDataBase {
    
    public static final Profile PROFILE;
    
    public static final List<Image> IMAGES;
    
    static {
        PROFILE = createProfile();
        IMAGES = createImages(PROFILE);
    }
    
    private static Profile createProfile() {
        Profile profile = new Profile();
        profile.setId(BigDecimal.ONE);
        profile.setUid("jone-kare");
        profile.setCreated(new Date());
        profile.setFirstName("Jone");
        profile.setLastName("Kare");
        profile.setJobTitle("Architectural designer");
        profile.setLocation("Kiev, Ukraine");
        profile.setAvatarUrl("https://fv2-1.failiem.lv/thumb_show.php?i=b8sfvwcva&view&download_checksum=bab7f95dc52ad0c8fa82debfbbf611096b525a21&download_timestamp=1613642529");
        return profile;
    }
    
    private static List<Image> createImages(Profile profile) {
        Random random = new Random();
        List<Image> photos = new ArrayList<>();
        for (int i = 1; i <= 15; i++) {
            Image photo = new Image();
            photo.setProfileId(profile);
            profile.setImageCount(profile.getImageCount() + 1);
            photo.setSmallUrl("https://www.funservicesneia.com/wp-content/uploads/2015/06/400x250.gif");
            photo.setLargeUrl("https://static.dezeen.com/uploads/2021/01/reversible-architecture-design-recycled-reused_dezeen_2364_col_0-852x479.jpg");
            photo.setOriginalUrl("https://static.dezeen.com/uploads/2021/01/reversible-architecture-design-recycled-reused_dezeen_2364_col_0-852x479.jpg");
            photo.setViews(BigInteger.valueOf(random.nextInt(100) * 10 + 1));
            photo.setDownloads(BigInteger.valueOf(random.nextInt(20) * 10 + 1));
            photo.setCreated(new Date());
            photos.add(photo);
        }
        return Collections.unmodifiableList(photos);
    }
    
    private InMemoryDataBase() {
    }
}
