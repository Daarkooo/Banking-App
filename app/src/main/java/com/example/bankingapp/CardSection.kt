package com.example.bankingapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bankingapp.Data.Card
import com.example.bankingapp.ui.theme.*

val cards = listOf(

    Card(
        cardType = "VISA",
        cardNumber = "4235 5231 2341 9843",
        cardName = "Business",
        cardBalance = 46.234,
        color = getGradient(PurpleStart, PurpleEnd),
    ),
    Card(
        cardType = "MASTER CARD",
        cardNumber = "5234 9548 3424 6452",
        cardName = "Trips",
        cardBalance = 21.84,
        color = getGradient(BlueStart, BlueEnd),
    ),
    Card(
        cardType = "VISA",
        cardNumber = "8934 1234 0931 6351",
        cardName = "Savings",
        cardBalance = 27.041,
        color = getGradient(OrangeStart, OrangeEnd),
    ),
    Card(
        cardType = "MASTER CARD ",
        cardNumber = "0948 5231 2341 9843",
        cardName = "School",
        cardBalance = 3.234,
        color = getGradient(GreenStart, GreenEnd),
    ),

)

fun getGradient(
    startColor: Color,
    endColor: Color,
): Brush{
    return Brush.horizontalGradient(
        colors = listOf(startColor,endColor)
    )
}

@Preview
@Composable
fun CardsSection(){
    LazyRow {
        items(cards.size){ index ->
            CardItem(index)
        }
    }
}


@Composable
fun CardItem(
    index: Int
){
    val card = cards[index]

    var lastItemPaddingEnd = 0.dp
    if(index == cards.size - 1) lastItemPaddingEnd= 16.dp

    var image = painterResource(id = R.drawable.ic_visa)
    if(card.cardType == "MASTER CARD")  image = painterResource(id = R.drawable.ic_mastercard)

    Box(
        modifier = Modifier
            .padding(start = 16.dp, end = lastItemPaddingEnd)
    ){
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(25.dp))
                .background(card.color)
                .width(250.dp)
                .height(160.dp)
                .clickable {  }
                .padding(vertical = 12.dp, horizontal = 16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ){
            Image(
                painter = image,
                contentDescription = card.cardName,
                modifier = Modifier.width(60.dp)
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = card.cardName,
                color = Color.White,
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "$ ${card.cardBalance}",
                color = Color.White,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = card.cardNumber,
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )

        }
    }

}
