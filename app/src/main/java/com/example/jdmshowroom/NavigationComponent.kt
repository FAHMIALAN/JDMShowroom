package com.example.jdmshowroom // Mendefinisikan paket tempat file ini berada

import androidx.compose.runtime.Composable // Mengimpor anotasi Composable
import androidx.navigation.NavHostController // Mengimpor kelas untuk mengontrol navigasi
import androidx.navigation.compose.NavHost // Mengimpor NavHost untuk mengatur navigasi
import androidx.navigation.compose.composable // Mengimpor fungsi untuk mendefinisikan composable di dalam NavHost
import com.example.jdmshowroom.ui.screens.* // Mengimpor semua layar dari paket screens

// Fungsi composable untuk mengatur navigasi aplikasi
@Composable
fun NavigationComponent(navController: NavHostController) {
    NavHost(navController, startDestination = "car_list") { // Mengatur NavHost dengan controller dan tujuan awal
        composable("car_list") { // Mendefinisikan layar untuk daftar mobil
            CarListScreen(navController) // Memanggil CarListScreen dan meneruskan navController
        }
        composable("car_details/{carId}") { backStackEntry -> // Mendefinisikan layar untuk detail mobil
            val carId = backStackEntry.arguments?.getString("carId") // Mengambil carId dari argumen
            CarDetailsScreen(navController, carId) // Memanggil CarDetailsScreen dengan navController dan carId
        }
        composable("beli/{carId}") { backStackEntry -> // Mendefinisikan layar untuk pembelian mobil
            val carId = backStackEntry.arguments?.getString("carId") // Mengambil carId dari argumen
            BeliScreen(carId, navController) // Memanggil BeliScreen dengan carId dan navController
        }
        composable("detail_pemesanan/{namaPemesan}/{alamat}/{nomorTelepon}/{metodePembayaran}/{harga}/{pajak}") { backStackEntry -> // Mendefinisikan layar untuk detail pemesanan
            val namaPemesan = backStackEntry.arguments?.getString("namaPemesan") ?: "" // Mengambil nama pemesan dari argumen
            val alamat = backStackEntry.arguments?.getString("alamat") ?: "" // Mengambil alamat dari argumen
            val nomorTelepon = backStackEntry.arguments?.getString("nomorTelepon") ?: "" // Mengambil nomor telepon dari argumen
            val metodePembayaran = backStackEntry.arguments?.getString("metodePembayaran") ?: "" // Mengambil metode pembayaran dari argumen
            val harga = backStackEntry.arguments?.getString("harga") ?: "" // Mengambil harga dari argumen
            val pajak = backStackEntry.arguments?.getString("pajak") ?: "" // Mengambil pajak dari argumen
            DetailPemesananScreen(navController, namaPemesan, alamat, nomorTelepon, metodePembayaran, harga, pajak) // Memanggil DetailPemesananScreen dengan semua argumen
        }
    }
}