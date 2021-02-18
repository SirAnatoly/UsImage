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

package com.siranatoliy.usimage.ejb.repository.mock;

import static com.siranatoliy.usimage.ejb.repository.mock.InMemoryDataBase.PROFILE;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Optional;
import javax.enterprise.context.ApplicationScoped;


/**
 * 
 * @author Anatoliy Kovalv
 * @version 1.0 
 */  
@ApplicationScoped
public class ProfileRepositoryInvocationHandler implements InvocationHandler{

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if("findByUid".equals(method.getName())) {
            String uid = String.valueOf(args[0]);
            if("jone-kare".equals(uid)) {
                return Optional.of(PROFILE);
            } else {
                return Optional.empty();
            }
        }
        throw new UnsupportedOperationException(String.format("Method %s not implemented yet", method));
    }
}

