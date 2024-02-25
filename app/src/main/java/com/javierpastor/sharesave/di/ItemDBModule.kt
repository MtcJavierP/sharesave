package com.javierpastor.sharesave.di



import android.content.Context
import androidx.room.Room
import com.javierpastor.sharesave.bbdd.repositorioBD.ItemDBHelper
import com.javierpastor.sharesave.bbdd.repositorioBD.OfertaRepository
import com.javierpastor.sharesave.bbdd.room.AppDatabase
import com.javierpastor.sharesave.bbdd.room.ItemDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "app_database"
        ).build()
    }

    @Provides
    fun provideItemDao(database: AppDatabase): ItemDao {
        return database.itemDao()
    }


}

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun provideOfertaRepository(dbHelper: ItemDBHelper): OfertaRepository {
        return OfertaRepository(dbHelper)
    }
}