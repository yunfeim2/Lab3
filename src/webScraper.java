import java.io.IOException;
import java.net.URL;
import java.util.Scanner;


public class webScraper {

    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }

    /**
     *
     */
    public static int numberOfOcurrence(final String word, final String stringContents) {
        String stringContents1 = urlToString(stringContents) ;
        int number = 0;
        while (stringContents1.indexOf(word) != -1) {
            stringContents1 = stringContents.substring(0,stringContents1.indexOf(word)) + stringContents1.substring(stringContents.indexOf(word) + word.length());
            number++;
        }
        return number;
    }

    public static void main(String[] arg) {
        System.out.println(numberOfOcurrence("good","http://erdani.com/tdpl/hamlet.txt"));
    }
}
