/**
 * IMPORTANT: Make sure you are using the correct package name.
 * This example uses the package name:
 * package com.example.android.justjava
 * If you get an error when copying this code into Android studio, update it to match teh package name found
 * in the project's AndroidManifest.xml file.
 **/

package com.example.coffee;


import android.annotation.SuppressLint;
import android.app.MediaRouteButton;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    private final int priseOfCoffees = 5;
    public int numberOfCoffees = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        display(numberOfCoffees);
        displayPrice(numberOfCoffees * priseOfCoffees);
        displayThankYouMessage();
    }

    private void displayThankYouMessage() {
        TextView thankYouTextView = findViewById(R.id.thank_you_text_view);
        thankYouTextView.setVisibility(View.VISIBLE);
    }

    public void increment(View view) {
        numberOfCoffees++;
        display(numberOfCoffees);
        displayPrice(numberOfCoffees * priseOfCoffees);
    }

    public void decrement(View view) {
        if (numberOfCoffees < 1)
            return;
        numberOfCoffees--;
        display(numberOfCoffees);
        displayPrice(numberOfCoffees * priseOfCoffees);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    @SuppressLint("SetTextI18n")
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given price on the screen.
     */
    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }

}