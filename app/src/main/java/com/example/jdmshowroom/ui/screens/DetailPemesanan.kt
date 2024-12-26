package com.example.jdmshowroom.ui.screens // Mendefinisikan paket tempat file ini berada

import androidx.compose.foundation.BorderStroke // Mengimpor BorderStroke untuk memberi batas pada elemen
import androidx.compose.foundation.layout.* // Mengimpor layout dasar seperti Column, Spacer, dll.
import androidx.compose.foundation.shape.RoundedCornerShape // Mengimpor bentuk sudut bulat
import androidx.compose.material3.* // Mengimpor komponen Material 3
import androidx.compose.runtime.Composable // Mengimpor anotasi Composable
import androidx.compose.ui.Modifier // Mengimpor kelas untuk memodifikasi elemen
import androidx.compose.ui.graphics.Color // Mengimpor kelas Color untuk pengaturan warna
import androidx.compose.ui.res.dimensionResource // Mengimpor fungsi untuk mendapatkan dimensi dari resources
import androidx.compose.ui.text.font.FontWeight // Mengimpor kelas FontWeight untuk pengaturan berat font
import androidx.compose.ui.unit.dp // Mengimpor satuan ukuran dp
import androidx.compose.ui.unit.sp // Mengimpor satuan ukuran sp untuk teks
import androidx.navigation.NavHostController // Mengimpor kelas untuk mengontrol navigasi
import com.example.jdmshowroom.R // Mengimpor resource dari paket R
import com.example.jdmshowroom.ui.theme.LightGray // Mengimpor warna LightGray dari tema

@OptIn(ExperimentalMaterial3Api::class) // Menandai penggunaan API eksperimental
@Composable // Menandai fungsi ini sebagai Composable
fun DetailPemesananScreen(
    navController: NavHostController, // Mengontrol navigasi
    namaPemesan: String, // Nama pemesan
    alamat: String, // Alamat pemesan
    nomorTelepon: String, // Nomor telepon pemesan
    metodePembayaran: String, // Metode pembayaran
    harga: String, // Harga mobil
    pajak: String // Pajak yang dikenakan
) {
    Scaffold( // Fungsi Scaffold untuk menyediakan struktur dasar aplikasi
        topBar = {
            CenterAlignedTopAppBar( // Membuat AppBar yang terpusat
                title = { Text("Detail Pemesanan") } // Judul AppBar
            )
        }
    ) { paddingValues -> // Mengambil nilai padding dari Scaffold
        Column(
            modifier = Modifier
                .padding(paddingValues) // Menambahkan padding dari Scaffold
                .padding(dimensionResource(id = R.dimen.padding_medium)) // Menambahkan padding tambahan
        ) {
            Text(
                text = "Rincian Pemesanan", // Judul bagian rincian pemesanan
                style = MaterialTheme.typography.titleLarge, // Mengatur gaya teks
                modifier = Modifier.padding(bottom = dimensionResource(id = R.dimen.padding_medium)) // Menambahkan padding di bawah teks
            )

            Card(
                modifier = Modifier.fillMaxWidth(), // Mengatur card untuk mengisi lebar penuh
                shape = RoundedCornerShape(8.dp), // Mengatur bentuk card dengan sudut bulat
                border = BorderStroke(1.dp, Color.Gray), // Menambahkan batas pada card
                colors = CardDefaults.cardColors(containerColor = LightGray) // Mengatur warna latar belakang card
            ) {
                Column(
                    modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_medium)) // Menambahkan padding di sekitar konten card
                ) {
                    Text(text = "Nama Pemesan: $namaPemesan", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color.Black) // Menampilkan nama pemesan
                    Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_small))) // Menambahkan spasi

                    Text(text = "Alamat: $alamat", fontWeight = FontWeight.Bold, color = Color.Black, fontSize = 16.sp) // Menampilkan alamat
                    Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_small))) // Menambahkan spasi

                    Text(text = "Nomor Telepon: $nomorTelepon", fontWeight = FontWeight.Bold, color = Color.Black, fontSize = 16.sp) // Menampilkan nomor telepon
                    Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_small))) // Menambahkan spasi

                    Text(text = "Metode Pembayaran: $metodePembayaran", fontWeight = FontWeight.Bold, color = Color.Black, fontSize = 16.sp) // Menampilkan metode pembayaran
                    Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_small))) // Menambahkan spasi

                    Text(text = "Harga: $harga", fontSize = 16.sp, color = Color.Black, fontWeight = FontWeight.Bold) // Menampilkan harga
                    Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_small))) // Menambahkan spasi

                    Text(text = "Pajak: $pajak", fontWeight = FontWeight.Bold, color = Color.Black, fontSize = 16.sp) // Menampilkan pajak
                    Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_small))) // Menambahkan spasi
                }
            }

            Spacer(modifier = Modifier.weight(1f)) // Menambahkan spasi fleksibel untuk mengisi ruang

            Button(
                onClick = { navController.navigate("car_list") }, // Aksi ketika tombol diklik
                modifier = Modifier
                    .fillMaxWidth() // Mengatur tombol untuk mengisi lebar penuh
                    .padding(top = dimensionResource(id = R.dimen.padding_medium)) // Menambahkan padding di atas tombol
            ) {
                Text(text = "Kembali ke Home", fontSize = 16.sp) // Teks pada tombol
            }
        }
    }
}