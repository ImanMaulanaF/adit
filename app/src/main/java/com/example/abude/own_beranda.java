import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import java.util.Arrays;
import java.util.List;

public class own_beranda extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.own_beranda);

        // Declaring and initializing the Spinner from the layout file
        Spinner mSpinner = findViewById(R.id.);

        // Create a list to display in the Spinner
        List<String> mList = Arrays.asList("Delhi", "Mumbai", "Chennai", "Kolkata", "Bengaluru");

        // Create an adapter as shown below
        ArrayAdapter<String> mArrayAdapter = new ArrayAdapter<String>(this, R.layout.spinner_list, mList);
        mArrayAdapter.setDropDownViewResource(R.layout.spinner_list);

        // Set the adapter to the Spinner
        mSpinner.adapter = mArrayAdapter;
    }
}

