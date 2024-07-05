package com.hfad.beeradviser

import android.os.Bundle
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val textViewBrands = findViewById<TextView>(R.id.brands)
        val spinnerBeerColor = findViewById<Spinner>(R.id.beer_color)
        val buttonFindBeer = findViewById<Button>(R.id.find_beer)

        buttonFindBeer.setOnClickListener {
            val selectedBeerColor = spinnerBeerColor.selectedItem.toString()
            val beerList = getBeers(selectedBeerColor)
            val beers = beerList.reduce{ str, item -> str + "\n" + item }
            textViewBrands.text = beers
        }
    }

    fun getBeers(color: String) : List<String> {
        return when (color) {
            "Light" -> listOf("Jail Pale Ale", "Lager Lite")
            "Amber" -> listOf("Jack Amber", "Red Moose")
            "Brown" -> listOf("Brown Bear Beer", "Bock Brownie")
            else -> listOf("Gout Stout", "Dark Daniel")
        }
    }
}