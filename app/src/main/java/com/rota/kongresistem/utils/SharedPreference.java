package com.rota.kongresistem.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.rota.kongresistem.model.Items;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SharedPreference {

    public static final String PREFS_NAME = "PRODUCT_APP";
    public static final String FAVORITES = "Product_Favorite";

    public SharedPreference() {
        super();
    }

    // This four methods are used for maintaining favorites.
    public void saveFavorites(Context context, List<Items> favorites) {
        SharedPreferences settings;
        SharedPreferences.Editor editor;

        settings = context.getSharedPreferences(PREFS_NAME,
                Context.MODE_PRIVATE);
        editor = settings.edit();

        Gson gson = new Gson();
        String jsonFavorites = gson.toJson(favorites);

        editor.putString(FAVORITES, jsonFavorites);

        editor.commit();
    }

    public void addFavorite(Context context, Items product) {
        List<Items> favorites = getFavorites(context);
        if (favorites == null)
            favorites = new ArrayList<Items>();
        favorites.add(product);
        saveFavorites(context, favorites);
    }

    public void removeFavorite(Context context, Items product) {
        ArrayList<Items> favorites = getFavorites(context);
        if (favorites != null) {
            favorites.remove(product);
            saveFavorites(context, favorites);
        }
    }

    public ArrayList<Items> getFavorites(Context context) {
        SharedPreferences settings;
        List<Items> favorites;

        settings = context.getSharedPreferences(PREFS_NAME,
                Context.MODE_PRIVATE);

        if (settings.contains(FAVORITES)) {
            String jsonFavorites = settings.getString(FAVORITES, null);
            Gson gson = new Gson();
            Items[] favoriteItems = gson.fromJson(jsonFavorites,
                    Items[].class);

            favorites = Arrays.asList(favoriteItems);
            favorites = new ArrayList<Items>(favorites);
        } else
            return null;

        return (ArrayList<Items>) favorites;
    }
}