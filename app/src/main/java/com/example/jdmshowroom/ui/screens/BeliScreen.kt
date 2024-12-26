package com.example.jdmshowroom.ui.screens

import androidx.compose.foundation.layout.* // Digunakan untuk pengaturan tata letak (layout) dalam Jetpack Compose.
import androidx.compose.material3.* // Komponen Material Design 3, seperti Button, TextField, dll.
import androidx.compose.runtime.* // State management dalam Compose.
import androidx.compose.ui.Alignment // Digunakan untuk alignment (penyelarasan) dalam layout.
import androidx.compose.ui.Modifier // Modifier untuk mengatur properti layout, seperti padding dan ukuran.
import androidx.compose.ui.res.dimensionResource // Digunakan untuk mengambil dimensi dari resource (values dimens).
import androidx.navigation.NavHostController // Controller untuk navigasi antar layar.
import com.example.jdmshowroom.R // Referensi untuk sumber daya aplikasi (seperti dimensi, string, dll).
import com.example.jdmshowroom.viewmodel.CarViewModel // ViewModel yang digunakan untuk menyediakan data mobil.

@OptIn(ExperimentalMaterial3Api::class) // Anotasi untuk mengizinkan penggunaan API eksperimental Material 3.
@Composable
fun BeliScreen(carId: String?, navController: NavHostController, carViewModel: CarViewModel = CarViewModel()) {
    // Mendapatkan data mobil berdasarkan ID yang dikirim melalui parameter.
    val car = carViewModel.cars[carId?.toInt() ?: 0]

    // State untuk input form (nama pemesan, alamat, dll).
    var namaPemesan by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var nomorTelepon by remember { mutableStateOf("") }
    var metodePembayaran by remember { mutableStateOf("") }

    // Mengambil harga mobil dari data mobil.
    val harga = car.price
    // Menghitung pajak mobil dengan fungsi `calculateTax`.
    val pajak = calculateTax(harga)

    // Scaffold menyediakan struktur layout dengan topBar, bottomBar, dll.
    Scaffold(
        topBar = {
            // TopAppBar untuk menampilkan judul layar.
            CenterAlignedTopAppBar(
                title = { Text("Pembelian Mobil") }
            )
        }
    ) { paddingValues ->
        // Column digunakan untuk menata elemen dalam kolom vertikal.
        Column(
            modifier = Modifier
                .padding(paddingValues) // Menambahkan padding dari Scaffold.
                .padding(dimensionResource(id = R.dimen.padding_medium)) // Padding tambahan dari dimensi resource.
                .fillMaxSize(), // Mengisi seluruh ukuran layar.
            horizontalAlignment = Alignment.CenterHorizontally // Elemen berada di tengah secara horizontal.
        ) {
            // Menampilkan nama mobil yang akan dibeli.
            Text(
                text = "Anda akan membeli ${car.name}",
                style = MaterialTheme.typography.titleLarge, // Gaya teks dari Material Design 3.
                modifier = Modifier.padding(bottom = dimensionResource(id = R.dimen.padding_medium))
            )

            // TextField untuk input nama pemesan.
            TextField(
                value = namaPemesan,
                onValueChange = { namaPemesan = it }, // Mengubah state nama pemesan.
                label = { Text("Nama Pemesan") },
                modifier = Modifier
                    .fillMaxWidth() // TextField memenuhi lebar layar.
                    .padding(bottom = dimensionResource(id = R.dimen.padding_small))
            )

            // TextField untuk input alamat.
            TextField(
                value = alamat,
                onValueChange = { alamat = it }, // Mengubah state alamat.
                label = { Text("Alamat") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = dimensionResource(id = R.dimen.padding_small))
            )

            // TextField untuk input nomor telepon.
            TextField(
                value = nomorTelepon,
                onValueChange = { nomorTelepon = it }, // Mengubah state nomor telepon.
                label = { Text("Nomor Telepon") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = dimensionResource(id = R.dimen.padding_small))
            )

            // TextField untuk input metode pembayaran.
            TextField(
                value = metodePembayaran,
                onValueChange = { metodePembayaran = it }, // Mengubah state metode pembayaran.
                label = { Text("Metode Pembayaran") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = dimensionResource(id = R.dimen.padding_small))
            )

            // Tombol untuk mengonfirmasi pembelian.
            Button(
                onClick = {
                    // Navigasi ke layar detail pemesanan dengan parameter data pembelian.
                    navController.navigate("detail_pemesanan/$namaPemesan/$alamat/$nomorTelepon/$metodePembayaran/$harga/$pajak")
                },
                modifier = Modifier.fillMaxWidth() // Tombol memenuhi lebar layar.
            ) {
                Text("Konfirmasi Pembelian") // Teks pada tombol.
            }
        }
    }
}

// Fungsi untuk menghitung pajak mobil (contohnya 2% dari harga).
fun calculateTax(price: String): String {
    // Menghapus format "Rp" dan titik agar harga dapat diubah menjadi angka.
    val priceValue = price.replace("Rp ", "").replace(".", "").toDoubleOrNull() ?: 0.0
    // Menghitung pajak 2%.
    val taxValue = priceValue * 0.02
    // Mengembalikan pajak dalam format "Rp".
    return "Rp ${taxValue.toInt()}"
}
