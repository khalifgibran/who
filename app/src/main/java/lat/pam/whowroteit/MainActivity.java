package lat.pam.whowroteit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    public EditText mBookInput;
    public TextView mAuthor;
    public TextView mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBookInput = (EditText) findViewById(R.id.bookInput);
        mAuthor = (TextView) findViewById(R.id.authorText);
        mTitle = (TextView) findViewById(R.id.titleText);

    }

    public void searchBooks(View view){
        String queryString = mBookInput.getText().toString();
    }
}