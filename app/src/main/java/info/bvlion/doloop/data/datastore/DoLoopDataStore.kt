package info.bvlion.doloop.data.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class DoLoopDataStore(context: Context) {
  private val Context.dataStore: DataStore<Preferences> by preferencesDataStore("settings")
  private val settingsDataStore = context.dataStore

  val getViewType: Flow<Int> = settingsDataStore.data.map { it[VIEW_TYPE_KEY] ?: 0 }

  suspend fun setViewType(type: Int) = settingsDataStore.edit {
    it[VIEW_TYPE_KEY] = type
  }

  companion object {
    private val VIEW_TYPE_KEY = intPreferencesKey("view_type")
  }
}