package com.example.bankapp.presentation.ui.composable

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Card
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.outlined.ArrowDownward
import androidx.compose.material.icons.outlined.ArrowUpward
import androidx.compose.material.icons.outlined.ManageHistory
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.IconButton
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bankapp.R
import com.example.bankapp.domain.model.AccountState

@Preview
@Composable
fun AccountSection(
    onViewDetailsClick: () -> Unit = {}
){
    val accountState = listOf(
        AccountState(1,"Salary Account",4500.00, "USD"),
        AccountState(2,"Savings Account",5100.00, "USD"),
        AccountState(2,"Savings Account",555100.00, "ARS"),
        AccountState(3,"Checking Account",2200.00, "USD")
    )

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        //Title
        Text(
            text = "Accounts",
            color = Color.Gray,
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(10.dp))
        //Accounts
        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            items(accountState){
                Card(
                    modifier = Modifier.height(200.dp).fillMaxWidth(),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White,
                        contentColor = MaterialTheme.colorScheme.onBackground
                    ),
                    shape = RoundedCornerShape(16.dp),
                    elevation = CardDefaults.cardElevation(4.dp)
                ){
                    Column(
                        modifier = Modifier.fillMaxWidth().padding(16.dp)
                    ){
                        Text(
                            text = it.type,
                            fontSize = 15.sp,
                            fontWeight = FontWeight.SemiBold,
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Row(){
                            Box(
                                modifier = Modifier
                                    .background(color = Color.Gray)
                                    .border(BorderStroke(1.dp, Color.Black))
                                    .padding(2.dp)
                            ){
                                Text(
                                    text = it.currency,
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                            Spacer(modifier = Modifier.width(5.dp))
                            Text(
                                text = "$${it.balance}",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                        Spacer(modifier = Modifier.weight(1f))
                        //Actions
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween,
                        ){
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally
                            ){
                                IconButton(
                                    onClick = {},
                                    modifier = Modifier
                                        .size(40.dp)
                                        .clip(CircleShape)
                                        .background(MaterialTheme.colorScheme.surfaceVariant)
                                        .padding(5.dp)
                                ){
                                    Icon(
                                        contentDescription = "Deposit",
                                        imageVector = Icons.Outlined.ArrowUpward,
                                    )
                                }
                                Text(
                                    text = "Deposit",
                                    fontSize = 12.sp
                                )
                            }
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally
                            ){
                                IconButton(
                                    onClick = { },
                                    modifier = Modifier
                                        .size(40.dp)
                                        .clip(CircleShape)
                                        .background(MaterialTheme.colorScheme.surfaceVariant)
                                        .padding(5.dp)
                                ) {
                                    Icon(
                                        imageVector = Icons.Outlined.ArrowDownward,
                                        contentDescription = "Extract",
                                    )
                                }
                                Text(
                                    text = "Extract",
                                    fontSize = 12.sp
                                )
                            }
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                IconButton(
                                    onClick = { },
                                    modifier = Modifier
                                        .size(40.dp)
                                        .clip(CircleShape)
                                        .background(MaterialTheme.colorScheme.surfaceVariant)
                                        .padding(5.dp)
                                ) {
                                    Icon(
                                        imageVector = Icons.Outlined.ManageHistory,
                                        contentDescription = "History",
                                    )
                                }
                                Text(
                                    text = "History",
                                    fontSize = 12.sp
                                )
                            }
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                IconButton(
                                    onClick = { },
                                    modifier = Modifier
                                        .size(40.dp)
                                        .clip(CircleShape)
                                        .background(MaterialTheme.colorScheme.surfaceVariant)
                                        .padding(5.dp)
                                ) {
                                    Icon(
                                        painter = painterResource(id = R.drawable.baseline_id_card_50),
                                        contentDescription = "CBU/Alias",
                                        tint = MaterialTheme.colorScheme.onBackground
                                    )
                                }
                                Text(
                                    text = "View CBU",
                                    fontSize = 12.sp
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
fun Other(){
    //surface background color
    ElevatedButton(
        onClick = { /*TODO*/ }
    ) {
        Icon(
            imageVector = Icons.Outlined.Search,
            contentDescription = "Search",
            modifier = Modifier.size(15.dp),
            tint = MaterialTheme.colorScheme.onBackground
        )
        Spacer(modifier = Modifier.width(5.dp))
        Text(
            text = "Search",
        )
    }
    //secondary background color
    FilledTonalButton(
        onClick = { /*TODO*/ }
    ) {
        Text(text = "Open in browser")
    }
}