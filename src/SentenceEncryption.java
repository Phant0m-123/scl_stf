import java.util.*;

public class SentenceEncryption {

    private String[] words;

    void getWords(String Sentence) {
        int count = 0;
        for (int i = 0; i <= Sentence.length(); i++) {
            count += (Sentence.charAt(i) == ' ') ? 1 : 0;
        }
        words = new String[count+1];
        int lastIndexOfSpace = 0;
        for (int i = 0; i <= Sentence.length(); i++) {
            
        }
    }

}
