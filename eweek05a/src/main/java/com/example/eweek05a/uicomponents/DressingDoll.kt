package com.example.dolldressup

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.eweek05a.R

@Composable
fun DressingDoll(modifier: Modifier = Modifier) {
    val config = LocalConfiguration.current
    val isPortrait = config.orientation == android.content.res.Configuration.ORIENTATION_PORTRAIT

    // States
    var showArms by rememberSaveable { mutableStateOf(true) }
    var showBody by rememberSaveable { mutableStateOf(true) }
    var showEars by rememberSaveable { mutableStateOf(false) }
    var showEyebrows by rememberSaveable { mutableStateOf(true) }
    var showEyes by rememberSaveable { mutableStateOf(true) }
    var showNose by rememberSaveable { mutableStateOf(true) }
    var showMouth by rememberSaveable { mutableStateOf(false) }
    var showMustaches by rememberSaveable { mutableStateOf(false) }
    var showGlasses by rememberSaveable { mutableStateOf(true) }
    var showHat by rememberSaveable { mutableStateOf(true) }
    var showShoes by rememberSaveable { mutableStateOf(true) }

    if (isPortrait) {
        // Portrait layout
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(top = 32.dp, start = 16.dp, end = 16.dp, bottom = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            DollImageLayer(
                showArms, showBody, showEars, showEyebrows, showEyes,
                showNose, showMouth, showMustaches, showGlasses, showHat, showShoes
            )

            Spacer(modifier = Modifier.height(20.dp))
            CheckboxLayout(
                showArms, { showArms = it },
                showEyebrows, { showEyebrows = it },
                showGlasses, { showGlasses = it },
                showMouth, { showMouth = it },
                showNose, { showNose = it },
                showEars, { showEars = it },
                showEyes, { showEyes = it },
                showHat, { showHat = it },
                showMustaches, { showMustaches = it },
                showShoes, { showShoes = it }
            )
        }
    } else {
        // Landscape layout
        Row(
            modifier = modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            DollImageLayer(
                showArms, showBody, showEars, showEyebrows, showEyes,
                showNose, showMouth, showMustaches, showGlasses, showHat, showShoes
            )

            Spacer(modifier = Modifier.width(24.dp))

            CheckboxLayout(
                showArms, { showArms = it },
                showEyebrows, { showEyebrows = it },
                showGlasses, { showGlasses = it },
                showMouth, { showMouth = it },
                showNose, { showNose = it },
                showEars, { showEars = it },
                showEyes, { showEyes = it },
                showHat, { showHat = it },
                showMustaches, { showMustaches = it },
                showShoes, { showShoes = it }
            )
        }
    }
}

@Composable
fun DollImageLayer(
    showArms: Boolean, showBody: Boolean, showEars: Boolean, showEyebrows: Boolean, showEyes: Boolean,
    showNose: Boolean, showMouth: Boolean, showMustaches: Boolean, showGlasses: Boolean, showHat: Boolean, showShoes: Boolean
) {
    Box(
        modifier = Modifier.size(300.dp),
        contentAlignment = Alignment.Center
    ) {
        if (showBody) Image(painter = painterResource(id = R.drawable.body), contentDescription = "body", modifier = Modifier.fillMaxSize())
        if (showArms) Image(painter = painterResource(id = R.drawable.arms), contentDescription = "arms", modifier = Modifier.fillMaxSize())
        if (showEars) Image(painter = painterResource(id = R.drawable.ears), contentDescription = "ears", modifier = Modifier.fillMaxSize())
        if (showEyebrows) Image(painter = painterResource(id = R.drawable.eyebrows), contentDescription = "eyebrows", modifier = Modifier.fillMaxSize())
        if (showEyes) Image(painter = painterResource(id = R.drawable.eyes), contentDescription = "eyes", modifier = Modifier.fillMaxSize())
        if (showNose) Image(painter = painterResource(id = R.drawable.nose), contentDescription = "nose", modifier = Modifier.fillMaxSize())
        if (showMouth) Image(painter = painterResource(id = R.drawable.mouth), contentDescription = "mouth", modifier = Modifier.fillMaxSize())
        if (showMustaches) Image(painter = painterResource(id = R.drawable.mustache), contentDescription = "mustaches", modifier = Modifier.fillMaxSize())
        if (showGlasses) Image(painter = painterResource(id = R.drawable.glasses), contentDescription = "glasses", modifier = Modifier.fillMaxSize())
        if (showHat) Image(painter = painterResource(id = R.drawable.hat), contentDescription = "hat", modifier = Modifier.fillMaxSize())
        if (showShoes) Image(painter = painterResource(id = R.drawable.shoes), contentDescription = "shoes", modifier = Modifier.fillMaxSize())
    }
}

@Composable
fun CheckboxLayout(
    showArms: Boolean, onArms: (Boolean) -> Unit,
    showEyebrows: Boolean, onEyebrows: (Boolean) -> Unit,
    showGlasses: Boolean, onGlasses: (Boolean) -> Unit,
    showMouth: Boolean, onMouth: (Boolean) -> Unit,
    showNose: Boolean, onNose: (Boolean) -> Unit,
    showEars: Boolean, onEars: (Boolean) -> Unit,
    showEyes: Boolean, onEyes: (Boolean) -> Unit,
    showHat: Boolean, onHat: (Boolean) -> Unit,
    showMustaches: Boolean, onMustaches: (Boolean) -> Unit,
    showShoes: Boolean, onShoes: (Boolean) -> Unit,
) {
    Row(horizontalArrangement = Arrangement.SpaceEvenly, modifier = Modifier.fillMaxWidth()) {
        Column {
            PartCheckbox("Arms", showArms, onArms)
            PartCheckbox("Eyebrows", showEyebrows, onEyebrows)
            PartCheckbox("Glasses", showGlasses, onGlasses)
            PartCheckbox("Mouth", showMouth, onMouth)
            PartCheckbox("Nose", showNose, onNose)
        }
        Column {
            PartCheckbox("Ears", showEars, onEars)
            PartCheckbox("Eyes", showEyes, onEyes)
            PartCheckbox("Hat", showHat, onHat)
            PartCheckbox("Mustaches", showMustaches, onMustaches)
            PartCheckbox("Shoes", showShoes, onShoes)
        }
    }
}

@Composable
fun PartCheckbox(label: String, checked: Boolean, onCheckedChange: (Boolean) -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(vertical = 4.dp)
    ) {
        Checkbox(checked = checked, onCheckedChange = onCheckedChange)
        Spacer(modifier = Modifier.width(4.dp))
        Text(text = label)
    }
}

@Preview()
@Composable
fun DollDressUpScreenPreview() {
    DressingDoll()
}
