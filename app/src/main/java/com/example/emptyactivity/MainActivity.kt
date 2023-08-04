package com.example.emptyactivity

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.PlainTooltipBox
import androidx.compose.material3.PlainTooltipState
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TooltipDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberPlainTooltipState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import com.example.emptyactivity.ui.theme.EmptyActivityTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            EmptyActivityTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Top App Bar Title") },
                actions = {
                    ActionButton(
                        onClick = { },
                        tooltipLabel = "Text under status bar",
                    ) {
                        Icon(
                            painter = painterResource(id = androidx.core.R.drawable.ic_call_answer),
                            contentDescription = "Share"
                        )
                    }
                },
            )
        },
    ) {
        Row(
            modifier = modifier
                .fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
        ) {
            Text(
                text = "Hello $name!",
            )
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ActionButton(
    onClick: () -> Unit,
    tooltipLabel: String,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    colors: IconButtonColors = IconButtonDefaults.iconButtonColors(),
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    tooltipFocusable: Boolean = true,
    tooltipState: PlainTooltipState = rememberPlainTooltipState(),
    tooltipShape: Shape = TooltipDefaults.plainTooltipContainerShape,
    tooltipContainerColor: Color = TooltipDefaults.plainTooltipContainerColor,
    tooltipContentColor: Color = TooltipDefaults.plainTooltipContentColor,
    content: @Composable () -> Unit,
) {
    PlainTooltipBox(
        tooltip = { Text(tooltipLabel) },
        modifier = Modifier.statusBarsPadding(),
        focusable = tooltipFocusable,
        tooltipState = tooltipState,
        shape = tooltipShape,
        containerColor = tooltipContainerColor,
        contentColor = tooltipContentColor,
    ) {
        IconButton(
            onClick = onClick,
            modifier = modifier.tooltipTrigger(),
            enabled = enabled,
            colors = colors,
            interactionSource = interactionSource,
            content = content,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    EmptyActivityTheme {
        Greeting("Android")
    }
}