package info.bvlion.doloop.ui.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import info.bvlion.doloop.ui.theme.DoLoopTheme

@Composable
fun BottomNav(
  selectedItem: MutableState<Int> = remember { mutableIntStateOf(0) },
  onSelected: (Int) -> Unit = {}
) {
  NavigationBar {
    BottomMenu.entries.forEachIndexed { index, item ->
      NavigationBarItem(
        icon = { Icon(item.icon, contentDescription = item.label) },
        label = { Text(item.label) },
        selected = selectedItem.value == index,
        onClick = {
          selectedItem.value = index
          onSelected(index)
        }
      )
    }
  }
}

private enum class BottomMenu(
  val icon: ImageVector,
  val label: String
) {
  Home(
    icon = Icons.Filled.CheckCircle,
    label = "チェック"
  ),
  List(
    icon = Icons.AutoMirrored.Filled.List,
    label = "一覧"
  ),
  Edit(
    icon = Icons.Filled.Edit,
    label = "作成"
  ),
  Menu(
    icon = Icons.Filled.Info,
    label = "メニュー"
  )
}

@Preview(showBackground = true)
@Composable
fun BottomNavigationPreview() {
  DoLoopTheme {
    BottomNav()
  }
}