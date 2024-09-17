import java.util.*;

public class WordSizeSort {
    Stack<String> wrds = new Stack<>();
    String[] words;
    String sentence = "";
    boolean input_validity = false;

    private void getSentence() {
        while (true) {
            System.out.println("Enter your sentence");
            String s = (new Scanner(System.in)).nextLine();
            for (int i = 0; i < s.length(); i++) {
                sentence += Character.toUpperCase(s.charAt(i));
                input_validity = s.charAt(i) == '.';
                if (s.charAt(i) == '.') {
                    break;
                }
            }
            break;
        }
        if (!input_validity) {
            System.out.println("Invalid Input!");
        }
    }

    private void getWords() {
        this.getSentence();
        if (input_validity) {
            int startIndex = 0;
            for (int i = 0; i < sentence.length(); i++) {
                if (sentence.charAt(i) == ' ') {
                    wrds.push(sentence.substring(startIndex, i));
                    i++;
                    startIndex = i;
                } else if (sentence.charAt(i) == '.') {
                    wrds.push(sentence.substring(startIndex, i));
                    i++;
                    startIndex = i;
                }
            }
            words = new String[wrds.size()];
            for (int i = 0; i < words.length; i++) {
                words[words.length - 1 - i] = wrds.pop();
            }
        }
    }

    private void sortWords() {
        this.getWords();
        if (input_validity) {
            for (int i = 0; i < words.length; i++) {
                for (int j = 0; j < words.length - 1 - i; j++) {
                    if (words[j].length() > words[j + 1].length()) {
                        String tmp = words[j];
                        words[j] = words[j + 1];
                        words[j + 1] = tmp;
                    }
                }
            }
            String snt = "";
            for (int i = 0; i < words.length; i++) {
                snt += (words[i] + ((i == words.length - 1) ? "." : " "));
            }
            System.out.println(snt);
        }
    }

    public static void main(String[] args) {
        WordSizeSort ob = new WordSizeSort();
        ob.sortWords();
    }
}
