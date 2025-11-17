package ru.sumin.testtask.core.database.di

import androidx.room.Room
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import ru.sumin.testtask.core.database.FavouriteDatabase

val databaseModule = module {

    single {
        Room.databaseBuilder(
            androidContext(),
            FavouriteDatabase::class.java,
            "main.db"
        ).build()
    }

    single {
        get<FavouriteDatabase>().favoritesDao()
    }
}