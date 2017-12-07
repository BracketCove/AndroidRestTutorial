/*
 * *
 *  * Copyright (C) 2017 Ryan Kay Open Source Project
 *  *
 *  * Licensed under the Apache License, Version 2.0 (the "License");
 *  * you may not use this file except in compliance with the License.
 *  * You may obtain a copy of the License at
 *  *
 *  *      http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  * See the License for the specific language governing permissions and
 *  * limitations under the License.
 *
 */

package com.wiseassblog.androidresttutorial.datamodel;

import com.squareup.moshi.Json;

import java.security.acl.Owner;

/**
 * Note: This is not a Repository Pattern! It just happens that our DataModel is a Repository lol.
 * Check out RepositoryDataSourceImpl.java for the actual Repository/Facade Pattern in action.
 *
 * Primary DataModel for this Application.
 * Our REST Adapter will convert JSON from the REST endpoint into this POJO.
 *
 * Fortunately, we don't need to have a DataModel to represent all JSON Objects we could potentially
 * return from the endpoint. Just what we need.
 * Created by R_KAY on 10/29/2017.
 */

public class RepositoryDataModel {
    /*
    Why the ugly variable name? This is the same name as what will be returned in our JSON data,
    which doesn't follow camel case. This is how our serialization library will know which
    members (I think that's the JSON name for key/value pairs...) to bind to our DataModel Here.

    Note that most serialization Libs can be configured to map from a name like "avatar_url" to
    "avatarUrl" using annotations and other wizardry.
     */
    final String description;

    @Json(name = "created_at")
    final String created_at;
    final Owner owner;

    public RepositoryDataModel(Owner owner, String description, String created_at) {
        this.owner = owner;
        this.description = description;
        this.created_at = created_at;
    }

    public String getAvatarUrl() {
        return owner.getAvatar_url();
    }

    public String getDescription() {
        return description;
    }

    public String getCreated_at() {
        return created_at;
    }

    static class Owner {
        final String avatar_url;

        public Owner(String avatar_url) {
            this.avatar_url = avatar_url;
        }

        public String getAvatar_url() {
            return avatar_url;
        }
    }
}
