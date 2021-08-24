package com.shahjahan.runningapp.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.shahjahan.runningapp.BaseApplication
import com.shahjahan.runningapp.db.RunningDatabase
import com.shahjahan.runningapp.other.Constants.RUNNING_DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideRunningDatabase(
        @ApplicationContext app: Context
    ) = Room.databaseBuilder(
            app,
            RunningDatabase::class.java,
            RUNNING_DATABASE_NAME
        ).build()

    @Singleton
    @Provides
    fun provideUserDao(db: RunningDatabase) = db.getRunDAO()
}