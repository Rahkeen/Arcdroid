package co.rikin.arcdroid

import android.graphics.PathMeasure
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.EaseInOut
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.asAndroidPath
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.clipRect
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import co.rikin.arcdroid.ui.theme.ArcdroidTheme
import co.rikin.arcdroid.ui.theme.Aurora1
import co.rikin.arcdroid.ui.theme.brush1
import co.rikin.arcdroid.ui.theme.brush2
import co.rikin.arcdroid.ui.theme.brush3
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    WindowCompat.setDecorFitsSystemWindows(window, false)
    setContent {
      ArcdroidTheme {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
          BlurryBlobBackground()
          Column(horizontalAlignment = Alignment.CenterHorizontally) {
            SmileyFace()
            Text(
              "Sup.",
              modifier = Modifier.graphicsLayer(alpha = 1.0f),
              color = Color.White,
              style = MaterialTheme.typography.bodyLarge
            )
          }
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

@Preview
@Composable
fun SmileyFace() {
  fun Int.pi() = (Math.PI * this).toFloat()
//  val leftEyeTranslationX = animateFloatAsState(
//    targetValue = 0f,
//    animationSpec = keyframes {
//      durationMillis = 5000
//      -10f at 2000
//      10f at 4000
//      0f at 5000
//    },
//    label = "Left Eye Translation X"
//  )

  val leftEyeTranslationX = remember {
    Animatable(0f)
  }
  val leftEyeTranslationY = remember {
    Animatable(0f)
  }
  val rightEyeTranslationX = remember {
    Animatable(0f)
  }
  val rightEyeTranslationY = remember {
    Animatable(0f)
  }

  val blink = remember {
    Animatable(0f)
  }

  val rotation = remember {
    Animatable(0f)
  }

  LaunchedEffect(Unit) {
    delay(1000)
    launch {
      rotation.animateTo(
        targetValue = -5f,
        animationSpec = tween(500, easing = EaseInOut)
      )
      delay(1000)
      rotation.animateTo(
        targetValue = 5f,
        animationSpec = tween(500, easing = EaseInOut)
      )
      delay(500)
      rotation.animateTo(0f, animationSpec = tween(500, easing = LinearEasing))
    }
    launch {
      blink.animateTo(
        targetValue = 0f,
        animationSpec = keyframes {
          durationMillis = 200
          15f at 100 with LinearEasing
          0f at 200 with LinearEasing
        }
      )
      delay(1500)
      blink.animateTo(
        targetValue = 0f,
        animationSpec = keyframes {
          durationMillis = 200
          15f at 100 with LinearEasing
          0f at 200 with LinearEasing
        }
      )
    }
    launch {
      leftEyeTranslationX.animateTo(
        targetValue = -20f,
        animationSpec = tween(durationMillis = 500, easing = EaseInOut)
      )
      delay(1000)
      leftEyeTranslationX.animateTo(
        targetValue = 20f,
        animationSpec = tween(durationMillis = 500, easing = EaseInOut)
      )
      delay(500)
      leftEyeTranslationX.animateTo(
        targetValue = 0f,
        animationSpec = tween(durationMillis = 500, easing = EaseInOut)
      )
    }

    launch {
      rightEyeTranslationX.animateTo(
        targetValue = -20f,
        animationSpec = tween(durationMillis = 500, easing = EaseInOut)
      )
      delay(1000)
      rightEyeTranslationX.animateTo(
        targetValue = 20f,
        animationSpec = tween(durationMillis = 500, easing = EaseInOut)
      )
      delay(500)
      rightEyeTranslationX.animateTo(
        targetValue = 0f,
        animationSpec = tween(durationMillis = 500, easing = EaseInOut)
      )
    }

    launch {
      leftEyeTranslationY.animateTo(
        targetValue = -20f,
        animationSpec = tween(durationMillis = 500, easing = EaseInOut)
      )
      delay(1000)
      leftEyeTranslationY.animateTo(
        targetValue = -10f,
        animationSpec = tween(durationMillis = 500, easing = EaseInOut)
      )
      delay(500)
      leftEyeTranslationY.animateTo(
        targetValue = 0f,
        animationSpec = tween(durationMillis = 500, easing = EaseInOut)
      )
    }
    launch {
      rightEyeTranslationY.animateTo(
        targetValue = -10f,
        animationSpec = tween(durationMillis = 500, easing = EaseInOut)
      )
      delay(1000)
      rightEyeTranslationY.animateTo(
        targetValue = -20f,
        animationSpec = tween(durationMillis = 500, easing = EaseInOut)
      )
      delay(500)
      rightEyeTranslationY.animateTo(
        targetValue = 0f,
        animationSpec = tween(durationMillis = 500, easing = EaseInOut)
      )
    }
  }

  Box(modifier = Modifier.graphicsLayer(rotationZ = rotation.value)) {
    val canvasSize = 150.dp
    Canvas(
      modifier = Modifier
        .graphicsLayer(alpha = 0.8f)
        .blur(8.dp, edgeTreatment = BlurredEdgeTreatment.Unbounded)
        .size(canvasSize)
    ) {
      val padding = 16.dp.toPx()
      val headWidth = size.width - (2 * padding)
      val radius = headWidth / 2
      val topLeft = Offset(padding, (size.height * .8f) - radius)
      val arcLength = 1.pi() * radius

      val headBoundingBox = Rect(offset = topLeft, size = Size(headWidth, radius))
      val arcBoundingBox = Rect(offset = topLeft, size = Size(headWidth, radius * 2))

      // drawing an Arc with paths
      val headPath = Path().apply {
        arcTo(
          rect = arcBoundingBox,
          startAngleDegrees = -180f,
          sweepAngleDegrees = 180f,
          forceMoveTo = true
        )
        lineTo(
          x = headBoundingBox.bottomLeft.x,
          y = headBoundingBox.bottomLeft.y
        )
        close()
      }

      val leftAntennaPosition = FloatArray(2)
      val leftAntennaTan = FloatArray(2)
      val rightAntennaPosition = FloatArray(2)
      val rightAntennaTan = FloatArray(2)
      val measure = PathMeasure(
        headPath.asAndroidPath(),
        false
      )

      measure.getPosTan(arcLength * .33f, leftAntennaPosition, leftAntennaTan)
      measure.getPosTan(arcLength * .66f, rightAntennaPosition, rightAntennaTan)

      drawPath(
        path = headPath,
        color = Color.White,
        style = Stroke(
          width = 12.dp.toPx(),
          join = StrokeJoin.Round,
        )
      )

      // left antenna
      drawLine(
        color = Color.White,
        strokeWidth = 12.dp.toPx(),
        cap = StrokeCap.Round,
        start = Offset(leftAntennaPosition[0], leftAntennaPosition[1]),
        end = Offset(
          leftAntennaPosition[0] - 16.dp.toPx(),
          leftAntennaPosition[1] - 24.dp.toPx(),
        ),
      )

      // right antenna
      drawLine(
        color = Color.White,
        strokeWidth = 12.dp.toPx(),
        cap = StrokeCap.Round,
        start = Offset(rightAntennaPosition[0], rightAntennaPosition[1]),
        end = Offset(
          rightAntennaPosition[0] + 16.dp.toPx(),
          rightAntennaPosition[1] - 24.dp.toPx(),
        ),
      )

      // left eye
      drawCircle(
        color = Color.White,
        center = headBoundingBox.topLeft + Offset(
          headBoundingBox.width * 0.25f + leftEyeTranslationX.value,
          headBoundingBox.height * 0.6f + leftEyeTranslationY.value
        ),
        radius = 6.dp.toPx()
      )
      // right eye
      drawCircle(
        color = Color.White,
        center = headBoundingBox.topLeft + Offset(
          headBoundingBox.width * 0.75f + rightEyeTranslationX.value,
          headBoundingBox.height * 0.6f + rightEyeTranslationY.value
        ),
        radius = 6.dp.toPx()
      )
    }

    Canvas(modifier = Modifier.size(canvasSize)) {
      val padding = 16.dp.toPx()
      val headWidth = size.width - (2 * padding)
      val radius = headWidth / 2
      val topLeft = Offset(padding, (size.height * .8f) - radius)
      val arcLength = 1.pi() * radius

      val headBoundingBox = Rect(offset = topLeft, size = Size(headWidth, radius))
      val arcBoundingBox = Rect(offset = topLeft, size = Size(headWidth, radius * 2))

      // drawing an Arc with paths
      val headPath = Path().apply {
        arcTo(
          rect = arcBoundingBox,
          startAngleDegrees = -180f,
          sweepAngleDegrees = 180f,
          forceMoveTo = true
        )
        lineTo(
          x = headBoundingBox.bottomLeft.x,
          y = headBoundingBox.bottomLeft.y
        )
        close()
      }

      val leftAntennaPosition = FloatArray(2)
      val leftAntennaTan = FloatArray(2)
      val rightAntennaPosition = FloatArray(2)
      val rightAntennaTan = FloatArray(2)
      val measure = PathMeasure(
        headPath.asAndroidPath(),
        false
      )

      measure.getPosTan(arcLength * .33f, leftAntennaPosition, leftAntennaTan)
      measure.getPosTan(arcLength * .66f, rightAntennaPosition, rightAntennaTan)

      drawPath(
        path = headPath,
        color = Color.White,
        style = Stroke(
          width = 6.dp.toPx(),
          join = StrokeJoin.Round,
        )
      )

      // left antenna
      drawLine(
        color = Color.White,
        strokeWidth = 6.dp.toPx(),
        cap = StrokeCap.Round,
        start = Offset(leftAntennaPosition[0], leftAntennaPosition[1]),
        end = Offset(
          leftAntennaPosition[0] - 16.dp.toPx(),
          leftAntennaPosition[1] - 24.dp.toPx(),
        ),
      )

      // right antenna
      drawLine(
        color = Color.White,
        strokeWidth = 6.dp.toPx(),
        cap = StrokeCap.Round,
        start = Offset(rightAntennaPosition[0], rightAntennaPosition[1]),
        end = Offset(
          rightAntennaPosition[0] + 16.dp.toPx(),
          rightAntennaPosition[1] - 24.dp.toPx(),
        ),
      )

      // left eye
      val leftEyeBox = Rect(
        center = headBoundingBox.topLeft + Offset(
          (headBoundingBox.width * 0.25f) + leftEyeTranslationX.value,
          (headBoundingBox.height * 0.6f) + leftEyeTranslationY.value
        ),
        radius = 6.dp.toPx()
      )
      clipRect(
        left = leftEyeBox.left,
        top = leftEyeBox.top + blink.value,
        right = leftEyeBox.left + leftEyeBox.width,
        bottom = leftEyeBox.top + leftEyeBox.height - blink.value
      ) {
        drawCircle(
          color = Color.White,
          center = leftEyeBox.center,
          radius = 6.dp.toPx()
        )
      }

      // right eye
      val rightEyeBox = Rect(
        center = headBoundingBox.topLeft + Offset(
          (headBoundingBox.width * 0.75f) + rightEyeTranslationX.value,
          (headBoundingBox.height * 0.6f) + rightEyeTranslationY.value
        ),
        radius = 6.dp.toPx()
      )
      clipRect(
        left = rightEyeBox.left,
        top = rightEyeBox.top + blink.value,
        right = rightEyeBox.left + rightEyeBox.width,
        bottom = rightEyeBox.top + rightEyeBox.height - blink.value
      ) {
        drawCircle(
          color = Color.White,
          center = rightEyeBox.center,
          radius = 6.dp.toPx()
        )
      }
    }
  }
}
