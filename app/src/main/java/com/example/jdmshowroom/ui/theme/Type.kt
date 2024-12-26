package com.example.jdmshowroom.ui.theme
import androidx.compose.material3.Typography
// Mengimpor kelas Typography dari Material Design 3 untuk mendefinisikan gaya teks global.

import androidx.compose.ui.text.TextStyle
// Mengimpor kelas TextStyle untuk menentukan atribut seperti font, ukuran, dan lainnya.

import androidx.compose.ui.text.font.FontFamily
// Mengimpor kelas FontFamily untuk mengatur keluarga font.

import androidx.compose.ui.text.font.FontWeight
// Mengimpor kelas FontWeight untuk mengatur ketebalan font.

import androidx.compose.ui.unit.sp
// Mengimpor satuan ukuran teks berbasis scalable pixels (sp), digunakan untuk mengatur ukuran teks.

val Typography = Typography(
// Mendeklarasikan variabel `Typography` untuk mengatur gaya teks global dalam tema aplikasi.

    bodyLarge = TextStyle(
        // Mendefinisikan gaya teks untuk elemen yang menggunakan `bodyLarge`.

        fontFamily = FontFamily.Default,
        // Mengatur keluarga font menjadi default (font bawaan sistem).

        fontWeight = FontWeight.Normal,
        // Mengatur ketebalan teks menjadi normal.

        fontSize = 16.sp,
        // Mengatur ukuran teks menjadi 16 sp.

        lineHeight = 24.sp,
        // Mengatur tinggi baris teks menjadi 24 sp untuk memberikan spasi antar baris.

        letterSpacing = 0.5.sp
        // Mengatur jarak antar huruf menjadi 0.5 sp untuk meningkatkan keterbacaan.
    )
)
