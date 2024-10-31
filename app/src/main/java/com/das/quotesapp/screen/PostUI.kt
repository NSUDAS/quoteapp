package com.das.quotesapp.screen

import androidx.activity.viewModels
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.das.quotesapp.ui.theme.QuotesAppTheme
import com.das.quotesapp.viewmodel.BreedViewModel
import com.das.quotesapp.viewmodel.QuotesRandmonViewModel

/**
 * Created by S N Shekhar Das on 31/10/24.
 *
 */

@Preview
@Composable
fun PostUI(vm: QuotesRandmonViewModel  = hiltViewModel()) {
    val videos=vm.response.collectAsState()
  //  Surface {
     //   QuotesAppTheme {
            ConstraintLayout {
                LazyColumn(
                    contentPadding = PaddingValues(8.dp)
                ) {
                    items(8) { item ->
                        Card(onClick = {

                        }, modifier = Modifier
                            .padding(2.dp)) {
                           // CellDesign()
                        }

                    }
                }
            }
      //  }
    //}

}