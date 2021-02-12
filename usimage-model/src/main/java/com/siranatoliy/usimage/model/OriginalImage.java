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

import java.io.InputStream;
import java.util.Objects;

/**
 * Represents the original image in the application.
 * 
 * @author Anatoliy Kovalv
 * @version 1.0 
 */  
public class OriginalImage {

    private final InputStream in;
    private final long size;
    private final String name;

    public OriginalImage(InputStream in, long size, String name) {
        this.in = Objects.requireNonNull(in);
        this.size = size;
        this.name = Objects.requireNonNull(name);
    }

    public InputStream getIn() {
        return in;
    }

    public long getSize() {
        return size;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "OriginalImage{" + "in=" + in + ", size=" + size + ", name=" + name + '}';
    }
}
