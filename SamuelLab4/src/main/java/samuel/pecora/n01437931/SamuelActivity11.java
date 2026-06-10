// Samuel Pecora n01437931 Section 1
package samuel.pecora.n01437931;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import com.google.android.material.snackbar.Snackbar;

public class SamuelActivity11 extends SamuelBaseActivity {

    private static final String TAG = "SamuelActivity11";
    private EditText inputField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputField = findViewById(R.id.samuelInputET);
        ImageButton actionBtn = findViewById(R.id.samuelSubmitBtn);

        actionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String rawInput = inputField.getText().toString().trim();

                Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content),
                        "Samuel Pecora", Snackbar.LENGTH_INDEFINITE);

                snackbar.setAction("START", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(SamuelActivity11.this, PecoraActivity22.class);

                        if (!rawInput.isEmpty()) {
                            try {
                                long convertedData = Long.parseLong(rawInput);
                                intent.putExtra("PASSED_LONG_DATA", convertedData);
                            } catch (NumberFormatException e) {
                                Log.e(TAG, "Input parsing failure");
                            }
                        }

                        inputField.setText("");
                        startActivity(intent);
                    }
                });

                snackbar.show();
            }
        });
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "Foreground Update: Samuel Pecora n01437931");
    }
}