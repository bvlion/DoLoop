package info.bvlion.doloop.data.list

import androidx.room.Embedded
import androidx.room.Relation
import info.bvlion.doloop.data.item.CheckItem

data class CheckListWithItems(
  @Embedded val checkList: CheckList,
  @Relation(
    parentColumn = "uuid",
    entityColumn = "parent_id"
  )
  val items: List<CheckItem>
)
