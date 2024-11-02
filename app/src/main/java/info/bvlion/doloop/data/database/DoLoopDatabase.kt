package info.bvlion.doloop.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import info.bvlion.doloop.data.item.CheckItem
import info.bvlion.doloop.data.item.CheckItemDao
import info.bvlion.doloop.data.list.CheckList
import info.bvlion.doloop.data.list.CheckListDao

@Database(
  entities = [
    CheckItem::class,
    CheckList::class
  ],
  version = 1
)
abstract class DoLoopDatabase : RoomDatabase() {

  abstract fun checkItemDao(): CheckItemDao

  abstract fun checkListDao(): CheckListDao
}