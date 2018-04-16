package com.robertvargic.cryptochekerjava.networking;

import android.content.Context;
import android.support.annotation.NonNull;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitUtils {

    public static Retrofit createRetrofitForUrl(@NonNull Context context) throws KeyManagementException, NoSuchAlgorithmException {
        return createRetrofit(context);
    }

    private static final JsonSerializer<Date> DATE_JSON_SERIALIZER = new JsonSerializer<Date>() {

        @Override
        public JsonElement serialize(Date src, Type typeOfSrc, JsonSerializationContext
                context) {
            return src == null ? null : new JsonPrimitive(src.getTime());
        }
    };

    private static final JsonDeserializer<Date> DATE_JSON_DESERIALIZER = new JsonDeserializer<Date>() {

        @Override
        public Date deserialize(JsonElement json, Type typeOfT,
                                JsonDeserializationContext context) throws JsonParseException {
            return json == null ? null : new Date(json.getAsLong());
        }
    };

    private static Retrofit createRetrofit(@NonNull Context context) throws NoSuchAlgorithmException, KeyManagementException {
        return new Retrofit.Builder()
                .baseUrl("https://api.coinmarketcap.com/")
                .addConverterFactory(GsonConverterFactory.create(getGson()))
                .build();
    }

    public static Gson getGson() {
        return getCommonBuilder()
                .create();
    }

    private static GsonBuilder getCommonBuilder() {
        return new GsonBuilder()
//                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
                .registerTypeAdapter(Date.class, DATE_JSON_SERIALIZER)
                .registerTypeAdapter(Date.class, DATE_JSON_DESERIALIZER)
                .excludeFieldsWithoutExposeAnnotation();
    }
}
