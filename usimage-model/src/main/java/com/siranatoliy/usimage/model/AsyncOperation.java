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

/**
 * Methods for uploading new images or uploading / updating an user's avatar
 * 
 * @author Anatoliy Kovalv
 * @version 1.0 
 */ 
public interface AsyncOperation<T> {

/**
 * Returns the operation timeout in milliseconds.
 */
    long getTimeOutInMillis();

/**
 * Returns an object on successful asynchronous operation.
 */
    void onSuccess(T result);

/**
 * Returns an exception on unsuccessful asynchronous operation.
 */    
    void onFailed(Throwable throwable);
}
