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
package com.siranatoliy.usimage.exception;

/**
 * Description of the exception:
 * There was a problem at the moment of user authentication in the application.
 * 
 * @author Anatoliy Kovalv
 * @version 1.0 
 */
public class RetrieveSocialDataFailedException extends ApplicationException{

    public RetrieveSocialDataFailedException(String message) {
        super(message);
    }

    public RetrieveSocialDataFailedException(String message, Throwable cause) {
        super(message, cause);
    }

}
