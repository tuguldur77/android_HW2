package com.example.eweek04a.uicomponents

import androidx.compose.material3.Checkbox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun TodoCheckbox(
    checked: Boolean,
    modifier: Modifier = Modifier,
    onCheckedChange: (Boolean) -> Unit
)  {
    Checkbox(
        checked = checked,
        onCheckedChange = { checked-> onCheckedChange(checked) /*Used for checking the checkbox
        for the todoitem /outside, and each item has a checkbox. */
        }

    )

}