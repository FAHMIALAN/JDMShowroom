package com.example.jdmshowroom
// Mendeklarasikan package tempat file ini berada, membantu mengorganisasi kode dalam aplikasi.

import android.os.Bundle
// Mengimpor kelas Bundle untuk menyimpan dan mengambil data selama siklus hidup aktivitas.

import androidx.activity.ComponentActivity
// Mengimpor kelas ComponentActivity, yang merupakan basis untuk aktivitas berbasis Compose.

import androidx.activity.compose.setContent
// Mengimpor fungsi `setContent` untuk menetapkan UI berbasis Jetpack Compose di dalam aktivitas.

import androidx.navigation.compose.rememberNavController
// Mengimpor fungsi untuk membuat kontroler navigasi Jetpack Compose, digunakan untuk mengelola navigasi antar layar.

import com.example.jdmshowroom.ui.theme.JDMShowroomTheme
// Mengimpor tema khusus aplikasi yang didefinisikan di package `ui.theme`.

class MainActivity : ComponentActivity() {
// Mendeklarasikan kelas `MainActivity`, yang merupakan titik masuk utama aplikasi.

    override fun onCreate(savedInstanceState: Bundle?) {
        // Menimpa metode `onCreate` untuk menetapkan apa yang dilakukan aplikasi saat aktivitas dibuat.

        super.onCreate(savedInstanceState)
        // Memanggil implementasi `onCreate` dari superclass untuk memastikan aktivitas bekerja dengan benar.

        setContent {
            // Menentukan konten UI aktivitas menggunakan Jetpack Compose.

            JDMShowroomTheme {
                // Membungkus konten dalam tema aplikasi `JDMShowroomTheme` untuk menerapkan gaya global.

                val navController = rememberNavController()
                // Membuat dan mengingat kontroler navigasi untuk mengelola navigasi antar layar.

                NavigationComponent(navController)
                // Menjalankan fungsi `NavigationComponent` untuk mengatur navigasi antar layar.
                // Pastikan fungsi `NavigationComponent` didefinisikan di tempat lain dalam proyek Anda.
            }
        }
    }
}
