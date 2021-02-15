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

package com.siranatoliy.usimage.model.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Entity Classes from Database
 * 
 * @author Anatoliy Kovalv
 * @version 1.0 
 */
@Entity
@Table(name = "ACCESS_TOKEN", catalog = "", schema = "ANATOLIY_ADMIN")

public class AccessToken extends AbstractDomain{
    
 private static final long serialVersionUID = 1L;
 
    @Id
    @Basic(optional = false)
    @Column(nullable = false, length = 4000)
    @NotNull
    private String token;
    
    
    @JoinColumn(name = "PROFILE_ID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @NotNull
    private Profile profileId;

    public AccessToken() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Profile getProfileId() {
        return profileId;
    }

    public void setProfileId(Profile profileId) {
        this.profileId = profileId;
    }
    
    
}
