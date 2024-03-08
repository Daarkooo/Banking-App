package com.example.bankingapp

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.*
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bankingapp.Data.Currency
import com.example.bankingapp.ui.theme.GreenStart

val currencies = listOf(
    Currency(
        name = "USD",
        buy = 24.53f,
        sell = 25.01f,
        icon = Icons.Rounded.AttachMoney
    ),

    Currency(
        name = "EUR",
        buy = 34.53f,
        sell = 35.01f,
        icon = Icons.Rounded.Euro
    ),

    Currency(
        name = "YEN",
        buy = 19.53f,
        sell = 18.91f,
        icon = Icons.Rounded.CurrencyYen
    ),

    Currency(
        name = "USD",
        buy = 74.53f,
        sell = 81.01f,
        icon = Icons.Rounded.AttachMoney
    ),

    Currency(
        name = "EUR",
        buy = 54.53f,
        sell = 54.41f,
        icon = Icons.Rounded.Euro
    ),

    Currency(
        name = "YEN",
        buy = 49.53f,
        sell = 49.25f,
        icon = Icons.Rounded.CurrencyYen
    ),
)

@Preview
@Composable
fun CurrenciesSection(){
    var isVisible by remember {
        mutableStateOf(falsea) // need to be false at first (true just for testing)
    }
    var iconsState by remember {
        mutableStateOf(Icons.Rounded.KeyboardArrowUp) // before open the currencies tab
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 16.dp),
        contentAlignment = Alignment.BottomCenter
    ){

        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
                .background(MaterialTheme.colorScheme.inverseOnSurface)
                .animateContentSize() // do animation when opening and closing
        ){

            Row(
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 16.dp)
                    .animateContentSize()
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ){

                Box(
                    modifier = Modifier
                        .clip(CircleShape)
                        .background(MaterialTheme.colorScheme.secondary)
                        .clickable {
                            isVisible = !isVisible
                            iconsState = if(isVisible){
                                Icons.Rounded.KeyboardArrowDown
                            }else{
                                Icons.Rounded.KeyboardArrowUp
                            }

                        }
                ){
                    Icon(
                        modifier = Modifier.size(24.dp),
                        imageVector = iconsState,
                        contentDescription = "Currencies",
                        tint = MaterialTheme.colorScheme.onSecondary
                    )
                }

                Spacer(modifier = Modifier.width(20.dp))

                Text(
                    text = "Currencies",
                    fontSize = 20.sp,
                    color = MaterialTheme.colorScheme.onSecondaryContainer,
                    fontWeight = FontWeight.Bold
                )

            }

            Spacer(
                modifier = Modifier
                    .height(1.dp)
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.secondary)
            )

            if(isVisible){
                BoxWithConstraints(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 16.dp)
                        .clip(RoundedCornerShape(topStart = 25.dp, topEnd = 25.dp))
                        .background(MaterialTheme.colorScheme.background)
                ) {

                    val boxWithConstraintsScope = this
                    val width = boxWithConstraintsScope.maxWidth / 3 // the 3 column take the same size (3 parts equals)

                    Column(modifier = Modifier.fillMaxWidth()
                        .padding(horizontal = 16.dp)
                    ){

                        Spacer(modifier = Modifier.height(16.dp))

                        Row(
                            modifier = Modifier.fillMaxWidth()
                        ){

                            Text(
                                modifier = Modifier.width(width),
                                text = "Currency",
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 16.sp,
                                color = MaterialTheme.colorScheme.onBackground
                            )

                            Text(
                                modifier = Modifier.width(width),
                                text = "Buy",
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 16.sp,
                                color = MaterialTheme.colorScheme.onBackground,
                                textAlign = TextAlign.End, // align the text at the end for better UI for both Buy & Sell
                            )

                            Text(
                                modifier = Modifier.width(width),
                                text = "Sell",
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 16.sp,
                                color = MaterialTheme.colorScheme.onBackground,
                                textAlign = TextAlign.End,
                            )
                        }

                        Spacer(modifier = Modifier.height(16.dp))

                        LazyColumn{
                            items(currencies.size){index ->
                                CurrenyItem(
                                    index = index,
                                    width = width
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}


@Composable
fun CurrenyItem(index: Int, width: Dp){
    val currency = currencies[index]

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ){

        Row(
            modifier = Modifier.width(width),
            verticalAlignment = Alignment.CenterVertically

        ) {

            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .background(GreenStart)
                    .padding(4.dp)
            ) {
                Icon(
                    modifier = Modifier.size(18.dp),
                    imageVector = currency.icon,
                    contentDescription = currency.name,
                    tint = Color.White
                )
            }

            Text(
                modifier = Modifier
                    .padding(start = 10.dp),
                text = currency.name,
                fontWeight = FontWeight.SemiBold,
                fontSize = 18.sp,
                color = MaterialTheme.colorScheme.onBackground,
                textAlign = TextAlign.End,
            )
        }


        Text(
            modifier = Modifier
                .width(width)
                .padding(start = 10.dp),
            text = "$ ${currency.buy}",
            fontWeight = FontWeight.SemiBold,
            fontSize = 16.sp,
            color = MaterialTheme.colorScheme.onBackground,
            textAlign = TextAlign.End,
        )

        Text(
            modifier = Modifier
                .width(width)
                .padding(start = 10.dp),
            text = "$ ${currency.sell}",
            fontWeight = FontWeight.SemiBold,
            fontSize = 16.sp,
            color = MaterialTheme.colorScheme.onBackground,
            textAlign = TextAlign.End,
        )

    }
}








