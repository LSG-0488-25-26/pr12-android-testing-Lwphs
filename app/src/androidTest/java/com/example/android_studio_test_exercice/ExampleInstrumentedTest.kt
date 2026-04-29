package com.example.android_studio_test_exercice

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.android_studio_test_exercice.view.MainView
import com.example.android_studio_test_exercice.viewmodel.MainViewModel

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.android_studio_test_exercice", appContext.packageName)
    }

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun dropdownSelectItemUpdatesText() {
        val vm = MainViewModel()

        composeTestRule.setContent {
            MainView(vm)
        }

        composeTestRule.onNodeWithText("Opció A").performClick()
        composeTestRule.onNodeWithText("Opció B").performClick()
        composeTestRule.onNodeWithText("Opció B").assertIsDisplayed()
    }

    @Test
    fun searchShowsSnackbarWhenTextNotEmpty() {
        val vm = MainViewModel()

        composeTestRule.setContent {
            MainView(vm)
        }

        composeTestRule.onNodeWithText("Buscar...").performTextInput("Hola")
        composeTestRule.onNodeWithText("Buscar").performClick()

        composeTestRule.onNodeWithText("Acció completada!")
            .assertIsDisplayed()
    }

    @Test
    fun searchDoesNotShowSnackbarWhenEmpty() {
        val vm = MainViewModel()

        composeTestRule.setContent {
            MainView(vm)
        }

        composeTestRule.onNodeWithText("Buscar").performClick()
        composeTestRule.onNodeWithText("Acció completada!")
            .assertDoesNotExist()
    }

}