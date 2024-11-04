import java.util.Scanner;

public class Question2 {
    String inp;
    String[] sentences = new String[10];

    Question2(String s) {
        inp = s;
        for (int i = 0; i < 10; i++) {
            sentences[i] = "null";
        }
        this.getSentences();
    }

    void getSentences() {
        int c = 0;
        int counter = 0;
        for (int i = 0; i < inp.length(); i++) {
            char ch = inp.charAt(i);
            if (ch == '.' || ch == '!' || ch == '?') {
                sentences[counter++] = inp.substring(c+1, i);
                c = i + 1;
            }
        }
    }

    int getWordCount(String s) {
        int counter = 1;
        for (int i = 0; i < s.length(); i++) {
            if (!s.equals("null") && s.charAt(i) == ' ') {
                counter++;
            }
        }
        return (!s.equals("null")) ? counter : -1;
    }

    int getVovelCount(String s){
        int vowelCount = 0;
        for (int j = 0; j < s.length(); j++) {
            char ch = s.charAt(j);
            if (ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U' ||
                    ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                vowelCount++;

            }
        }
        return (!s.equals("null")) ? vowelCount : -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Scanner object
        System.out.println("Enter upto 10 sentences");
        Question2 obj = new Question2((new Scanner(System.in)).nextLine());

        System.out.println("Sentence\tNo. of Vowels\tNo. of words\n" +
                "----------------------------------------------------------");

        for(int i = 0; i< obj.sentences.length && !obj.sentences[i].equals("null");i++){
            System.out.println((i+1)+"\t\t"+obj.getVovelCount(obj.sentences[i])+"\t\t"+ obj.getWordCount(obj.sentences[i]));
        }
    }
}