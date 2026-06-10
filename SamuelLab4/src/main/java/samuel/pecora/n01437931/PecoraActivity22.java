// Samuel Pecora n01437931 Section 1
package samuel.pecora.n01437931;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class PecoraActivity22 extends SamuelBaseActivity {

    private static final String TAG = "PecoraActivity22";
    private static int imageCyclePointer = 0;
    private long extractedValue = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView dataDisplay = findViewById(R.id.samuelDataDisplayTV);
        ImageView dynamicImg = findViewById(R.id.samuelDynamicIV);

        if (getIntent() != null && getIntent().hasExtra("PASSED_LONG_DATA")) {
            extractedValue = getIntent().getLongExtra("PASSED_LONG_DATA", -1);
            dataDisplay.setText("Number: " + extractedValue);
        } else {
            dataDisplay.setText("");
        }

        int[] displayImages = {
                android.R.drawable.ic_dialog_map,
                android.R.drawable.ic_dialog_info,
                android.R.drawable.ic_dialog_alert
        };

        dynamicImg.setImageResource(displayImages[imageCyclePointer]);
        imageCyclePointer = (imageCyclePointer + 1) % displayImages.length;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "Navigating Back. Last Displayed Value: " + (extractedValue != -1 ? extractedValue : "None"));
    }
}