package com.mahful.lunchtray.model

import java.text.NumberFormat

/**
 * Data class untuk item menu.
 * Kita menggunakan 'type' (1, 2, 3) untuk membedakan jenis makanannya.
 */
data class MenuItem(
    val name: String,
    val description: String,
    val price: Double,
    val type: Int // 1 = Entree, 2 = SideDish, 3 = Accompaniment
) {
    /**
     * Getter method for price.
     * Includes formatting.
     */
    fun getFormattedPrice(): String = NumberFormat.getCurrencyInstance().format(price)
}