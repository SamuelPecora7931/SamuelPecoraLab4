// Samuel Pecora n01437931 Section 1
package samuel.pecora.n01437931;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

// FIX 1: Inherit from SamuelBaseActivity to properly activate the options menu
public class PecoraActivity22 extends SamuelBaseActivity {

    private static final String TAG = "PecoraActivity22";

    // A static variable stays alive in memory, allowing us to cycle images continuously
    private static int imageCyclePointer = 0;
    private long extractedValue = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // FIX 2: Connect to your unique second layout XML file (NOT activity_main)
        setContentView(R.layout.activity_main);

        TextView dataDisplay = findViewById(R.id.samuelTitleTV);
        ImageView dynamicImg = findViewById(R.id.samuelSubmitBtn);

        // FIX 3 & 4: Use native intent call context securely without invalid static imports
        if (getIntent() != null && getIntent().hasExtra("PASSED_LONG_DATA")) {
            extractedValue = getIntent().getLongExtra("PASSED_LONG_DATA", -1);

            // FIX 5: Use native activity getString to pull "Number: " or "Nombre: "
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