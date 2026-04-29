package com.example.android_studio_test_exercice

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.compose.ui.state.ToggleableState
import com.example.android_studio_test_exercice.viewmodel.MainViewModel
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }


    @get:Rule
    val rule = InstantTaskExecutorRule()

    private lateinit var viewModel: MainViewModel

    @Before
    fun setup() {
        viewModel = MainViewModel()
    }

    @Test
    fun toggleEstatSwitch_changesValue() {
        val initial = viewModel.estatSwitch.value
        viewModel.toggleEstatSwitch()
        assertEquals(!initial!!, viewModel.estatSwitch.value)
    }

    @Test
    fun toggleEsCarnivor_changesValue() {
        val initial = viewModel.esCarnivor.value
        viewModel.toggleEsCarnivor()
        assertEquals(!initial!!, viewModel.esCarnivor.value)
    }

    @Test
    fun toggleEsVega_changesValue() {
        val initial = viewModel.esVega.value
        viewModel.toggleEsVega()
        assertEquals(!initial!!, viewModel.esVega.value)
    }

    @Test
    fun toggleEsVegetaria_changesValue() {
        val initial = viewModel.esVegetaria.value
        viewModel.toggleEsVegetaria()
        assertEquals(!initial!!, viewModel.esVegetaria.value)
    }

    @Test
    fun toggleTriStateStatus_cyclesCorrectly() {
        viewModel.toggleTriStateStatus()
        assertEquals(ToggleableState.Indeterminate, viewModel.triStateStatus.value)

        viewModel.toggleTriStateStatus()
        assertEquals(ToggleableState.On, viewModel.triStateStatus.value)

        viewModel.toggleTriStateStatus()
        assertEquals(ToggleableState.Off, viewModel.triStateStatus.value)
    }

    @Test
    fun setSelectedOption_updatesValue() {
        viewModel.setSelectedOption("Cristiano")
        assertEquals("Cristiano", viewModel.selectedOption.value)
    }

    @Test
    fun setSelectedItem_updatesValue() {
        viewModel.setSelectedItem("Opció B")
        assertEquals("Opció B", viewModel.selectedItem.value)
    }

    @Test
    fun setSliderValue_updatesValue() {
        viewModel.setSliderValue(5.5f)
        assertEquals(5.5f, viewModel.slidervalue.value)
    }

    @Test
    fun setExpanded_updatesValue() {
        viewModel.setExpanded(true)
        assertEquals(true, viewModel.expanded.value)
    }

    @Test
    fun setSearchText_updatesValue() {
        viewModel.setSearchText("67")
        assertEquals("67", viewModel.searchText.value)
    }

    @Test
    fun performSearch_showsSnackbar_whenTextNotEmpty() {
        viewModel.setSearchText("SixSeven")
        viewModel.performSearch()
        assertEquals(true, viewModel.showSnackbar.value)
    }

    @Test
    fun performSearch_hidesSnackbar_whenTextEmpty() {
        viewModel.setSearchText("")
        viewModel.performSearch()
        assertEquals(false, viewModel.showSnackbar.value)
    }

}