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

import com.siranatoliy.usimage.model.validation.Email;
import com.siranatoliy.usimage.model.validation.EnglishLanguage;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Entity Classes from Database
 * 
 * @author Anatoliy Kovalv
 * @version 1.0 
 */

@Entity
@Table(catalog = "", schema = "ANATOLIY_ADMIN", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"EMAIL"}),
    @UniqueConstraint(columnNames = {"uid"})})
public class Profile extends AbstractDomain{

    private static final long serialVersionUID = 1L;
   
    @Id
    @Basic(optional = false)
    @Column(unique = true, nullable = false, precision = 19, scale = 0, updatable = false)
    @SequenceGenerator(name = "profile_generator", sequenceName = "﻿PROFILE_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "profile_generator")
    private BigDecimal id;
    
    @NotNull
    @Size(max = 255)
    @Basic(optional = false)
    @Column(unique = true, nullable = false, length = 255, updatable = false)
    private String uid;
    
    @Email
    @NotNull
    @Size(max = 100)
    @Basic(optional = false)
    @Column(unique = true, nullable = false, length = 100, updatable = false)
    private String email;
    
    @NotNull(message = "{Profile.firstName.NotNull}")
    @Size(min = 1, max = 60, message = "{Profile.firstName.Size}")
    @EnglishLanguage(withNumbers = false, withSpecialSymbols = false)   
    @Basic(optional = false)
    @Column(name = "FIRST_NAME", nullable = false, length = 60)
    private String firstName;

    @NotNull(message = "{Profile.lastName.NotNull}")
    @Size(min = 1, max = 60, message = "{Profile.lastName.Size}")
    @EnglishLanguage(withNumbers = false, withSpecialSymbols = false)    
    @Basic(optional = false)
    @Column(name = "LAST_NAME", nullable = false, length = 60)
    private String lastName;
    
    @NotNull
    @Size(max = 255)    
    @Basic(optional = false)
    @Column(name = "AVATAR_URL", nullable = false, length = 255)
    private String avatarUrl;

    @NotNull(message = "{Profile.jobTitle.NotNull}")
    @Size(min = 5, max = 100, message = "{Profile.jobTitle.Size}")
    @EnglishLanguage(withSpecialSymbols = false)    
    @Basic(optional = false)
    @Column(name = "JOB_TITLE", nullable = false, length = 100)
    private String jobTitle;
    

    @NotNull(message = "{Profile.location.NotNull}")
    @Size(min = 5, max = 100, message = "{Profile.location.Size}")
    @EnglishLanguage(withSpecialSymbols = false)    
    @Basic(optional = false)
    @Column(nullable = false, length = 100)
    private String location;
   
    @Min(0)    
    @Basic(optional = false)
    @Column(name = "IMAGE_COUNT", nullable = false)
    private long imageCount;
    
    @Min(0)    
    @Basic(optional = false)
    @Column(nullable = false)
    private long rating;

    public Profile() {
    }
    
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public BigDecimal getId() {
        return id;
    }

    public String getUid() {
        return uid;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public String getLocation() {
        return location;
    }

    public long getImageCount() {
        return imageCount;
    }

    public long getRating() {
        return rating;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setImageCount(long imageCount) {
        this.imageCount = imageCount;
    }

    public void setRating(long rating) {
        this.rating = rating;
    }
    
    
}
