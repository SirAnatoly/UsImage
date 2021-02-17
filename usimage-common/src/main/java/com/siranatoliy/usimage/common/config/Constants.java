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

package com.siranatoliy.usimage.common.config;

import java.util.concurrent.TimeUnit;

/**
 * Main constants
 * 
 * @author Anatoliy Kovalv
 * @version 1.0 
 */
public final class Constants {

    public static final long MAX_UPLOADED_PHOTO_SIZE_IN_BYTES = 10 * 1024 * 1024; // 10 Mb
    
    public static final long DEFAULT_ASYNC_OPERATION_TIMEOUT_IN_MILLIS = TimeUnit.SECONDS.toMillis(30);

    private Constants(){}
}
