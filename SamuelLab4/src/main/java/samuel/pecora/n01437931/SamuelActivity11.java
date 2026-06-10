// Samuel Pecora n01437931 Section 1
package samuel.pecora.n01437931;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import com.google.android.material.snackbar.Snackbar;

// FIX 1: Explicitly import your own project resources instead of android.R
import samuel.pecora.n01437931.R;

// FIX 2: Change inheritance from PecoraActivity22 to SamuelBaseActivity to enable the menu properly
public class SamuelActivity11 extends SamuelBaseActivity {

    private static final String TAG = "SamuelActivity11";
    private EditText inputField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Links this Java controller directly to your activity_main.xml layouts
        setContentView(R.layout.activity_main);

        // Binding your input field and image play button via custom IDs
        inputField = findViewById(R.id.samuelInputET);
        ImageButton actionBtn = findViewById(R.id.samuelSubmitBtn);

        // Click listener logic for the ImageButton
        actionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String rawInput = inputField.getText().toString().trim();

                // 1. Create a persistent, Indefinite Snackbar across the screen
                Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content),
                        "Samuel Pecora", Snackbar.LENGTH_INDEFINITE);

                // 2. Add the clickable "START" button onto the Snackbar strip
                snackbar.setAction("START", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Create explicit intent transitioning to your target second screen
                        Intent intent = new Intent(SamuelActivity11.this, PecoraActivity22.class);

                        // Parse input string to a long value bundle extra if it isn't empty
                        if (!rawInput.isEmpty()) {
                            try {
                                long convertedData = Long.parseLong(rawInput);
                                intent.putExtra("PASSED_LONG_DATA", convertedData);
                            } catch (NumberFormatException e) {
                                Log.e(TAG, "Input parsing numeric conversion failed");
                            }
                        }

                        inputField.setText(""); // Reset the input field text box safely
                        startActivity(intent);  // Launch the second screen activity
                    }
                });

                // Present the snackbar to the user view
                snackbar.show();
            }
        });
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        // Mandatory Lab Requirement 40.j: Log foreground status updates explicitly in Logcat
        Log.d(TAG, "Foreground Update: Samuel Pecora n01437931");
    }
}