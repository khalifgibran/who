package lat.pam.whowroteit;

import android.os.AsyncTask;
import android.widget.TextView;

public class FetchBook extends AsyncTask<String,Void,String> {
    private TextView mTitle;
    private TextView mAuthor;

    public FetchBook(TextView mTitleText, TextView mAuthorText) {
        this.mTitle = mTitle;
        this.mAuthor = mAuthor;
    }

    @Override
    protected String doInBackground(String... params) {
        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
    }
}