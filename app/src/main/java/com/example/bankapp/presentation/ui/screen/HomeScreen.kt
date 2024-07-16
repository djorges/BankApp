package com.example.bankapp.presentation.ui.screen

import androidx.compose.foundation.background
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.bankapp.data.api.BaseModel
import com.example.bankapp.data.dto.CryptoDto
import com.example.bankapp.presentation.ui.composable.CardsSection
import com.example.bankapp.presentation.ui.composable.CurrenciesSection
import com.example.bankapp.presentation.ui.composable.FinanceSection
import com.example.bankapp.presentation.ui.composable.WalletSection
import com.example.bankapp.presentation.viewmodel.MainViewModel

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: MainViewModel
){
    val data by viewModel.response.collectAsState()

    WalletSection()
    Spacer(modifier = Modifier.height(16.dp))
    CardsSection()
    Spacer(modifier = Modifier.height(16.dp))
    FinanceSection()
    Spacer(modifier = Modifier.height(16.dp))
    CurrenciesSection()
    Spacer(modifier = Modifier.height(16.dp))
    /* Crypto Currencies Section*/
    Column(
        modifier = modifier
    ){
       when(val result = data){
           is BaseModel.Loading -> {
               Box(
                   modifier = Modifier.fillMaxSize(),
                   contentAlignment = Alignment.Center
               ){
                   CircularProgressIndicator(color = MaterialTheme.colorScheme.primary)
               }
           }
           is BaseModel.Success -> {
               LazyRow(
                   horizontalArrangement = Arrangement.spacedBy(8.dp),
               ){
                    items(result.data.cryptoDtoList){
                        ListItem(it)
                    }
               }
           }
           is BaseModel.Error -> {
               Text(text = result.message)
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
            .height(80.dp)
            .clickable { }
            .padding(horizontal = 8.dp),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primary
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        )
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            //Image
            Row(
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(55.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .background(MaterialTheme.colorScheme.secondary),
                    contentAlignment = Alignment.Center
                ) {
                    AsyncImage(
                        model = ImageRequest.Builder(LocalContext.current)
                            .data("") //TODO: Add image
                            .crossfade(true)
                            .build(),
                        contentDescription = null
                    )
                }
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

        }
    }
}