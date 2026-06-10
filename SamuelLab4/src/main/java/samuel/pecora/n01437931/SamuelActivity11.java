// Samuel Pecora n01437931 Section 1
package samuel.pecora.n01437931;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import com.google.android.material.snackbar.Snackbar;

// Inheriting from SamuelBaseActivity automatically attaches your options menu!
public class SamuelActivity11 extends SamuelBaseActivity {

    private static final String TAG = "SamuelActivity11";
    private EditText inputField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // This connects the Java code to your activity_main.xml layout files
        setContentView(R.layout.activity_main);

        // Connect the Java variables to the XML views using your 'samuel' IDs
        inputField = findViewById(R.id.samuelInputET);
        ImageButton actionBtn = findViewById(R.id.samuelSubmitBtn);

        actionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String rawInput = inputField.getText().toString().trim();

                // 1. Create an Indefinite Snackbar (stays on screen until a button is clicked)
                Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content),
                        "Samuel Pecora", Snackbar.LENGTH_INDEFINITE);

                // 2. Add the clickable "START" action button to that Snackbar
                snackbar.setAction("START", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Create an explicit Intent to move from this activity to PecoraActivity22
                        Intent intent = new Intent(SamuelActivity11.this, PecoraActivity22.class);

                        // If the user typed numbers, convert them to a Long and pack it into the intent bundle
                        if (!rawInput.isEmpty()) {
                            try {
                                long convertedData = Long.parseLong(rawInput);
                                intent.putExtra("PASSED_LONG_DATA", convertedData);
                            } catch (NumberFormatException e) {
                                Log.e(TAG, "Input numeric conversion parsing failed");
                            }
                        }

                        inputField.setText(""); // Wipe input box clean
                        startActivity(intent);  // Launch the second screen
                    }
                });

                // Show the snackbar on the screen
                snackbar.show();
            }
        });

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        // Lab Requirement 40.j: Log foreground status changes explicitly in Logcat
        Log.d(TAG, "Foreground Update: Samuel Pecora n01437931");
    }
}