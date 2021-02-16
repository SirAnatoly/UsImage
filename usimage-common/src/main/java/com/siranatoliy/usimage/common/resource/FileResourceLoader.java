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
package com.siranatoliy.usimage.common.resource;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.enterprise.context.ApplicationScoped;

/**
 * Loads resources by file name
 * 
 * @author Anatoliy Kovalv
 * @version 1.0 
 */ 
@ApplicationScoped
public class FileResourceLoader implements ResourceLoader {

    /**
     * 
     * @param resourceName - file
     */
    @Override
    public boolean isSupport(String resourceName) {
        try {
            return new File(resourceName).exists();
        } catch (RuntimeException e) {
            return false;
        }
    }

    @Override
    public InputStream getInputStream(String resourceName) throws IOException {
        return new FileInputStream(resourceName);
    }
}

