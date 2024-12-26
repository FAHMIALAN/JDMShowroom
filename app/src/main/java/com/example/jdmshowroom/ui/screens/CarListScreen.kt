package com.example.jdmshowroom.ui.screens // Mendefinisikan paket tempat file ini berada

import androidx.compose.foundation.Image // Mengimpor komponen Image dari Jetpack Compose
import androidx.compose.foundation.layout.* // Mengimpor layout dasar seperti Column, Row, dll.
import androidx.compose.foundation.clickable // Mengimpor fungsi untuk membuat elemen klik
import androidx.compose.foundation.lazy.LazyColumn // Mengimpor LazyColumn untuk daftar yang dapat digulir
import androidx.compose.material3.* // Mengimpor komponen Material 3
import androidx.compose.runtime.Composable // Mengimpor anotasi Composable
import androidx.compose.ui.Alignment // Mengimpor kelas untuk penempatan alignment
import androidx.compose.ui.Modifier // Mengimpor kelas untuk memodifikasi elemen
import androidx.compose.ui.graphics.Color // Mengimpor kelas Color untuk pengaturan warna
import androidx.compose.ui.layout.ContentScale // Mengimpor ContentScale untuk pengaturan skala gambar
import androidx.compose.ui.res.dimensionResource // Mengimpor fungsi untuk mendapatkan dimensi dari resources
import androidx.compose.ui.res.painterResource // Mengimpor fungsi untuk mendapatkan resource gambar
import androidx.compose.ui.res.stringResource // Mengimpor fungsi untuk mendapatkan string dari resources
import androidx.compose.ui.text.font.FontWeight // Mengimpor kelas FontWeight untuk pengaturan berat font
import androidx.compose.ui.unit.sp // Mengimpor satuan ukuran sp untuk teks
import androidx.navigation.NavHostController // Mengimpor kelas untuk mengontrol navigasi
import com.example.jdmshowroom.R // Mengimpor resource dari paket R
import com.example.jdmshowroom.viewmodel.CarViewModel // Mengimpor kelas ViewModel untuk data mobil

@OptIn(ExperimentalMaterial3Api::class) // Menandai penggunaan API eksperimental
@Composable // Menandai fungsi ini sebagai Composable
fun CarListScreen(navController: NavHostController, carViewModel: CarViewModel = CarViewModel()) {
    Scaffold( // Fungsi Scaffold untuk menyediakan struktur dasar aplikasi
        topBar = { // Menentukan bagian atas (top bar) dari Scaffold
            CenterAlignedTopAppBar( // Membuat AppBar yang terpusat
                title = { // Menentukan judul AppBar
                    Row( // Menggunakan Row untuk menampilkan elemen secara horizontal
                        verticalAlignment = Alignment.CenterVertically, // Menyelaraskan elemen di tengah vertikal
                        modifier = Modifier.padding(horizontal = dimensionResource(id = R.dimen.padding_medium)) // Menambahkan padding horizontal
                    ) {
                        Image( // Menampilkan logo mobil
                            painter = painterResource(R.drawable.logomobil), // Mengambil gambar dari resource
                            contentDescription = stringResource(R.string.logo_description), // Deskripsi konten untuk aksesibilitas
                            modifier = Modifier.size(dimensionResource(id = R.dimen.image_size)) // Mengatur ukuran gambar
                        )
                        Text( // Menampilkan nama aplikasi
                            modifier = Modifier.padding(start = dimensionResource(id = R.dimen.padding_small)), // Menambahkan padding di sebelah kiri
                            text = stringResource(R.string.app_name), // Mengambil nama aplikasi dari resource
                            fontWeight = FontWeight.Bold, // Mengatur berat font menjadi tebal
                            style = MaterialTheme.typography.titleLarge.copy( // Mengatur gaya teks
                                fontSize = dimensionResource(id = R.dimen.title_text_size).value.sp // Mengatur ukuran font
                            )
                        )
                    }
                }
            )
        }
    ) { paddingValues -> // Mengambil nilai padding dari Scaffold
        LazyColumn(modifier = Modifier.padding(paddingValues).padding(dimensionResource(id = R.dimen.padding_medium))) { // Membuat LazyColumn untuk daftar mobil
            items(carViewModel.cars.size) { index -> // Menentukan jumlah item berdasarkan ukuran daftar mobil
                val car = carViewModel.cars[index] // Mengambil mobil berdasarkan indeks
                Card( // Membuat card untuk setiap item mobil
                    modifier = Modifier
                        .fillMaxWidth() // Mengatur card untuk mengisi lebar penuh
                        .padding(dimensionResource(id = R.dimen.padding_small)) // Menambahkan padding di sekitar card
                        .clickable { navController.navigate("car_details/${car.id}") }, // Mengatur aksi klik untuk navigasi ke detail mobil
                    colors = CardDefaults.cardColors( // Mengatur warna card
                        containerColor = Color.LightGray // Mengatur warna latar belakang card
                    )
                ) {
                    Column( // Menggunakan Column untuk menampilkan elemen vertikal
                        modifier = Modifier
                            .fillMaxWidth() // Mengatur Column untuk mengisi lebar penuh
                            .padding(dimensionResource(id = R.dimen.padding_medium)) // Menambahkan padding di sekitar Column
                    ) {
                        // Gambar
                        Image( // Menampilkan gambar mobil
                            painter = painterResource(id = car.image), // Mengambil gambar dari resource mobil
                            contentDescription = car.name, // Deskripsi konten untuk aksesibilitas
                            modifier = Modifier
                                .size(dimensionResource(id = R.dimen.list_image_size)) // Mengatur ukuran gambar
                                .padding(bottom = dimensionResource(id = R.dimen.padding_small)), // Menambahkan padding di bawah gambar
                            contentScale = ContentScale.Crop // Mengatur skala konten gambar
                        )

                        // Harga dan Nama
                        Column( // Menggunakan Column untuk menampilkan informasi harga dan nama mobil
                            modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_small)) // Menambahkan padding di sekitar Column
                        ) {
                            Text( // Menampilkan harga mobil
                                text = " ${car.price}", // Harga mobil
                                fontWeight = FontWeight.Bold, // Mengatur berat font menjadi tebal
                                style = MaterialTheme.typography.bodyLarge.copy( // Mengatur gaya teks
                                    fontSize = dimensionResource(id = R.dimen.text_size).value.sp // Mengatur ukuran font
                                ),
                                color = Color.Black // Mengatur warna teks menjadi hitam
                            )
                            Text( // Menampilkan nama mobil
                                text = car.name, // Nama mobil
                                style = MaterialTheme.typography.bodyMedium.copy( // Mengatur gaya teks
                                    fontSize = dimensionResource(id = R.dimen.text_size).value.sp // Mengatur ukuran font
                                ),
                                color = Color.Black // Mengatur warna teks menjadi hitam
                            )
                        }
                    }
                }
            }
        }
    }
}