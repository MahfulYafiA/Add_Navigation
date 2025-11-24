package com.mahful.lunchtray.ui.theme

import androidx.lifecycle.ViewModel
import com.mahful.lunchtray.model.MenuItem
import com.mahful.lunchtray.model.OrderUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.text.NumberFormat

class OrderViewModel : ViewModel() {

    private val taxRate = 0.08

    private val _uiState = MutableStateFlow(OrderUiState())
    val uiState: StateFlow<OrderUiState> = _uiState.asStateFlow()

    // Ubah parameter menjadi MenuItem biasa
    fun updateEntree(entree: MenuItem) {
        val previousEntree = _uiState.value.entree
        updateItem(entree, previousEntree)
    }

    fun updateSideDish(sideDish: MenuItem) {
        val previousSideDish = _uiState.value.sideDish
        updateItem(sideDish, previousSideDish)
    }

    fun updateAccompaniment(accompaniment: MenuItem) {
        val previousAccompaniment = _uiState.value.accompaniment
        updateItem(accompaniment, previousAccompaniment)
    }

    fun resetOrder() {
        _uiState.value = OrderUiState()
    }

    private fun updateItem(newItem: MenuItem, previousItem: MenuItem?) {
        _uiState.update { currentState ->
            val previousItemPrice = previousItem?.price ?: 0.0

            // Hitung harga item total baru
            val itemTotalPrice = currentState.itemTotalPrice - previousItemPrice + newItem.price

            // Hitung pajak
            val tax = itemTotalPrice * taxRate

            // Update state
            // Kita menggunakan logika 'type' (1, 2, 3) yang sudah kita buat di MenuItem.kt
            currentState.copy(
                itemTotalPrice = itemTotalPrice,
                orderTax = tax,
                orderTotalPrice = itemTotalPrice + tax,
                entree = if (newItem.type == 1) newItem else currentState.entree,
                sideDish = if (newItem.type == 2) newItem else currentState.sideDish,
                accompaniment = if (newItem.type == 3) newItem else currentState.accompaniment
            )
        }
    }
}

// Extension function untuk format harga
fun Double.formatPrice(): String {
    return NumberFormat.getCurrencyInstance().format(this)
}