package com.igp.studentservice.util;

import com.google.gson.Gson;
import lombok.experimental.UtilityClass;

@UtilityClass
public class RequestBodyReader {

    private final Gson GSON = new Gson();

    public <T> T getAsObject(String body, Class<T> clazz) {
        return GSON.fromJson(body, clazz);
    }
}
