package com.example.bankingapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bankingapp.ui.theme.BankingAppTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BankingAppTheme {

                SetBarColor(color = MaterialTheme.colorScheme.background)
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ){

                    HomeScreen()

                }
            }

        }
    }

    @Composable
    private fun SetBarColor(color: Color){ // this for the upbar(above the top bar) where we have time battery ... (to take the same color as the background of the main UI)
                                          // I need to implement the dependencies com.google.accompanist:accompanist-systemuicontroller:0.27.0
        val systemUiController = rememberSystemUiController()
        SideEffect {
            systemUiController.setSystemBarsColor(
                color = color
            )
        }
    }
}

@Preview(showBackground = true,
    showSystemUi = true)
@Composable
fun HomeScreen(){
    Scaffold(
        bottomBar = {
            BottomNavigationBar()
        }
    ){ padding ->

        Column(
            modifier = Modifier.fillMaxSize()
                .padding(padding)
        ) {

        WalletSection()
        CardsSection()
        Spacer(modifier = Modifier.height(16.dp))
//        FinanceSection()
//        CurrenciesSection()
        }
    }
}
