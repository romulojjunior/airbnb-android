package com.demo.airbnb.ui.features.login

import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsEnabled
import androidx.compose.ui.test.assertIsNotEnabled
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import com.demo.airbnb.MainTestActivity
import com.demo.airbnb.R
import com.demo.airbnb.domain.usecases.account.ISignInUC
import com.demo.airbnb.ui.theme.AirbnbTheme
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject

@HiltAndroidTest
class LoginScreenTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainTestActivity>()

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Inject
    lateinit var signInUC: ISignInUC

    private val countryMock = "Brazil"
    private val numberMock = "12345678"

    // UI Tags
    private val loginCountryTextField =  "LoginCountryTextField"
    private val loginPhoneTextField = "LoginPhoneTextField"
    private val loginSignUpButton = "LoginSignUpButton"

    @Before
    fun setUp() {
        hiltRule.inject()
    }

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun loginScreenShouldDisplaySuccessMessageAfterSignIn() {
        val loginVM = LoginVM(signInUC=signInUC)

        composeTestRule.setContent {
            AirbnbTheme {
                LoginScreen(
                    uiState = loginVM.uiState,
                    signIn = {name, email -> loginVM.signIn(name, email) },
                )
            }
        }

        composeTestRule
            .onNodeWithTag(loginCountryTextField)
            .performTextInput(countryMock)

        composeTestRule
            .onNodeWithTag(loginPhoneTextField)
            .performTextInput(numberMock)

        composeTestRule
            .onNodeWithTag(loginSignUpButton)
            .assertIsEnabled()

        composeTestRule
            .onNodeWithTag(loginSignUpButton)
            .performClick()

        val signInSuccessMSG = composeTestRule.activity.getString(R.string.login_sign_in_success)
        composeTestRule.waitUntilExactlyOneExists(hasText(signInSuccessMSG), 2000)
    }

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
            .onNodeWithTag(loginSignUpButton)
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
            .onNodeWithTag(loginCountryTextField)
            .performTextInput(countryMock)

        composeTestRule
            .onNodeWithTag(loginPhoneTextField)
            .performTextInput(numberMock)

        composeTestRule
            .onNodeWithTag(loginSignUpButton)
            .assertIsEnabled()
    }
}


