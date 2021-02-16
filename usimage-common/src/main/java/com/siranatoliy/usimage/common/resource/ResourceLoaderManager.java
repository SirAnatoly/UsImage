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

import com.siranatoliy.usimage.exception.ConfigException;
import java.io.IOException;
import java.io.InputStream;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;


/**
 * Loads any resources from any data sources
 * 
 * @author Anatoliy Kovalv
 * @version 1.0 
 */  
@ApplicationScoped
public class ResourceLoaderManager {

    @Inject
    @Any
    private Instance<ResourceLoader> resourceLoaders;

    public InputStream getResourceInputStream(String resourceName) throws IOException {
        for (ResourceLoader resourceLoader : resourceLoaders) {
            if (resourceLoader.isSupport(resourceName)) {
                return resourceLoader.getInputStream(resourceName);
            }
        }

        throw new ConfigException("Can't get input stream for resource: " + resourceName);
    }
}

