package com.demo.airbnb.ui.features.login

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.demo.airbnb.R
import com.demo.airbnb.ui.components.UILoading
import com.demo.airbnb.ui.components.UIOutlinedButton
import com.demo.airbnb.ui.theme.AirbnbTheme

@Composable
fun LoginScreen(
    uiState: MutableState<LoginVM.UIState> = mutableStateOf(LoginVM.UIState()),
    navigateToHome: () -> Unit = {},
    signIn: (email: String, password: String) -> Unit = { _, _ -> },
) {
    var country by rememberSaveable {
        mutableStateOf("")
    }

    var phoneNumber by rememberSaveable {
        mutableStateOf("")
    }

    var isSignUpEnable by rememberSaveable {
        mutableStateOf(false)
    }

    val fakeUserSignIn: () -> Unit = {
        signIn("FakeUser@email.com", "fakePass1234")
    }

    LaunchedEffect(key1 = phoneNumber, key2 = country, block = {
        isSignUpEnable = country.isNotBlank() && phoneNumber.contains("\\d{8}".toRegex())
    })

    LaunchedEffect(key1 = uiState.value.session, block = {
        if (uiState.value.session != null) {
            navigateToHome()
        }
    })

    if (uiState.value.isLoading) {
        UILoading()
        return
    }

    Surface(
        color = MaterialTheme.colorScheme.background,
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
        ) {
            Box(modifier = Modifier.padding(bottom = 32.dp)) {
                Text(
                    stringResource(R.string.loginscreen_title),
                    style = MaterialTheme.typography.titleLarge
                )
            }
            OutlinedTextField(
                value = country,
                onValueChange = { country = it },
                placeholder = { Text(text = stringResource(id = R.string.login_country_or_region)) },
                singleLine = true,
                modifier = Modifier
                    .testTag("LoginCountryTextField")
                    .fillMaxWidth()
            )
            OutlinedTextField(
                value = phoneNumber,
                onValueChange = { phoneNumber = it.replace("\\D.*".toRegex(), "") },
                placeholder = { Text(text = stringResource(id = R.string.login_phone_number)) },
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                modifier = Modifier
                    .testTag("LoginPhoneTextField")
                    .fillMaxWidth()
            )
            Text(
                text = stringResource(R.string.login_sms_confirmation),
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(vertical = 8.dp)
            )
            Button(
                contentPadding = PaddingValues(vertical = 16.dp),
                enabled = isSignUpEnable,
                onClick = { fakeUserSignIn() },
                modifier = Modifier
                    .testTag("LoginSignUpButton")
                    .padding(vertical = 8.dp)
                    .fillMaxWidth(),
                shape = MaterialTheme.shapes.small
            ) {
                Text(text = stringResource(R.string.sign_up))
            }
            if (uiState.value.session != null) {
                Text(text = stringResource(R.string.login_sign_in_success))
            }

            if (uiState.value.exception != null) {
                Text(text = stringResource(R.string.login_sign_in_error))
            }

            Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()) {
                Text(text = stringResource(R.string.or))
            }
            Row(modifier = Modifier.padding(vertical = 8.dp)) {
                UIOutlinedButton(
                    label = stringResource(id = R.string.login_continue_with_email),
                    iconPainter = painterResource(id = R.drawable.outline_email_24),
                    onClick = { fakeUserSignIn() })
            }
            Row(modifier = Modifier.padding(vertical = 8.dp)) {
                UIOutlinedButton(
                    label = stringResource(id = R.string.login_continue_with_google),
                    iconPainter = painterResource(id = R.drawable.ic_sign_in_google_24),
                    tint = Color.Unspecified,
                    onClick = { fakeUserSignIn() })
            }
        }
    }
}

@Composable
@Preview(
    showBackground = true,
    device = "id:pixel_6a",
)
fun LoginScreenPreview() {
    AirbnbTheme {
        LoginScreen()
    }
}

@Composable
@Preview(
    device = "id:pixel_6a",
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
fun LoginScreenNightPreview() {
    AirbnbTheme {
        LoginScreen()
    }
}