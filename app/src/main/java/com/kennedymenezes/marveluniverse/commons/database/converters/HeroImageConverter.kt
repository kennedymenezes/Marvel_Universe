package com.kennedymenezes.marveluniverse.commons.database.converters

import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.google.gson.Gson
import com.kennedymenezes.marveluniverse.dashboard.data.model.HeroImage


class HeroImageConverter {
    @TypeConverter
    fun appToString(heroImage: HeroImage): String = Gson().toJson(heroImage)

    @TypeConverter
    fun stringToApp(string: String): HeroImage = Gson().fromJson(string, HeroImage::class.java)
}