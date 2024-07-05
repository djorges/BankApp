package com.example.bankapp.presentation.ui.composable

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AttachMoney
import androidx.compose.material.icons.rounded.CurrencyPound
import androidx.compose.material.icons.rounded.CurrencyYen
import androidx.compose.material.icons.rounded.Euro
import androidx.compose.material.icons.rounded.KeyboardArrowUp
import androidx.compose.material.icons.rounded.KeyboardDoubleArrowRight
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bankapp.domain.model.Currency
import com.example.bankapp.presentation.ui.theme.GreenStart

val currencies = listOf(
    Currency(
        id = 1,
        name = "USD",
        buy = 23.50f,
        sell = 24.50f,
        icon = Icons.Rounded.AttachMoney
    ),
    Currency(
        id = 2,
        name = "EUR",
        buy = 23.50f,
        sell = 24.50f,
        icon = Icons.Rounded.Euro
    ),
    Currency(
        id = 3,
        name = "Pound",
        buy = 23.50f,
        sell = 24.50f,
        icon = Icons.Rounded.CurrencyPound
    ),
    Currency(
        id = 4,
        name = "Yen",
        buy = 23.50f,
        sell = 24.50f,
        icon = Icons.Rounded.CurrencyYen
    )
)

@Composable
fun CurrenciesSection(){
    var isVisible by remember {
        mutableStateOf(false)
    }
    var iconState by remember {
        mutableStateOf(Icons.Rounded.KeyboardArrowUp)
    }

    Column(
        modifier = Modifier
            .clip(RoundedCornerShape(topStart = 20.dp, topEnd = 16.dp))
            .background(MaterialTheme.colorScheme.inverseOnSurface)
            .animateContentSize()
    ) {
        //Title & Toggle
        Row(
            modifier = Modifier
                .padding(16.dp)
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
                        iconState =
                            if (isVisible) Icons.Rounded.KeyboardDoubleArrowRight else Icons.Rounded.KeyboardArrowUp
                    }
            ){
                Icon(
                    modifier = Modifier.size(25.dp),
                    imageVector = iconState,
                    contentDescription = "Currencies",
                    tint = MaterialTheme.colorScheme.onSecondary
                )
            }
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = "Currencies",
                fontSize = 20.sp,
                color = MaterialTheme.colorScheme.onSecondaryContainer,
                fontWeight = FontWeight.Bold
            )
        }
        Divider(
            modifier = Modifier.padding(start = 16.dp),
            thickness = 1.dp,
            color = MaterialTheme.colorScheme.onSecondaryContainer
        )
        if (isVisible){
            //Currency Table
            BoxWithConstraints(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
                    .background(MaterialTheme.colorScheme.background)
            ){
                val width = this.maxWidth / 3
                val textStyle = TextStyle(
                    fontSize = 16.sp,
                    color = MaterialTheme.colorScheme.onBackground,
                    fontWeight = FontWeight.SemiBold,
                    textAlign = TextAlign.End
                )
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Spacer(modifier = Modifier.height(16.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        //Headers
                        Text(
                            modifier = Modifier.width(width),
                            text = "Currency",
                            style = textStyle
                        )
                        Text(
                            modifier = Modifier.width(width),
                            text = "Buy",
                            style = textStyle
                        )
                        Text(
                            modifier = Modifier.width(width),
                            text = "Sell",
                            style = textStyle
                        )
                        Spacer(modifier = Modifier.width(16.dp))
                        //Currency List
                        LazyColumn{
                            this.items(currencies.size){index ->
                                CurrencyItem(
                                    currency = currencies[index],
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
fun CurrencyItem(currency: Currency, width: Dp){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        //Icon
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(8.dp))
                .background(GreenStart)
                .padding(8.dp)
        ){
            Icon(
                modifier = Modifier.size(20.dp),
                imageVector = currency.icon,
                contentDescription = currency.name,
                tint = Color.White
            )
        }
    }
}