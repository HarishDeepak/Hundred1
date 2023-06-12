package com.example.hundred

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.DefaultShadowColor
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hundred.ui.theme.HundredTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HundredTheme {
                //changes
                // A container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    simplelistview()
                   //Lazy()

                }
            }
        }
    }
}


private val fruitsList = mutableListOf<FruitModel>()
data class FruitModel(val name:String, val image : Int)
@Composable
fun simplelistview() {
    fruitsList.add(FruitModel("Apple", android.R.drawable.star_on))
    fruitsList.add(FruitModel("Orange", android.R.drawable.star_on))
    fruitsList.add(FruitModel("Banana", android.R.drawable.star_on))
    fruitsList.add(FruitModel("Strawberry", android.R.drawable.star_on))
    fruitsList.add(FruitModel("Mango", android.R.drawable.star_on))
    LazyColumn(){
        items(fruitsList) { model ->
            ListRow(model = model)
        }
    }
    }

@Composable
fun ListRow(model: FruitModel) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .background(DefaultShadowColor)
    ) {
        Image(
            painter = painterResource(id = model.image),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(100.dp)
                .padding(5.dp)
        )
        Text(
            text = model.name,
            fontSize = 24.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.White
        )
    }
}

//@Composable
////fun Lazywithsimplelist() {
////    LazyColumn(
////        modifier = Modifier
////            .fillMaxSize()
////            .background(Color.Black)
////            .padding(10.dp)
////    ) {
////        items(country) { country ->
////            Text(text = country, style = TextStyle(fontSize = 20.sp, color = Color.White))
////        }
////    }
////}
