package com.example.bankapp.presentation.ui.composable

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.bankapp.data.api.BaseModel
import com.example.bankapp.data.dto.CryptoCurrenciesDto
import com.example.bankapp.data.dto.CryptoDto
import kotlin.math.roundToInt

@Composable
fun CryptoCurrenciesSection(
    data: BaseModel<CryptoCurrenciesDto>
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
    ) {
        when (data) {
            is BaseModel.Loading -> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator(color = MaterialTheme.colorScheme.primary)
                }
            }

            is BaseModel.Success -> {
                Text(
                    modifier = Modifier.padding(vertical = 10.dp),
                    text = "Crypto Currencies",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                )
                LazyColumn(
                    modifier = Modifier
                        .height(400.dp)
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    items(data.data.cryptoDtoList) {
                        ListItem(it)
                    }
                }
            }

            is BaseModel.Error -> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = data.message, color = Color.Red)
                }
            }

            else -> {

            }
        }
    }
}

@Composable
private fun ListItem(
    item: CryptoDto
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable {
                //Navigate to Detail Screen
            },
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.secondary
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        )
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data("https://s2.coinmarketcap.com/static/img/coins/64x64/${item.id}.png")
                        .crossfade(true)
                        .build(),
                    contentDescription = item.name.toString(),
                    modifier = Modifier.size(25.dp)
                )
                Column {
                    Text(
                        text = item.name.toString(),
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                    )
                    Text(
                        text = item.symbol.toString(),
                        fontSize = 12.sp,
                        color = Color.Gray
                    )
                }
            }
            //
            Column(
                horizontalAlignment = Alignment.End
            ){
                val percent = item.quotes?.usd?.percentChange24h
                val price = item.quotes?.usd?.price
                if (price != null) {
                    Text(
                        text = "${((price.times(100)).roundToInt())/100.0} $",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                    )
                }
                Spacer(modifier = Modifier.height(4.dp))
                if (percent != null) {
                    Text(
                        text = "${((percent.times(100)).roundToInt())/100.0}%",
                        color = if (percent >= 0) Color.Green else Color.Red
                    )
                }
            }
        }
    }
}