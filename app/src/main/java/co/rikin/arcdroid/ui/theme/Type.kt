package co.rikin.arcdroid.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import co.rikin.arcdroid.R

// Set of Material typography styles to start with
val quicksand = FontFamily(
  Font(resId = R.font.quicksand_medium, weight = FontWeight.Medium),
  Font(resId = R.font.quicksand_semibold, weight = FontWeight.SemiBold),
  Font(resId = R.font.quicksand_bold, weight = FontWeight.Bold)
)
val Typography = Typography(
  bodyLarge = TextStyle(
    fontFamily = quicksand,
    fontWeight = FontWeight.Bold,
    fontSize = 36.sp,
    lineHeight = 24.sp,
    letterSpacing = 0.5.sp
  ),
  labelLarge = TextStyle(
    fontFamily = quicksand,
    fontWeight = FontWeight.Bold,
    fontSize = 24.sp,
    lineHeight = 24.sp,
    letterSpacing = 0.5.sp
  )
  /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)