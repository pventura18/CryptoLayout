package cat.institutmontilivi.cryptolayout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cat.institutmontilivi.cryptolayout.ui.theme.CryptoLayoutTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CryptoLayoutTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Pantalla1()
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun Pantalla1()
{
    Column(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.primary)
            //.background(color = Color(30, 27, 211, 255))
    ) {
        //region Primera Linea
        Column(
            modifier = Modifier
                //.background(Color.Green)
                .fillMaxWidth()
                .padding(16.dp)
        ){
            Text(
                text= "Formiguetes",
                modifier = Modifier.align(Alignment.End),
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onPrimary
            )

            Row(
                modifier = Modifier
                .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Text(
                    text= "7,753.00",
                    style = MaterialTheme.typography.displaySmall,
                    color = MaterialTheme.colorScheme.onPrimary,
                    modifier = Modifier
                        .alignByBaseline()
                )
                Text(
                    text= "2,893",
                    modifier = Modifier
                        //.fillMaxHeight()
                        .alignByBaseline(),
                    style = MaterialTheme.typography.headlineSmall,
                    color = MaterialTheme.colorScheme.onPrimary
                )
            }
        }
        //endregion

        //region Segona Linea
        Card(
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surface),
            modifier = Modifier
                .fillMaxSize()
        ){
            Spacer(modifier = Modifier.height(23.dp))
            Text("Portfolio",
                modifier = Modifier
                    .padding(8.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ){
                Image(
                    painter = painterResource(id = R.drawable.bargraph1),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(8.dp)
                        .weight(1F),
                    contentScale = ContentScale.Fit
                )
                Image(painter = painterResource(id = R.drawable.bargraph2),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(8.dp)
                        .weight(1F),
                    contentScale = ContentScale.Fit
                )
            }

            Spacer(modifier = Modifier.height(16.dp))
            Text("Live Prices",
                modifier = Modifier
                    .padding(8.dp))

          LivePrice(R.drawable.bitcoin,"Bitcoin", "BTC", "21653.43".toDouble(),"2.47".toDouble())
          LivePrice(R.drawable.bitcoin,"Bitcoin", "BTC", "21653.43".toDouble(),"-28.47".toDouble())
          LivePrice(R.drawable.bitcoin,"Bitcoin", "BTC", "21653.43".toDouble(),"-5.47".toDouble())
          LivePrice(R.drawable.bitcoin,"Bitcoin", "BTC", "21653.43".toDouble(),"5.00".toDouble())
          LivePrice(R.drawable.bitcoin,"Bitcoin", "BTC", "21653.43".toDouble(),"2.47".toDouble())

        }
        //endregion
    }
}



@Preview
@Composable
fun PreviewLivePrice(){
    LivePrice(R.drawable.bitcoin,"Bitcoin", "BTC", "21653.43".toDouble(),"2.47".toDouble())
}




@Composable
fun LivePrice(imatge : Int, nom : String, inicials : String, valor : Double, increment : Double){
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
    ){
        Row(){
            Image(
                painterResource(id = imatge),
                contentDescription = null,
                modifier = Modifier
                    .width(56.dp)
                    .scale(1F)
                    .padding(4.dp)
                    .clip(shape = CircleShape)
                    .align(Alignment.CenterVertically)
                )
            Column(modifier = Modifier) {
                Text(
                    text = nom,
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier
                        .padding(horizontal = 8.dp, vertical = 4.dp),
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.End
                )
                Text(
                    text = inicials,
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier
                        .padding(horizontal = 8.dp, vertical = 4.dp),
                    fontWeight = FontWeight.Light,
                    textAlign = TextAlign.End

                )
            }

        }
        Column(
            horizontalAlignment = Alignment.End
        ){
            Text(
                text= "$${valor}",
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier
                    .padding(horizontal = 8.dp, vertical = 4.dp),
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.End
            )
            Text(
                text= "${increment}",
                color = if (increment < 0) Color.Red
                        else Color.Green,
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier
                    .padding(horizontal = 8.dp, vertical = 4.dp),
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.End
            )
        }
    }
}