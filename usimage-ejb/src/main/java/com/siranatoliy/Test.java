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
package com.siranatoliy;

/**
 * @author Anatoliy Kovalv
 * @version 1.0 
 */ 

import com.siranatoliy.usimage.common.annotation.cdi.PropertiesSource;
import com.siranatoliy.usimage.common.annotation.cdi.Property;
import java.util.Properties;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;


@Singleton
@Startup
public class Test {

    @Inject
    @Property("usimage.host")
    private String host;

    @Inject
    @PropertiesSource("classpath:application.properties")
    private Properties properties;

    @PostConstruct
    private void postConstruct() {
        System.out.println("-----------host=" + host + ", properties=" + properties);
    }
}
