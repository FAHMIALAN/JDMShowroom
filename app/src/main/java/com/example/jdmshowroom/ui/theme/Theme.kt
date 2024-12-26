package com.example.jdmshowroom.ui.theme // Mendefinisikan paket tempat file ini berada

import android.os.Build // Mengimpor kelas Build untuk memeriksa versi Android
import androidx.compose.foundation.isSystemInDarkTheme // Mengimpor fungsi untuk memeriksa tema gelap sistem
import androidx.compose.material3.* // Mengimpor komponen Material 3
import androidx.compose.runtime.Composable // Mengimpor anotasi Composable
import androidx.compose.ui.platform.LocalContext // Mengimpor kelas untuk mendapatkan konteks lokal
import androidx.compose.ui.graphics.Color // Mengimpor kelas Color untuk pengaturan warna

// Mendefinisikan warna khusus untuk aplikasi
val LightGray = Color(0xFFD3D3D3) // Warna abu-abu terang
val DarkOrange = Color(0xFFFF8C00) // Warna oranye gelap
val blackColor = Color(0xFF000000) // Warna hitam

// Skema warna untuk tema gelap
private val DarkColorScheme = darkColorScheme(
    primary = DarkOrange, // Mengatur warna primer
    onPrimary = LightGray, // Mengatur warna untuk teks di atas warna primer
    tertiary = Pink80, // Mengatur warna tersier
    background = Color(0xFF121212), // Mengatur warna latar belakang gelap
    surface = Color(0xFF121212) // Mengatur warna permukaan gelap
)

// Skema warna untuk tema terang
private val LightColorScheme = lightColorScheme(
    primary = DarkOrange, // Mengatur warna primer
    onPrimary = blackColor, // Mengatur warna untuk teks di atas warna primer
    tertiary = blackColor, // Mengatur warna tersier
    background = Color.White, // Mengatur warna latar belakang terang
    surface = Color.White // Mengatur warna permukaan terang
)

// Fungsi tema utama untuk aplikasi
@Composable
fun JDMShowroomTheme(
    darkTheme: Boolean = isSystemInDarkTheme(), // Menentukan tema gelap berdasarkan pengaturan sistem
    dynamicColor: Boolean = true, // Menentukan apakah menggunakan warna dinamis
    content: @Composable () -> Unit // Konten yang akan dirender dalam tema
) {
    // Menentukan skema warna berdasarkan tema
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> { // Memeriksa apakah warna dinamis diizinkan
            val context = LocalContext.current // Mendapatkan konteks lokal
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context) // Mengatur skema warna dinamis
        }
        darkTheme -> DarkColorScheme // Menggunakan skema warna gelap
        else -> LightColorScheme // Menggunakan skema warna terang
    }

    // Mengatur tema Material dengan skema warna dan tipografi
    MaterialTheme(
        colorScheme = colorScheme, // Mengatur skema warna
        typography = Typography, // Mengatur tipografi
        content = content // Menyediakan konten yang akan dirender
    )
}