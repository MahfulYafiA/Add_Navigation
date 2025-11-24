package com.mahful.lunchtray.model

data class OrderUiState(
    // UBAH DISINI: Gunakan MenuItem? untuk semua jenis makanan
    val entree: MenuItem? = null,
    val sideDish: MenuItem? = null,
    val accompaniment: MenuItem? = null,

    // Harga tetap sama
    val itemTotalPrice: Double = 0.0,
    val orderTax: Double = 0.0,
    val orderTotalPrice: Double = 0.0
)