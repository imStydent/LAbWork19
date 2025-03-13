package com.example.labwork19

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import com.example.labwork19.ui.theme.LabWork19Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CardView(products[1]) // НУЖНО ПОМЕНЯТЬ В IMAGE(ТАМ НЕ БЕРЁТСЯ ID ТОВАРА)
            //CardViewVertical(products[1])
            //LazyColumnView()
            //LazyRowView()
        }
    }
}
var products = listOf(
    Product("ad1", "Tovar1", 10.1f, 1),
    Product("ad2", "Tovar2", 10.2f, 2),
    Product("ad3", "Tovar3", 10.3f, 3),
    Product("ad4", "Tovar4", 10.4f, 4),
    Product("ad5", "Tovar5", 10.5f, 5),
    Product("ad6", "Tovar6", 10.6f, 6),
    Product("ad7", "Tovar7", 10.1f, 7),
    Product("ad8", "Tovar8", 10.1f, 8),
    Product("ad9", "Tovar9", 10.1f, 1),
    Product("ad10", "Tovar10", 10.1f, 1),
    Product("ad11", "Tovar11", 100.1f, 1),
    Product("ad12", "Tovar12", 101.1f, 1),
    Product("ad13", "Tovar13", 10.1f, 1),
    Product("ad14", "Tovar14", 10.1f, 1),
    Product("ad15", "Tovar15", 100.1f, 1),
    Product("ad16", "Tovar16", 10.1f, 1),
    Product("ad17", "Tovar17", 10.1f, 1),
    Product("ad18", "Tovar18", 10.1f, 1),
    Product("ad19", "Tovar19", 10.1f, 1),
    Product("ad20", "Tovar20", 10.1f, 1),
)

@Composable
fun CardView(product: Product){
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color.Blue,
            contentColor = Color.Red
        ),
        elevation = CardDefaults.elevatedCardElevation(10.dp)
    ) {
        Row(){ // НУЖНО ПОМЕНЯТЬ В IMAGE(ТАМ НЕ БЕРЁТСЯ ID ТОВАРА)
            Image(bitmap = ImageBitmap.imageResource(R.drawable.banana), null)
            Text(product.name)
            Text("${product.price}")
        }
    }
}
@Composable
fun CardViewVertical(product: Product){
    Card(
        modifier = Modifier.padding(5.dp).fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = Color.Blue,
            contentColor = Color.Red
        ),
        elevation = CardDefaults.elevatedCardElevation(10.dp)
    ) {
        Column() {
            Image(painter = painterResource(id = product.pictureId), contentDescription = null, contentScale = ContentScale.Crop)
            Text(product.name)
            Text("${product.price}")
        }
    }
}
@Composable
fun LazyColumnView(){ // не пришло гичего в голову, чтоб первым значение выводилось название товара
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(25.dp)
    ) {
        item { CardView(products[1]) }
        item { CardViewVertical(products[1]) }
    }
}
@Composable
fun LazyRowView(){
    LazyRow(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(25.dp)
    ){
        item { CardView(products[1]) }
        item { CardViewVertical(products[1]) }
    }
}