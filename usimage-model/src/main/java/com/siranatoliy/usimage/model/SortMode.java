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
package com.siranatoliy.usimage.model;

import com.siranatoliy.usimage.exception.ValidationException;

/**
 * Enumeration class SortMode - Contains constants 
 * for sorting images on the main page of the application.
 * 
 * @author Anatoliy Kovalv
 * @version 1.0 
 */
public enum SortMode {

    POPULAR_PHOTO,
    
    POPULAR_AUTHOR;
    
/**
 * Returns an object of the class by String 
 */
    public static SortMode of(String name) {
        for(SortMode sortMode : SortMode.values()) {
            if(sortMode.name().equalsIgnoreCase(name)) {
                return sortMode;
            }
        }
        throw new ValidationException("Undefined sort mode: "+String.valueOf(name).toUpperCase());
    }
}
