package info.bvlion.doloop.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import info.bvlion.doloop.data.datastore.DoLoopDataStore
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataStoreModule {

  @Provides
  @Singleton
  fun provideDataStore(@ApplicationContext context: Context): DoLoopDataStore =
    DoLoopDataStore(context)
}