package com.jesusmoreira.comicteca.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.LiveData

@Composable
fun <T> Input(value: T, onChange: (T) -> Unit) {
    /* ... */
}

@Composable
fun <T> ValidateInput(value: T, onChange: (T) -> Unit, isValid: Boolean) {
//    InputDecoration(color=if(isValid) blue else red) {
        Input(value, onChange)
//    }
}

@Composable
fun DateInput(value: DateTime, onChange: (DateTime) -> Unit) {
    ValidateInput(
            value = value,
            onChange = { onChange(it) },
            isValid = isValidDate(value)
    )
}

@Composable
fun DateRangeInput(value: DateRange, onChange: (DateRange) -> Unit) {
    DateInput(value = value.start, onChange = { /* ... */ })
    DateInput(value = value.end, onChange = { /* ... */ })
}

class DateTime()
data class DateRange(var start: DateTime, var end: DateTime)

fun isValidDate(value: DateTime) = true

@Composable
fun FancyBox(children: @Composable () -> Unit) {
    val fancy = Modifier
    Box(fancy) { children() }
}

@Composable fun Story(/* ... */) { /* ... */ }
@Composable fun EditForm(/* ... */) { /* ... */ }
@Composable fun FancyStory(/* ... */) {
    FancyBox { Story() }
}
@Composable fun FancyEditForm(/* ... */) {
    FancyBox { EditForm() }
}

@Composable
fun LiveDataComponent(liveMsgs: LiveData<List<MessageData>>) {
    val msgs by liveMsgs.observeAsState(initial = emptyList())
    for (msg in msgs) {
        Message(msg)
    }
}

@Composable
fun Message(message: MessageData) {

}

class MessageData {

}
