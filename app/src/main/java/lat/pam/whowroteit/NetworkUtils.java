package lat.pam.whowroteit;

import android.net.Uri;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class NetworkUtils {
    private static final String LOG_TAG = NetworkUtils.class.getSimpleName();

    static String getBookInfo(String queryString) {
        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;

        final String BOOK_BASE_URL =  "https://www.googleapis.com/books/v1/volumes?"; // Base URI for the Books API
        final String QUERY_PARAM = "q"; // Parameter for the search string
        final String MAX_RESULTS = "maxResults"; // Parameter that limits search results
        final String PRINT_TYPE = "printType";   // Parameter to filter by print type
        String bookJSONString = null;

        try {
            //Build up your query URI, limiting results to 10 items and printed books
            Uri builtURI = Uri.parse(BOOK_BASE_URL).buildUpon()
                    .appendQueryParameter(QUERY_PARAM, queryString)
                    .appendQueryParameter(MAX_RESULTS, "10")
                    .appendQueryParameter(PRINT_TYPE, "books")
                    .build();
            URL requestURL = new URL(builtURI.toString());
            
            urlConnection = (HttpURLConnection) requestURL.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            InputStream inputStream = urlConnection.getInputStream();
            StringBuffer buffer = new StringBuffer();
            if (inputStream == null) {
                // Nothing to do.
                return null;
            }
            reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = reader.readLine()) != null) {
            /* Since it's JSON, adding a newline isn't necessary (it won't affect
              parsing) but it does make debugging a *lot* easier if you print out the
              completed buffer for debugging. */
                buffer.append(line + "\n");
            }
            if (buffer.length() == 0) {
                // Stream was empty.  No point in parsing.
                return null;
            }
            bookJSONString = buffer.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            return bookJSONString;
        }
    }


}
