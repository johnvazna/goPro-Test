package com.johnvazna.goprotest

import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.johnvazna.goprotest.ui.theme.GoProTestTheme
import com.johnvazna.stream_feature.presentation.ui.PlaybackScreen
import com.johnvazna.stream_feature.presentation.ui.ProfessionalVideoScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GoProTestTheme {
                AppNavHost(modifier = Modifier.fillMaxSize())
            }
        }
    }
}

@Composable
private fun AppNavHost(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "videos",
        modifier = modifier
    ) {
        composable("videos") {
            ProfessionalVideoScreen(
                navToPlayback = { url ->
                    navController.navigate("playback/${Uri.encode(url)}")
                }
            )
        }
        composable(
            route = "playback/{url}",
            arguments = listOf(navArgument("url") {
                type = NavType.StringType
            })
        ) { backStackEntry ->
            val rawUrl = backStackEntry.arguments?.getString("url") ?: ""
            val streamUrl = Uri.decode(rawUrl)
            PlaybackScreen(
                streamUrl = streamUrl,
                onBack = { navController.popBackStack() }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AppNavHostPreview() {
    GoProTestTheme {
        AppNavHost()
    }
}
