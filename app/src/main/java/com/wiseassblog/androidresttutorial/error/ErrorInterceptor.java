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

package com.wiseassblog.androidresttutorial.error;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Response;

/**
 * Created by R_KAY on 10/29/2017.
 */


public class ErrorInterceptor implements Interceptor {
    private static final ObjectMapper objectMapper = new ObjectMapper();
    @Override
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Response response = chain.proceed(chain.request());
        if (!response.isSuccessful()) {
            throw parseError(
                    response.code(),
                    response.message(),
                    response.body() != null ? response.body().string() : null
            );
        }
        return response;
    }

    private GitHubError parseError(int code, String message, String responseBody) throws IOException {
        if (responseBody == null) {
            return new UnexpectedApiError(code, message);
        }

        JsonNode errorJsonNode = objectMapper.readTree(responseBody).path("error");
        String errorCode = errorJsonNode.path("code").asText();
        String errorText = errorJsonNode.path("description").asText();
        return new UnexpectedApiError(code, message, errorCode, errorText);
    }
}
