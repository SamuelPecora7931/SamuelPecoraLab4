// Samuel Pecora n01437931 Section 1
package samuel.pecora.n01437931;

import android.content.Intent;
import android.net.Uri;
import android.view.Menu;
import android.view.MenuItem;
import androidx.appcompat.app.AppCompatActivity;

public class SamuelBaseActivity extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.samuelMenuDial) {
            Intent dialIntent = new Intent(Intent.ACTION_DIAL);
            dialIntent.setData(Uri.parse("tel:4166753111"));
            startActivity(dialIntent);
            return true;
        } else if (id == R.id.samuelMenuExit) {
            finishAffinity();
            System.exit(0);
            return true;
        } else if (id == R.id.samuelMenuHelp) {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://humber.ca"));
            startActivity(browserIntent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}