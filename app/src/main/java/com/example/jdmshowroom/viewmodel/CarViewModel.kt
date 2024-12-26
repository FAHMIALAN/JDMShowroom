package com.example.jdmshowroom.viewmodel // Mendefinisikan paket tempat file ini berada

import androidx.lifecycle.ViewModel // Mengimpor kelas ViewModel dari Android Lifecycle
import com.example.jdmshowroom.R // Mengimpor resource dari paket R

// Mendefinisikan data class untuk mobil
data class Car(
    val id: Int, // ID unik untuk setiap mobil
    val name: String, // Nama mobil
    val image: Int, // Resource ID untuk gambar mobil
    val price: String, // Harga mobil
    val features: List<String> // Daftar fitur mobil
)

// Mendefinisikan ViewModel untuk daftar mobil
class CarViewModel : ViewModel() {
    // Daftar mobil yang tersedia
    val cars = listOf(
        Car(
            id = 0, // ID mobil
            name = "Toyota Supra MK-5", // Nama mobil
            image = R.drawable.toyota_supra, // Mengambil resource gambar mobil
            price = "Rp 7.500.000.000", // Harga mobil
            features = listOf("Mesin Turbocharged", "Penggerak Roda Belakang", "Coupe 2 Pintu") // Fitur mobil
        ),
        Car(
            id = 1,
            name = "Mazda RX-7",
            image = R.drawable.mazda_rx7,
            price = "Rp 2.750.000.000",
            features = listOf("Mesin Rotary", "Desain Ringan", "Penggerak Roda Belakang")
        ),
        Car(
            id = 2,
            name = "Subaru WRX",
            image = R.drawable.subaru_wrx,
            price = "Rp 1.250.000.000",
            features = listOf("Penggerak Semua Roda", "Mesin Turbocharged", "Handling Sporty")
        ),
        Car(
            id = 3,
            name = "Nissan Skyline GT-R34",
            image = R.drawable.nisan_r34,
            price = "Rp 3.050.000.000",
            features = listOf("Mesin Twin-Turbo", "Penggerak Semua Roda", "Desain Ikonik")
        ),
        Car(
            id = 4,
            name = "Honda Civic EG-6",
            image = R.drawable.civic_eg6,
            price = "Rp 400.000.000",
            features = listOf("Desain Ringan", "Mesin dengan Putaran Tinggi", "Penggerak Roda Depan")
        ),
        Car(
            id = 5,
            name = "Honda Civic Turbo",
            image = R.drawable.civic_turbo,
            price = "Rp 575.000.000",
            features = listOf("Mesin Turbocharged", "Efisiensi Bahan Bakar", "Desain Modern")
        ),
        Car(
            id = 6,
            name = "Nissan Skyline R32",
            image = R.drawable.nisanr32,
            price = "Rp 3.200.000.000",
            features = listOf("Mesin Twin-Turbo", "Penggerak Semua Roda", "Gaya Klasik Skyline")
        ),
        Car(
            id = 7,
            name = "Nissan Silvia S15",
            image = R.drawable.silvia,
            price = "Rp 2.600.000.000",
            features = listOf("Penggerak Roda Belakang", "Mesin Turbocharged", "Siap untuk Drift")
        ),
        Car(
            id = 8,
            name = "Lancer Evo-10",
            image = R.drawable.lancerx,
            price = "Rp 2.675.000.000",
            features = listOf("Penggerak Semua Roda", "Mesin Turbocharged", "Gaya Agresif")
        ),
        Car(
            id = 9,
            name = "Toyota JZX-100",
            image = R.drawable.jzx100,
            price = "Rp 825.000.000",
            features = listOf("Penggerak Roda Belakang", "Performa Andal", "Interior Luas")
        ),
        Car(
            id = 10,
            name = "Toyota AE-86",
            image = R.drawable.ae86,
            price = "Rp 575.000.000",
            features = listOf("Desain Ringan", "Penggerak Roda Belakang", "Ikon Drift")
        ),
        Car(
            id = 11,
            name = "Mazda RX-7",
            image = R.drawable.rx7,
            price = "Rp 2.750.000.000",
            features = listOf("Mesin Rotary", "Desain Aerodinamis", "Penggerak Roda Belakang")
        ),
        Car(
            id = 12,
            name = "Toyota Supra MK-4",
            image = R.drawable.supramk4,
            price = "Rp 5.975.000.000",
            features = listOf("Mesin Turbocharged", "Penggerak Roda Belakang", "Atap Targa")
        ),
        Car(
            id = 13,
            name = "Lancer Evo-8",
            image = R.drawable.lancer_evo8,
            price = "Rp 1.600.000.000",
            features = listOf("Penggerak Semua Roda", "Mesin Turbocharged", "Terinspirasi dari Rally")
        ),
        Car(
            id = 14,
            name = "Honda S2000",
            image = R.drawable.hondas2000,
            price = "Rp 650.000.000",
            features = listOf("Mesin dengan Putaran Tinggi", "Penggerak Roda Belakang", "Convertible")
        ),
        Car(
            id = 15,
            name = "Nissan Skyline GT-R35",
            image = R.drawable.nissan_skyline,
            price = "Rp 7.800.000.000",
            features = listOf("V6 Twin-Turbo", "Penggerak Semua Roda", "Performa Supercar Modern")
        )
    ) // Mengakhiri daftar mobil
}