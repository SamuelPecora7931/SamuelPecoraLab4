// Samuel Pecora n01437931 Section 1
package samuel.pecora.n01437931;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

// Changing "extends AppCompatActivity" to "extends SamuelBaseActivity" activates the menu!
public class PecoraActivity22 extends SamuelBaseActivity {

    private static final String TAG = "PecoraActivity22";

    // A static variable stays alive in memory, allowing us to cycle images continuously
    private static int imageCyclePointer = 0;
    private long extractedValue = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Connects this Java file to your second layout XML file
        setContentView(R.layout.activity_second);

        TextView dataDisplay = findViewById(R.id.samuelDataDisplayTV);
        ImageView dynamicImg = findViewById(R.id.samuelDynamicIV);

        // Safely extract the bundle data sent from SamuelActivity11
        if (getIntent().hasExtra("PASSED_LONG_DATA")) {
            extractedValue = getIntent().getLongExtra("PASSED_LONG_DATA", -1);

            // Grabs "Number: " or "Nombre: " dynamically based on system language settings
            String localizedPrefix = getString(R.string.number_prefix);
            dataDisplay.setText(localizedPrefix + extractedValue);
        } else {
            dataDisplay.setText("");
        }

        // An array of built-in system icons to use as your changing images
        int[] displayImages = {
                android.R.drawable.ic_dialog_map,
                android.R.drawable.ic_dialog_info,
                android.R.drawable.ic_dialog_alert
        };

        // Set the image based on our current pointer position
        dynamicImg.setImageResource(displayImages[imageCyclePointer]);

        // Move the pointer forward for the next time this screen opens (0 -> 1 -> 2 -> 0...)
        imageCyclePointer = (imageCyclePointer + 1) % displayImages.length;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Mandatory Lab Requirement: Log the value via Log.d when navigating backward
        Log.d(TAG, "Navigating Back. Last Displayed Value: " + (extractedValue != -1 ? extractedValue : "None"));
    }
}