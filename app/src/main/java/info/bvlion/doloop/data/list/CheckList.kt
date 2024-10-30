package info.bvlion.doloop.data.list

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import java.util.UUID

@Entity(
  tableName = "check_list",
  indices = [
    Index(
      value = ["order"],
      name = "index_check_list"
    )
  ]
)
data class CheckList(
  @PrimaryKey val uuid: String,
  val name: String,
  val order: Int
) {
  companion object {
    fun create(name: String, order: Int): CheckList =
      CheckList(UUID.randomUUID().toString(), name, order)
  }
}
