package com.igp.studentservice.util.path;

import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import lombok.experimental.UtilityClass;

import java.util.Map;
import java.util.Objects;

@UtilityClass
public class PathParameters {

    public String getPathParameter(APIGatewayProxyRequestEvent event, String key) {
        Objects.requireNonNull(event);
        Objects.requireNonNull(key);

        Map<String, String> pathParameters = event.getPathParameters();

        Objects.requireNonNull(pathParameters);

        String value = pathParameters.get(key);

        if (value == null)
            throw new IllegalArgumentException("The key specified isn't valid!");

        return value;
    }

    public <T> T getPathParameter(APIGatewayProxyRequestEvent event, String key, Class<T> clazz) {
        Objects.requireNonNull(clazz);

        String value = getPathParameter(event, key);

        if (value == null)
            throw new IllegalArgumentException("The key specified isn't valid!");

        return StringToTypeConversionFactory.convert(value, clazz);
    }
}
