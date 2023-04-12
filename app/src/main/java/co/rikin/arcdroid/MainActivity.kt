package co.rikin.arcdroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat
import co.rikin.arcdroid.ui.theme.ArcdroidTheme
import co.rikin.arcdroid.ui.theme.Aurora1
import co.rikin.arcdroid.ui.theme.brush1
import co.rikin.arcdroid.ui.theme.brush2
import co.rikin.arcdroid.ui.theme.brush3

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    WindowCompat.setDecorFitsSystemWindows(window, false)
    setContent {
      ArcdroidTheme {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
          BlurryBlobBackground()
          Text("Sup.", color = Color.White, fontSize = 28.sp)
        }
      }
    }
  }
}

@Preview
@Composable
fun BlurryBlobBackground() {
  val infinite = rememberInfiniteTransition()

  val circle1TranslationDuration = 24000
  val circle1XMult = infinite.animateFloat(
    initialValue = .25f,
    targetValue = .25f,
    animationSpec = infiniteRepeatable(
      animation = keyframes {
        durationMillis = circle1TranslationDuration
        .5f at (circle1TranslationDuration * .25).toInt() with LinearEasing
        1.0f at (circle1TranslationDuration * .5).toInt() with LinearEasing
        .5f at (circle1TranslationDuration * .75).toInt() with LinearEasing
        .25f at circle1TranslationDuration with LinearEasing
      },
      repeatMode = RepeatMode.Restart
    )
  )
  val circle1YMult = infinite.animateFloat(
    initialValue = .25f, targetValue = .25f,
    animationSpec = infiniteRepeatable(
      animation = keyframes {
        durationMillis = circle1TranslationDuration
        .5f at (circle1TranslationDuration * .25).toInt() with LinearEasing
        .5f at (circle1TranslationDuration * .5).toInt() with LinearEasing
        1.0f at (circle1TranslationDuration * .75).toInt() with LinearEasing
        .25f at circle1TranslationDuration with LinearEasing
      },
      repeatMode = RepeatMode.Restart
    )
  )
  val circle1ScaleDuration = 13456
  val circle1Scale = infinite.animateFloat(
    initialValue = 1f,
    targetValue = 1f,
    animationSpec = infiniteRepeatable(
      keyframes {
        durationMillis = circle1ScaleDuration
        0.8f at (circle1ScaleDuration * .33).toInt() with LinearEasing
        1.2f at (circle1ScaleDuration * .66).toInt() with LinearEasing
        1.0f at circle1ScaleDuration with LinearEasing
      },
      repeatMode = RepeatMode.Restart
    )
  )


  val circle3TranslationDuration = 10000
  val circle3XMult = infinite.animateFloat(
    initialValue = 1.0f,
    targetValue = 1.0f,
    animationSpec = infiniteRepeatable(
      animation = keyframes {
        durationMillis = circle3TranslationDuration
        0f at (circle3TranslationDuration * 0.25).toInt() with LinearEasing
        1.0f at circle3TranslationDuration with LinearEasing
      },
      repeatMode = RepeatMode.Restart
    )
  )
  val circle3YMult = infinite.animateFloat(
    initialValue = 1.0f,
    targetValue = 1.0f,
    animationSpec = infiniteRepeatable(
      animation = keyframes {
        durationMillis = circle3TranslationDuration
        0f at (circle3TranslationDuration * 0.5).toInt() with LinearEasing
        1.0f at circle3TranslationDuration with LinearEasing
      },
      repeatMode = RepeatMode.Restart
    )
  )
  val circle3ScaleDuration = 9875
  val circle3Scale = infinite.animateFloat(
    initialValue = 1f,
    targetValue = 1f,
    animationSpec = infiniteRepeatable(
      keyframes {
        durationMillis = circle3ScaleDuration
        1.1f at (circle3ScaleDuration * .33).toInt() with LinearEasing
        0.85f at (circle3ScaleDuration * .66).toInt() with LinearEasing
        1.0f at circle3ScaleDuration with LinearEasing
      },
      repeatMode = RepeatMode.Restart
    )
  )

  val circle2TranslationDuration = 15000
  val circle2YMult = infinite.animateFloat(
    initialValue = 0.5f,
    targetValue = 0.5f,
    animationSpec = infiniteRepeatable(
      animation = keyframes {
        durationMillis = circle2TranslationDuration
        0f at (circle2TranslationDuration * .25).toInt() with LinearEasing
        .5f at (circle2TranslationDuration * .5).toInt() with LinearEasing
        1.0f at (circle2TranslationDuration * .75).toInt() with LinearEasing
        .5f at circle2TranslationDuration with LinearEasing
      },
      repeatMode = RepeatMode.Restart
    )
  )
  val circle2ScaleDuration = 16235
  val circle2Scale = infinite.animateFloat(
    initialValue = 1f,
    targetValue = 1f,
    animationSpec = infiniteRepeatable(
      keyframes {
        durationMillis = circle2ScaleDuration
        1.2f at (circle2ScaleDuration * .33).toInt() with LinearEasing
        1.1f at (circle2ScaleDuration * .66).toInt() with LinearEasing
        1.0f at circle2ScaleDuration with LinearEasing
      },
      repeatMode = RepeatMode.Restart
    )
  )

  Box(
    modifier = Modifier
      .fillMaxSize()
      .background(color = Aurora1)
      .blur(radius = 100.dp, edgeTreatment = BlurredEdgeTreatment.Unbounded)
      .drawBehind {

        val offset1 = Offset(
          size.width * circle1XMult.value,
          size.height * circle1YMult.value,
        )
        drawCircle(
          brush = brush1,
          radius = size.minDimension * .75f * circle1Scale.value,
          center = offset1,
          alpha = 0.75f
        )
        val offset2 = Offset(
          size.width * .5f,
          size.height * circle2YMult.value
        )
        drawCircle(
          brush = brush2,
          radius = size.minDimension * .75f * circle2Scale.value,
          center = offset2,
          alpha = 0.75f
        )

        val offset3 = Offset(
          size.width * circle3XMult.value,
          size.height * circle3YMult.value,
        )
        drawCircle(
          brush = brush3,
          radius = size.minDimension * .75f * circle3Scale.value,
          center = offset3,
          alpha = 0.75f
        )
      }
  )
}
