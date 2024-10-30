package info.bvlion.doloop.data.item

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface CheckItemDao {
  @Query("SELECT * FROM check_items WHERE parent_id = :parentId ORDER BY `order` DESC")
  suspend fun selectCheckItemsByParentId(parentId: String): List<CheckItem>

  @Insert
  suspend fun insertCheckItem(checkItem: CheckItem): Long

  @Insert
  suspend fun insertAllCheckItems(vararg checkItems: CheckItem)

  @Query("UPDATE check_items SET name = :name WHERE id = :id")
  suspend fun updateNameForCheckItem(id: Int, name: String)

  @Query("UPDATE check_items SET checked = :checked WHERE id = :id")
  suspend fun updateCheckedForCheckItem(id: Int, checked: Boolean)

  @Query("UPDATE check_items SET `order` = :order WHERE id = :id")
  suspend fun updateOrderForCheckItem(id: Int, order: Int)
}