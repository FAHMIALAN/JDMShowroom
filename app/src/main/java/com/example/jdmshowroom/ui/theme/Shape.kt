package com.example.jdmshowroom.ui.theme
// Mendeklarasikan package tempat file ini berada, digunakan untuk mengorganisasi file tema aplikasi.

import androidx.compose.foundation.shape.RoundedCornerShape
// Mengimpor kelas untuk membuat bentuk dengan sudut melengkung.

import androidx.compose.material3.Shapes
// Mengimpor kelas Shapes dari Material Design 3, yang memungkinkan kita mengatur bentuk global untuk elemen UI.

import androidx.compose.ui.unit.dp
// Mengimpor satuan ukuran berbasis density-independent pixel (dp).

val Shapes = Shapes(
// Mendeklarasikan variabel `Shapes` untuk mengatur bentuk elemen UI secara global dalam tema aplikasi.

    small = RoundedCornerShape(50.dp),
    // Mendefinisikan bentuk kecil dengan semua sudut melengkung menggunakan radius 50 dp.

    medium = RoundedCornerShape(bottomStart = 16.dp, topEnd = 16.dp)
    // Mendefinisikan bentuk medium dengan sudut bawah-kiri dan atas-kanan melengkung menggunakan radius 16 dp.
)
