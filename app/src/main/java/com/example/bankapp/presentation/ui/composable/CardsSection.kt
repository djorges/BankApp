package com.example.bankapp.presentation.ui.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bankapp.R
import com.example.bankapp.domain.model.Card
import com.example.bankapp.domain.model.CardType
import com.example.bankapp.domain.model.InternationalMarkType
import com.example.bankapp.presentation.ui.theme.BlueEnd
import com.example.bankapp.presentation.ui.theme.BlueStart
import com.example.bankapp.presentation.ui.theme.OrangeEnd
import com.example.bankapp.presentation.ui.theme.OrangeStart
import com.example.bankapp.presentation.ui.theme.PurpleEnd
import com.example.bankapp.presentation.ui.theme.PurpleStart

val cards = listOf(
    Card(
        id = 1,
        type = CardType.CREDIT,
        internationalMark = InternationalMarkType.VISA,
        icon = R.drawable.ic_visa,
        number = "1234 5678 9012 3456",
        name = "Bussines",
        balance = 78846.467,
        color = Brush.horizontalGradient(colors = listOf(PurpleStart, PurpleEnd))

    ),
    Card(
        id = 2,
        type = CardType.DEBIT,
        internationalMark = InternationalMarkType.MASTERCARD,
        icon = R.drawable.ic_mastercard,
        number = "1234 5678 9012 3456",
        name = "Shopping",
        balance = 7884646.467,
        color = Brush.horizontalGradient(colors = listOf(BlueStart, BlueEnd))
    ),
    Card(
        id = 3,
        type = CardType.CREDIT,
        internationalMark = InternationalMarkType.AMERICAN_EXPRESS,
        icon = R.drawable.ic_american_express,
        number = "8999 5678 9012 3456",
        name = "Travel",
        balance = 1000646.467,
        color = Brush.horizontalGradient(colors = listOf(OrangeStart, OrangeEnd))
    )
)

@Preview
@Composable
fun CardsSection(){
    LazyRow {
        items(cards.size){
            CardItem(card = cards[it])
        }
    }
}

@Composable
fun CardItem(
    card: Card,
    onCardClick: () -> Unit = {}
){
    Box(
        modifier = Modifier.padding(
            start = 16.dp, end = if(card == cards.last()) 16.dp else 0.dp
        )
    ){
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(25.dp))
                .background(card.color)
                .width(250.dp)
                .height(160.dp)
                .clickable(onClick = onCardClick)
                .padding(vertical = 12.dp, horizontal = 16.dp)
        ) {
            Image(
                painter = painterResource(id = card.icon),
                contentDescription = card.internationalMark.name,
                colorFilter = ColorFilter.tint(Color.White),
                modifier = Modifier.height(40.dp)
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = card.name,
                color = Color.White,
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "$${card.balance}",
                color = Color.White,
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = card.number,
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}