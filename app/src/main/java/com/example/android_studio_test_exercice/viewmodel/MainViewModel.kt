package com.example.android_studio_test_exercice.viewmodel
import androidx.compose.ui.state.ToggleableState
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel {
    // Atributs
    private val _estatSwitch: MutableLiveData<Boolean>
    val estatSwitch: LiveData<Boolean>

    private val _esVegetaria: MutableLiveData<Boolean>
    val esVegetaria: LiveData<Boolean>

    private val _esVega: MutableLiveData<Boolean>
    val esVega: LiveData<Boolean>

    private val _esCarnivor: MutableLiveData<Boolean>
    val esCarnivor: LiveData<Boolean>

    private val _triStateStatus: MutableLiveData<ToggleableState>
    val triStateStatus: LiveData<ToggleableState>

    private val _selectedOption: MutableLiveData<String>
    val selectedOption: LiveData<String>

    private val _slidervalue: MutableLiveData<Float>
    val slidervalue: LiveData<Float>


    private val _expanded: MutableLiveData<Boolean>
    val expanded: LiveData<Boolean>

    private val _selectedItem: MutableLiveData<String>
    val selectedItem: MutableLiveData<String>

    private val _searchText: MutableLiveData<String>
    val searchText: LiveData<String>

    private val _showSnackbar: MutableLiveData<Boolean>
    val showSnackbar: LiveData<Boolean>

    private val _toggleState: MutableLiveData<Boolean>
    val toggleState: LiveData<Boolean>


    /**
     * Constructor de la classe HelloViewModel
     * que inicialitzen els atributs
     */
    constructor() : super() {
        this._estatSwitch = MutableLiveData<Boolean>(true)
        this.estatSwitch = this._estatSwitch

        this._esVegetaria = MutableLiveData<Boolean>(false)
        this.esVegetaria = this._esVegetaria

        this._esVega = MutableLiveData<Boolean>(false)
        this.esVega = this._esVega

        this._esCarnivor = MutableLiveData<Boolean>(true)
        this.esCarnivor = this._esCarnivor

        this._triStateStatus = MutableLiveData<ToggleableState>(ToggleableState.Off)
        this.triStateStatus = this._triStateStatus

        this._selectedOption = MutableLiveData<String>("Messi")
        this.selectedOption = this._selectedOption

        this._slidervalue = MutableLiveData<Float>(0f)
        this.slidervalue = this._slidervalue

        _expanded = MutableLiveData<Boolean>(false)
        expanded = _expanded

        _selectedItem = MutableLiveData<String>("Opció A")
        selectedItem = _selectedItem

        _searchText = MutableLiveData<String>("")
        searchText = _searchText

        _showSnackbar = MutableLiveData<Boolean>(false)
        showSnackbar = _showSnackbar

        _toggleState = MutableLiveData<Boolean>(false)
        toggleState = _toggleState
    }

    fun toggleEstatSwitch(){
        this._estatSwitch.value = !(this._estatSwitch.value)!!
    }

    fun toggleEsCarnivor(){
        this._esCarnivor.value = !(this._esCarnivor.value)!!
    }

    fun toggleEsVega(){
        this._esVega.value = !(esVega.value)!!
    }

    fun toggleEsVegetaria(){
        this._esVegetaria.value = !(esVegetaria.value)!!
    }

    fun toggleTriStateStatus(){
        when(this._triStateStatus.value){
            ToggleableState.On -> setTriStateStatus(ToggleableState.Off)
            ToggleableState.Off -> setTriStateStatus(ToggleableState.Indeterminate)
            ToggleableState.Indeterminate -> setTriStateStatus(ToggleableState.On)
            null -> setTriStateStatus(ToggleableState.On)
        }
    }

    private fun setTriStateStatus(triState: ToggleableState){
        this._triStateStatus.value = triState
    }

    public fun setSelectedOption(player: String) {
        this._selectedOption.value = player
    }
    public fun setSelectedItem(item: String) {
        this.selectedItem.value = item
    }

    public fun setSliderValue(sliderVal: Float) {
        this._slidervalue.value = sliderVal
    }

    public fun setExpanded(expanded: Boolean) {
        this._expanded.value = expanded
    }

    public fun setSearchText(text: String) {
        this._searchText.value = text
    }

    public fun performSearch() {
        // ???? Nosé recomanacions de android studio xd
        _searchText.value?.isEmpty()?.let {
            if (!it) {
                _showSnackbar.value = true
            } else {
                _showSnackbar.value = false
            }
        }
    }
}