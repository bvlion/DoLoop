package info.bvlion.doloop.data.item

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
  tableName = "check_items",
  indices = [
    Index(
      value = ["parent_id", "order"],
      name = "index_check_items"
    )
  ]
)
data class CheckItem(
  @PrimaryKey(autoGenerate = true) val id: Int = 0,
  @ColumnInfo(name = "parent_id") val parentId: String,
  val name: String,
  val checked: Boolean = false,
  val order: Int
)