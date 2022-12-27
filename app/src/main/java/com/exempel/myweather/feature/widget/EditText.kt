package com.exempel.myweather.feature.widget

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.VisualTransformation

@Composable
fun EditText(
    text: String,
    onChangeText:(String)->Unit,
    label:String,
    textStyle: TextStyle,
    modifier: Modifier = Modifier,
    shape: RoundedCornerShape = RoundedCornerShape(10),
    isError: Boolean = false,
    read: Boolean = false,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    visualTransformation: VisualTransformation = VisualTransformation.None,
) {

}