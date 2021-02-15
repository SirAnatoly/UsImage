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

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
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
@Table(catalog = "", schema = "ANATOLIY_ADMIN")
public class Image extends AbstractDomain {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @Column(unique = true, nullable = false, precision = 19, scale = 0, updatable = false)
    @SequenceGenerator(name = "image_generator", sequenceName = "﻿IMAGE_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "image_generator")
    private BigDecimal id;

    @NotNull
    @Size(max = 255)    
    @Basic(optional = false)
    @Column(name = "SMALL_URL", nullable = false, length = 255, updatable = false)
    private String smallUrl;

    @NotNull
    @Size(max = 255)    
    @Basic(optional = false)
    @Column(name = "LARGE_URL", nullable = false, length = 255, updatable = false)
    private String largeUrl;

    @NotNull
    @Size(max = 255)    
    @Basic(optional = false)
    @Column(name = "ORIGINAL_URL", nullable = false, length = 255, updatable = false)
    private String originalUrl;

    @Min(0)    
    @Basic(optional = false)
    @Column(nullable = false)
    private BigInteger views;

    @Min(0)    
    @Basic(optional = false)
    @Column(nullable = false)
    private BigInteger downloads;
    
    
    @JoinColumn(name = "PROFILE_ID", referencedColumnName = "ID", nullable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Profile profileId;

    public Image() {
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getSmallUrl() {
        return smallUrl;
    }

    public void setSmallUrl(String smallUrl) {
        this.smallUrl = smallUrl;
    }

    public String getLargeUrl() {
        return largeUrl;
    }

    public void setLargeUrl(String largeUrl) {
        this.largeUrl = largeUrl;
    }

    public String getOriginalUrl() {
        return originalUrl;
    }

    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }

    public BigInteger getViews() {
        return views;
    }

    public void setViews(BigInteger views) {
        this.views = views;
    }

    public BigInteger getDownloads() {
        return downloads;
    }

    public void setDownloads(BigInteger downloads) {
        this.downloads = downloads;
    }

    public Profile getProfileId() {
        return profileId;
    }

    public void setProfileId(Profile profileId) {
        this.profileId = profileId;
    }
    
    
}
