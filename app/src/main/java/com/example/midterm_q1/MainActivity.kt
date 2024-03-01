//package com.example.midterm_q1
//
//import android.os.Bundle
//import androidx.activity.ComponentActivity
//import androidx.activity.compose.setContent
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.text.KeyboardActions
//import androidx.compose.foundation.text.KeyboardOptions
//import androidx.compose.material3.*
//import androidx.compose.runtime.*
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.ExperimentalComposeUiApi
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.platform.LocalContext
//import androidx.compose.ui.platform.LocalDensity
//import androidx.compose.ui.platform.LocalSoftwareKeyboardController
//import androidx.compose.ui.platform.LocalTextInputService
//import androidx.compose.ui.res.stringResource
//import androidx.compose.ui.text.input.ImeAction
//import androidx.compose.ui.text.style.TextAlign
//import androidx.compose.ui.unit.dp
//import com.example.midterm_q1.ui.theme.MidTerm_Q1Theme
//
//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            MidTerm_Q1Theme {
//                // A surface container using the 'background' color from the theme
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colorScheme.background
//                ) {
//                    BinaryCalculator()
//                }
//            }
//        }
//    }
//}
//
//@OptIn(ExperimentalComposeUiApi::class)
//@Composable
//fun BinaryCalculator() {
//    var binaryNumber by remember { mutableStateOf("") }
//    var result by remember { mutableStateOf("") }
//    val context = LocalContext.current
//    val softwareKeyboardController = LocalSoftwareKeyboardController.current
//
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(16.dp),
//        horizontalAlignment = Alignment.CenterHorizontally,
//        verticalArrangement = Arrangement.Center
//    ) {
//        // Input Field
//        OutlinedTextField(
//            value = binaryNumber,
//            onValueChange = {
//                // Validate input to only allow 0 and 1
//                if (it.all { char -> char == '0' || char == '1' }) {
//                    binaryNumber = it
//                }
//            },
//            label = { Text(text = "Binary Number") },
//            keyboardOptions = KeyboardOptions.Default.copy(
//                imeAction = ImeAction.Done
//            ),
//            keyboardActions = KeyboardActions(
//                onDone = {
//                    // Perform the calculation when the user presses Done
////                    calculateResult()
//                    softwareKeyboardController?.hide()
//                }
//            ),
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(bottom = 16.dp)
//        )
//
//        // Result Text
//        Text(
//            text = result,
////            style = MaterialTheme.typography.h5,
//            color = Color.Black,
//            modifier = Modifier
//                .background(MaterialTheme.colorScheme.primary)
//                .padding(8.dp)
//                .fillMaxWidth()
//                .height(50.dp)
//                .padding(bottom = 16.dp),
//            textAlign = TextAlign.Center
//        )
//
//        // Buttons for addition and subtraction
//        Row(
//            modifier = Modifier.fillMaxWidth(),
//            horizontalArrangement = Arrangement.SpaceBetween
//        ) {
//            BinaryCalculationButton(
//                text = "+",
//                onClick = { performOperation('+') }
//            )
//            BinaryCalculationButton(
//                text = "-",
//                onClick = { performOperation('-') }
//            )
//        }
//    }
//}
//
//@Composable
//fun BinaryCalculationButton(text: String, onClick: () -> Unit) {
//    Button(
//        onClick = onClick,
//        modifier = Modifier
//            .padding(8.dp)
//            .width(80.dp)
//    ) {
//        Text(text = text)
//    }
//}
//
//@Composable
//fun ColumnScope.performOperation(operator: Char, one: String,two: String) {
//    // Handle addition or subtraction based on the operator
//    val binaryNumber = remember { mutableStateOf("") }
//    var result = remember { mutableStateOf("") }
//    if(operator == '+'){
//        result = addBinary(one,two)
//    }
//    else{
//       result = subtractBinary(one,two)
//    }
//    result.value = binaryNumber.value
//}
//
//
//fun addBinary(binary1: String, binary2: String): MutableState<String> {
//    val maxLength = maxOf(binary1.length, binary2.length)
//    val paddedBinary1 = binary1.padStart(maxLength, '0')
//    val paddedBinary2 = binary2.padStart(maxLength, '0')
//
//    var carry = 0
//    var result = StringBuilder()
//
//    for (i in maxLength - 1 downTo 0) {
//        val bit1 = paddedBinary1[i].toString().toInt()
//        val bit2 = paddedBinary2[i].toString().toInt()
//
//        val sum = bit1 + bit2 + carry
//        result.insert(0, sum % 2)
//        carry = sum / 2
//    }
//
//    if (carry != 0) {
//        result.insert(0, carry)
//    }
//
//    return (result.toString()) as MutableState<String>
//}
//
//fun subtractBinary(binary1: String, binary2: String): MutableState<String> {
//    val maxLength = maxOf(binary1.length, binary2.length)
//    val paddedBinary1 = binary1.padStart(maxLength, '0')
//    val paddedBinary2 = binary2.padStart(maxLength, '0')
//
//    var borrow = 0
//    var result = StringBuilder()
//
//    for (i in maxLength - 1 downTo 0) {
//        val bit1 = paddedBinary1[i].toString().toInt()
//        val bit2 = paddedBinary2[i].toString().toInt()
//
//        var diff = bit1 - bit2 - borrow
//
//        if (diff < 0) {
//            diff += 2
//            borrow = 1
//        } else {
//            borrow = 0
//        }
//
//        result.insert(0, diff)
//    }
//
//    return (result.toString().trimStart { it == '0' }.takeIf { it.isNotEmpty() } ?: "0") as MutableState<String>
//}
//



package com.example.midterm_q1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.platform.LocalTextInputService
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.midterm_q1.ui.theme.MidTerm_Q1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MidTerm_Q1Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BinaryCalculator()
                }
            }
        }
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun BinaryCalculator() {
    var binaryNumber by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }
    val context = LocalContext.current
    val softwareKeyboardController = LocalSoftwareKeyboardController.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Input Field
        OutlinedTextField(
            value = binaryNumber,
            onValueChange = {
                // Validate input to only allow 0 and 1
                if (it.all { char -> char == '0' || char == '1' }) {
                    binaryNumber = it
                }
            },
            label = { Text(text = "Binary Number") },
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = {
                    // Perform the calculation when the user presses Done
                    // Pass the binaryNumber to the performOperation function
//                    performOperation('+', binaryNumber)
                    softwareKeyboardController?.hide()
                }
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )

        // Result Text
        Text(
            text = result,
            color = Color.Black,
            modifier = Modifier
                .background(MaterialTheme.colorScheme.primary)
                .padding(8.dp)
                .fillMaxWidth()
                .height(50.dp)
                .padding(bottom = 16.dp),
            textAlign = TextAlign.Center
        )

        // Buttons for addition and subtraction
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            BinaryCalculationButton(
                text = "+",
//                onClick = { performOperation('+', binaryNumber) }
                onClick = {}
            )
            BinaryCalculationButton(
                text = "-",
//                onClick = { performOperation('-', binaryNumber) }
                onClick = {}
            )
        }
    }
}

@Composable
fun BinaryCalculationButton(text: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .padding(8.dp)
            .width(80.dp)
    ) {
        Text(text = text)
    }
}

@Composable
fun performOperation(operator: Char, binaryNumber: String) {
    val one = "1101"
    val two = "1011"
    val result = if (operator == '+') {
        addBinary(one, two)
    } else {
        subtractBinary(one, two)
    }
    result.value = binaryNumber
}

fun addBinary(binary1: String, binary2: String): MutableState<String> {
    val maxLength = maxOf(binary1.length, binary2.length)
    val paddedBinary1 = binary1.padStart(maxLength, '0')
    val paddedBinary2 = binary2.padStart(maxLength, '0')

    var carry = 0
    val result = StringBuilder()

    for (i in maxLength - 1 downTo 0) {
        val bit1 = paddedBinary1[i].toString().toInt()
        val bit2 = paddedBinary2[i].toString().toInt()

        val sum = bit1 + bit2 + carry
        result.insert(0, sum % 2)
        carry = sum / 2
    }

    if (carry != 0) {
        result.insert(0, carry)
    }

    return mutableStateOf(result.toString())
}

fun subtractBinary(binary1: String, binary2: String): MutableState<String> {
    val maxLength = maxOf(binary1.length, binary2.length)
    val paddedBinary1 = binary1.padStart(maxLength, '0')
    val paddedBinary2 = binary2.padStart(maxLength, '0')

    var borrow = 0
    val result = StringBuilder()

    for (i in maxLength - 1 downTo 0) {
        val bit1 = paddedBinary1[i].toString().toInt()
        val bit2 = paddedBinary2[i].toString().toInt()

        var diff = bit1 - bit2 - borrow

        if (diff < 0) {
            diff += 2
            borrow = 1
        } else {
            borrow = 0
        }

        result.insert(0, diff)
    }

    return mutableStateOf(result.toString().trimStart { it == '0' }.takeIf { it.isNotEmpty() } ?: "0")
}
