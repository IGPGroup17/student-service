package com.igp.studentservice.util.path;

import lombok.experimental.UtilityClass;

@SuppressWarnings("unchecked")
@UtilityClass
public class StringToTypeConversionFactory {

    public <T> T convert(String value, Class<T> clazz) {

        if (clazz == String.class)
            return (T) value;
        else if (clazz == Object.class)
            return (T) value;
        else if (clazz == Integer.class || clazz == int.class)
            return (T) castToInt(value);
        else if (clazz == Float.class || clazz == float.class)
            return (T) castToFloat(value);
        else if (clazz == Double.class || clazz == double.class)
            return (T) castToDouble(value);
        else if (clazz == Boolean.class || clazz == boolean.class)
            return (T) castToBoolean(value);
        else if (clazz == Long.class || clazz == long.class)
            return (T) castToLong(value);
        else
            throw new InvalidTypeException("Cannot specify this type!");
    }

    private Integer castToInt(String value) {
        try {
            return Integer.valueOf(value);
        } catch (NumberFormatException e) {
            throw new InvalidTypeException(e);
        }
    }

    private Float castToFloat(String value) {
        try {
            return Float.valueOf(value);
        } catch (NumberFormatException e) {
            throw new InvalidTypeException(e);
        }
    }

    private Double castToDouble(String value) {
        try {
            return Double.valueOf(value);
        } catch (NumberFormatException e) {
            throw new InvalidTypeException(e);
        }
    }

    private Boolean castToBoolean(String value) {
        String lowerCast = value.toLowerCase();
        return lowerCast.equals("yes") || lowerCast.equals("y") || lowerCast.equals("true") || lowerCast.equals("t");
    }

    private Long castToLong(String value) {
        try {
            return Long.valueOf(value);
        } catch (NumberFormatException e) {
            throw new InvalidTypeException(e);
        }
    }
}
