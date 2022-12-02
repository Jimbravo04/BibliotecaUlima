package pe.edu.ulima.pm.demoextrasapp.ui.modules.library

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.runtime.internal.composableLambdaInstance
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import pe.edu.ulima.pm.demoextrasapp.ui.viewModels.LibraryViewModel

@Composable
fun BookCommentaries(
    bookId: Int?, libraryViewModel: LibraryViewModel, navigatorController: NavHostController
) {

    var textValue by remember { mutableStateOf("") }
    var stock by remember {
        mutableStateOf(0)
    }

    var commentaries = remember {
        mutableStateListOf<String>()
    }

    val lifecycleOwner = LocalLifecycleOwner.current
    val book = libraryViewModel.book.observeAsState()

    val focusRequester = remember { FocusRequester() }
    val focusManager = LocalFocusManager.current


    val addCommentary: () -> Unit = {
        if (textValue.isNotEmpty()) {
            commentaries.add(textValue)
            textValue = String()
        }
        focusManager.clearFocus()
    }

    LaunchedEffect(key1 = Unit, block = {
        if (bookId == null) {
            return@LaunchedEffect;
        }
        libraryViewModel.getBook(bookId)
        libraryViewModel.book.observe(lifecycleOwner) { it ->
            stock = it.dispo
        }
    })

    Column(
        Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp, horizontal = 5.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {

        Spacer(modifier = Modifier.width(16.dp))
        Column(
            Modifier
                .width(260.dp)
                .height(150.dp)
                .background(MaterialTheme.colors.primary)
                .clip(RoundedCornerShape(5.dp))
                .border(width = 2.dp, Color.Black),


        ) {
            Text(text = "Usuario N°1: ", fontSize = 30.sp, textAlign = TextAlign.Center)
            Spacer(modifier = Modifier.width(16.dp))

            Text(
                text = book.value!!.coment,

                Modifier
                    .background(Color.White)
                    .border(width = 2.dp, Color.White),
                fontSize = 15.sp,
            )
            Spacer(modifier = Modifier.width(32.dp))
        }

        LazyColumn {
            items(commentaries) { commentary ->
                Text(commentary)
            }
        }

        TextField(value = textValue,
            modifier = Modifier
                .width(260.dp)
                .height(50.dp)
                .focusRequester(focusRequester),
            onValueChange = { textValue = it },
            label = { Text("Ingresa un comentario") })

        Spacer(modifier = Modifier.width(16.dp))

        Row {
            Button(onClick = { addCommentary() }) {
                Text("PUBLICAR")
            }
        }
    }
}