package com.demo.airbnb.ui.features.login

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsEnabled
import androidx.compose.ui.test.assertIsNotEnabled
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performTextInput
import com.demo.airbnb.R
import com.demo.airbnb.ui.theme.AirbnbTheme
import org.junit.Rule
import org.junit.Test

class LoginScreenKtTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    @Test
    fun loginScreenLabelsShouldBeVisible() {
        composeTestRule.setContent {
            AirbnbTheme {
                LoginScreen()
            }
        }

        composeTestRule
            .onNodeWithText(composeTestRule.activity.getString(R.string.login_sms_confirmation))
            .assertIsDisplayed()

        composeTestRule
            .onNodeWithText(composeTestRule.activity.getString(R.string.login_continue_with_email))
            .assertIsDisplayed()

        composeTestRule
            .onNodeWithText(composeTestRule.activity.getString(R.string.login_continue_with_google))
            .assertIsDisplayed()
    }

    @Test
    fun loginScreenSignUpButtonIsDisabledWhenScreenIsLoaded() {
        composeTestRule.setContent {
            AirbnbTheme {
                LoginScreen()
            }
        }

        composeTestRule
            .onNodeWithTag("LoginSignUpButton")
            .assertIsNotEnabled()
    }

    @Test
    fun loginScreenSignUpButtonShouldBeEnabledWhenCountryAndPhoneIsFilled() {
        composeTestRule.setContent {
            AirbnbTheme {
                LoginScreen()
            }
        }

        composeTestRule
            .onNodeWithTag("LoginCountryTextField")
            .performTextInput("Brazil")

        composeTestRule
            .onNodeWithTag("LoginPhoneTextField")
            .performTextInput("12345678")

        composeTestRule
            .onNodeWithTag("LoginSignUpButton")
            .assertIsEnabled()
    }
}