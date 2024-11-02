package info.bvlion.doloop.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import info.bvlion.doloop.data.database.DoLoopDatabase
import info.bvlion.doloop.data.item.CheckItemDao
import info.bvlion.doloop.data.list.CheckListDao
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

  @Provides
  @Singleton
  fun provideDatabase(@ApplicationContext context: Context): DoLoopDatabase {
    return Room.databaseBuilder(
      context,
      DoLoopDatabase::class.java,
      "DoLoop.db"
    ).build()
  }

  @Provides
  fun provideCheckItemDao(database: DoLoopDatabase): CheckItemDao {
    return database.checkItemDao()
  }

  @Provides
  fun provideCheckListDao(database: DoLoopDatabase): CheckListDao {
    return database.checkListDao()
  }
}