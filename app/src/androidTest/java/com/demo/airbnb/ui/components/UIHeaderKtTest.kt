package com.demo.airbnb.ui.components

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import com.demo.airbnb.ui.theme.AirbnbTheme
import org.junit.Rule
import org.junit.Test

import com.demo.airbnb.R

class UIHeaderKtTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    @Test
    fun checkLabelContent() {
        composeTestRule.setContent {
            AirbnbTheme {
                UIHeader(R.string.homescreen_title)
            }
        }

        val label = composeTestRule.activity.getString(R.string.homescreen_title)
        composeTestRule.onNodeWithText(label).assertIsDisplayed()
    }
}