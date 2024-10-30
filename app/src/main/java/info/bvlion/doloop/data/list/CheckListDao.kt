package info.bvlion.doloop.data.list

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface CheckListDao {
  @Query("SELECT * FROM check_list ORDER BY `order` DESC")
  suspend fun selectCheckList(): List<CheckListWithItems>

  @Insert
  suspend fun insertCheckList(checkList: CheckList): Long

  @Query("UPDATE check_list SET name = :name WHERE uuid = :uuid")
  suspend fun updateNameForCheckList(uuid: String, name: String)

  @Query("UPDATE check_list SET `order` = :order WHERE uuid = :uuid")
  suspend fun updateOrderForCheckList(uuid: String, order: Int)
}