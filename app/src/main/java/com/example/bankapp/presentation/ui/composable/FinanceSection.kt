package com.example.bankapp.presentation.ui.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Start
import androidx.compose.material.icons.filled.Wallet
import androidx.compose.material.icons.rounded.AccountTree
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bankapp.domain.model.Finance
import com.example.bankapp.presentation.ui.theme.BlueStart
import com.example.bankapp.presentation.ui.theme.GreenStart
import com.example.bankapp.presentation.ui.theme.OrangeStart
import com.example.bankapp.presentation.ui.theme.PurpleStart

val finances = listOf(
    Finance(
        icon = Icons.Default.Start,
        name = "My\nBussiness",
        backgroundColor = OrangeStart
    ),
    Finance(
        icon = Icons.Default.Wallet,
        name = "My\nWallet",
        backgroundColor = BlueStart
    ),
    Finance(
        icon = Icons.Default.ShoppingCart,
        name = "Finance\nAnalytics",
        backgroundColor = PurpleStart
    ),
    Finance(
        icon = Icons.Rounded.AccountTree,
        name = "My\nTransactions",
        backgroundColor = GreenStart
    )
)

@Preview
@Composable
fun FinanceSection() {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        //Title
        Text(
            text = "Finance",
            fontSize = 18.sp,
            color = MaterialTheme.colorScheme.onBackground
        )
        Spacer(modifier = Modifier.height(10.dp))
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            content = {
                items(finances.size) {
                    FinanceItem(finance = finances[it])
                }
            }
        )
    }
}

@Composable
fun FinanceItem(
    finance: Finance,
    onItemClick: (Finance) -> Unit = {}
) {
    Column(
        modifier = Modifier
            .clip(RoundedCornerShape(25.dp))
            .background(MaterialTheme.colorScheme.secondaryContainer)
            .size(120.dp)
            .clickable { onItemClick(finance) }
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(16.dp))
                .background(finance.backgroundColor)
                .padding(6.dp)
        ){
            Icon(
                imageVector = finance.icon,
                contentDescription = finance.name,
                tint = Color.White
            )
        }
        Text(
            text = finance.name,
            color = MaterialTheme.colorScheme.onSecondaryContainer,
            fontWeight = FontWeight.SemiBold,
            fontSize = 15.sp
        )
    }
}