package com.example.jdmshowroom.ui.screens

import androidx.compose.foundation.Image // Used to display images.
import androidx.compose.foundation.background // Provides background color.
import androidx.compose.foundation.layout.* // Used for layout management.
import androidx.compose.foundation.shape.RoundedCornerShape // Provides rounded corners for shapes.
import androidx.compose.material3.* // Material Design 3 components like Scaffold, Button, etc.
import androidx.compose.runtime.Composable // Indicates this function is composable for Jetpack Compose.
import androidx.compose.ui.Alignment // Used for alignment in layouts.
import androidx.compose.ui.Modifier // Modifier for setting layout properties.
import androidx.compose.ui.graphics.Color // Used for color management.
import androidx.compose.ui.layout.ContentScale // Determines how content is scaled within images.
import androidx.compose.ui.res.dimensionResource // Retrieves dimensions from resource files.
import androidx.compose.ui.res.painterResource // Retrieves images from drawable resources.
import androidx.compose.ui.res.stringResource // Retrieves strings from resource files.
import androidx.compose.ui.text.font.FontWeight // Specifies font weight.
import androidx.compose.ui.unit.dp // Dimension unit in Compose.
import androidx.compose.ui.unit.sp // Font size unit in Compose.
import androidx.compose.ui.platform.LocalDensity // Retrieves density for size conversion.
import androidx.navigation.NavHostController // Used for navigation between screens.
import com.example.jdmshowroom.R // Reference to application resources.
import com.example.jdmshowroom.ui.theme.Black // Application theme color for black.
import com.example.jdmshowroom.ui.theme.LightGrayRow // Background color for rows.
import com.example.jdmshowroom.ui.theme.Pumpkin // Application theme color for orange.
import com.example.jdmshowroom.viewmodel.CarViewModel // ViewModel to provide car data.

@OptIn(ExperimentalMaterial3Api::class) // Annotation to use experimental Material 3 API.
@Composable
fun CarDetailsScreen(navController: NavHostController, carId: String?, carViewModel: CarViewModel = CarViewModel()) {
    // Retrieve car data based on the provided car ID.
    val car = carViewModel.cars[carId?.toInt() ?: 0]

    // Scaffold provides a basic layout structure with topBar, bottomBar, etc.
    Scaffold(
        topBar = {
            // TopAppBar to display logo and app name.
            CenterAlignedTopAppBar(
                title = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(horizontal = dimensionResource(id = R.dimen.padding_medium))
                    ) {
                        // Display the car logo.
                        Image(
                            painter = painterResource(id = R.drawable.logomobil),
                            contentDescription = stringResource(R.string.logo_description),
                            modifier = Modifier.size(dimensionResource(id = R.dimen.image_size))
                        )
                        // Display the application name.
                        Text(
                            modifier = Modifier.padding(start = dimensionResource(id = R.dimen.padding_small)),
                            text = stringResource(R.string.app_name),
                            style = MaterialTheme.typography.titleLarge.copy(
                                fontSize = dimensionResource(id = R.dimen.title_text_size).value.sp
                            )
                        )
                    }
                }
            )
        }
    ) { paddingValues ->
        // Main column to display car details.
        Column(modifier = Modifier.padding(paddingValues).padding(dimensionResource(id = R.dimen.padding_medium))) {
            // Determine background color based on car ID.
            val backgroundColor = if (carId?.toInt()?.rem(2) == 0) LightGrayRow else LightGrayRow

            // Column for car detail content.
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = backgroundColor, shape = RoundedCornerShape(8.dp))
                    .padding(dimensionResource(id = R.dimen.padding_medium))
            ) {
                // Display the car image.
                Image(
                    painter = painterResource(id = car.image),
                    contentDescription = car.name,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(dimensionResource(id = R.dimen.image_size_detail)),
                    contentScale = ContentScale.Crop // Crop the image to fill the space.
                )
                Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_medium)))

                // Display the car name.
                Text(
                    text = car.name,
                    style = MaterialTheme.typography.bodyLarge.copy(
                        fontSize = dimensionResource(id = R.dimen.car_detail_text_size).value.sp
                    ),
                    fontWeight = FontWeight.Bold, // Make the font bold.
                    color = Color.Black // Set text color to black.
                )
                Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_medium)))

                // Display additional information using CarInformation function.
                CarInformation(
                    price = "Harga : ${car.price}", // Display the price.
                    features = car.features, // Pass car features for display.
                    modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_small)) // Set padding.
                )

                Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_medium)))

                // Navigation buttons for 'Kembali' and 'Beli'.
                Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
                    Button(onClick = { navController.navigateUp() }) { // Navigate back to the previous screen.
                        Text("Kembali") // Button text for 'Back'.
                    }
                    Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen.padding_small))) // Space between buttons.
                    Button(onClick = { navController.navigate("beli/${carId}") }) { // Navigate to buy screen with car ID.
                        Text("Beli") // Button text for 'Buy'.
                    }
                }
            }
        }
    }
}

@Composable
fun CarInformation(
    price: String, // Price of the car.
    features: List<String>, // List of car features.
    modifier: Modifier = Modifier // Modifier for additional styling.
) {
    Column(modifier = modifier) {
        // Display the car price.
        Text(
            text = price,
            color = Pumpkin, // Set text color to pumpkin.
            fontWeight = FontWeight.Bold, // Make the font bold.
            style = MaterialTheme.typography.bodyMedium.copy(
                fontSize = with(LocalDensity.current) { dimensionResource(R.dimen.small_text).toSp() } // Convert dimension to sp.
            ),
            modifier = Modifier.padding(top = dimensionResource(R.dimen.padding_extra_small)) // Set top padding.
        )

        Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_small))) // Space below the price.

        // Display each feature of the car.
        features.forEach { feature ->
            Text(
                text = feature, // Display feature name.
                color = Black, // Set text color to black.
                fontWeight = FontWeight.Bold, // Make the font bold.
                style = MaterialTheme.typography.bodySmall.copy(
                    fontSize = with(LocalDensity.current) { dimensionResource(R.dimen.extra_small_text).toSp() } // Convert dimension to sp.
                ),
                modifier = Modifier.padding(vertical = dimensionResource(R.dimen.padding_extra_small)) // Set vertical padding.
            )
        }
    }
}