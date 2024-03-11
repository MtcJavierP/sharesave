package com.javierpastor.sharesave.view

import android.content.SharedPreferences
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

//
//@HiltViewModel
//class SupermercadoViewModel @Inject constructor(
//    private val dataStore: DataStore<Preferences>,
//    private val sharedPreferences: SharedPreferences
//) : ViewModel() {
//
//    init {
//        val numSupermercados = getSuperMercados().size
//        saveNumSupermercados(numSupermercados)
//    }
//
//    private fun saveNumSupermercados(numSupermercados: Int) {
//        // Save to SharedPreferences
//        with(sharedPreferences.edit()) {
//            putInt("numSupermercados", numSupermercados)
//            apply()
//        }
//
//        // Save to DataStore
//        viewModelScope.launch {
//            dataStore.edit { preferences ->
//                preferences[stringPreferencesKey("numSupermercados")] = numSupermercados.toString()
//            }
//        }
//    }
//
//    val numSupermercados: LiveData<Int> = dataStore.data
//        .map { preferences ->
//            preferences[stringPreferencesKey("numSupermercados")]?.toInt() ?: 0
//        }
//        .asLiveData()
//
//    val numSupermercadosSharedPref: Int
//        get() = sharedPreferences.getInt("numSupermercados", 0)
//}

//@HiltViewModel
//class SupermercadoViewModel @Inject constructor(
//    private val dataStore: DataStore<Preferences>,
//    private val sharedPreferences: SharedPreferences
//) : ViewModel() {
//
//    init {
//        val numSupermercados = getSuperMercados().size
//        saveNumSupermercados(numSupermercados)
//    }
//
//    private fun saveNumSupermercados(numSupermercados: Int) {
//        // Save to SharedPreferences
//        with(sharedPreferences.edit()) {
//            putInt("numSupermercados", numSupermercados)
//            apply()
//        }
//
//        // Save to DataStore
//        viewModelScope.launch {
//            dataStore.edit { preferences ->
//                preferences[stringPreferencesKey("numSupermercados")] = numSupermercados.toString()
//            }
//        }
//    }
//
//    val numSupermercados: Flow<Int> = dataStore.data
//        .map { preferences ->
//            preferences[stringPreferencesKey("numSupermercados")]?.toInt() ?: 0
//        }
//
//    val numSupermercadosSharedPref: Int
//        get() = sharedPreferences.getInt("numSupermercados", 0)
//}

@HiltViewModel
class SupermercadoViewModel @Inject constructor(
    private val dataStore: DataStore<Preferences>,
    private val sharedPreferences: SharedPreferences
) : ViewModel() {

    private val _numSupermercados = MutableStateFlow(0)
    val numSupermercados: StateFlow<Int> = _numSupermercados

    init {
        val numSupermercados = getSuperMercados().size
        saveNumSupermercados(numSupermercados)
    }

    private fun saveNumSupermercados(numSupermercados: Int) {
        // Save to SharedPreferences
        with(sharedPreferences.edit()) {
            putInt("numSupermercados", numSupermercados)
            apply()
        }

        // Save to DataStore
        viewModelScope.launch {
            dataStore.edit { preferences ->
                preferences[stringPreferencesKey("numSupermercados")] = numSupermercados.toString()
            }
            _numSupermercados.value = numSupermercados
        }
    }

    val numSupermercadosSharedPref: Int
        get() = sharedPreferences.getInt("numSupermercados", 0)
}