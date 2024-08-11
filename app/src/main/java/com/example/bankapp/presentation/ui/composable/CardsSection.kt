package com.example.bankapp.presentation.ui.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
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
        name = "Business",
        date = "03/28",
        cvv = "123",
        color = Brush.horizontalGradient(colors = listOf(PurpleStart, PurpleEnd))

    ),
    Card(
        id = 2,
        type = CardType.DEBIT,
        internationalMark = InternationalMarkType.MASTERCARD,
        icon = R.drawable.ic_mastercard,
        number = "1234 5678 9012 3456",
        name = "Shopping",
        date = "03/28",
        cvv = "123",
        color = Brush.horizontalGradient(colors = listOf(BlueStart, BlueEnd))
    ),
    Card(
        id = 3,
        type = CardType.CREDIT,
        internationalMark = InternationalMarkType.AMERICAN_EXPRESS,
        icon = R.drawable.ic_american_express,
        number = "8999 5678 9012 3456",
        name = "Travel",
        date = "03/28",
        cvv = "123",
        color = Brush.horizontalGradient(colors = listOf(OrangeStart, OrangeEnd))
    )
)

@Preview
@Composable
fun CardsSection(){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ){
        Text(
            text = "Cards",
            color = Color.Gray,
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(10.dp))
        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
        ) {
            items(cards.size){
                CardItem(card = cards[it])
            }
        }
    }
}

@Composable
fun CardItem(
    card: Card,
    onCardClick: () -> Unit = {},
){
    var isVisible by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
    ){
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(25.dp))
                .background(card.color)
                .width(250.dp)
                .height(160.dp)
                .clickable(onClick = onCardClick)
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(
                    text = card.name,
                    color = Color.White,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.weight(1f))
                IconButton(
                    onClick = { isVisible = !isVisible },
                    modifier = Modifier.size(24.dp),
                ) {
                    Icon(
                        tint = Color.White,
                        imageVector = if (isVisible) Icons.Filled.Visibility else Icons.Filled.VisibilityOff,
                        contentDescription = null
                    )
                }
                Spacer(modifier = Modifier.width(6.dp))
                IconButton(
                    onClick = { onCardClick() },
                    modifier = Modifier.size(24.dp)
                ) {
                    Icon(
                        tint = Color.White,
                        imageVector = Icons.Default.Menu,
                        contentDescription = "Menu"
                    )
                }
            }
            Spacer(modifier = Modifier.weight(1f))
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = if (isVisible) card.number else "•••• •••• •••• ••••",
                textAlign = TextAlign.Center,
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(10.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ){
                Column {
                    Text(
                        text = "Date Exp",
                        color = Color.White,
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = if (isVisible) card.date else "**/**",
                        color = Color.White,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
                Spacer(modifier = Modifier.width(10.dp))
                Column {
                    Text(
                        text = "CVV",
                        color = Color.White,
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = if (isVisible) card.cvv else "***",
                        color = Color.White,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
                Spacer(modifier = Modifier.weight(1f))
                Image(
                    painter = painterResource(id = card.icon),
                    contentDescription = card.internationalMark.name,
                    colorFilter = ColorFilter.tint(Color.White),
                    modifier = Modifier.height(40.dp)
                )
            }
        }
    }
}