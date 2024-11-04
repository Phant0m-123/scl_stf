import java.util.Locale;
import java.util.Scanner;

public class Question6 {
    String sentence;
    String[] words;
    Question6(String inp){
        sentence = inp;
        int wordCount = 0;
        for(int i = 0; i<sentence.length();i++){
            if(sentence.charAt(i)==' '|| sentence.charAt(i)=='.'){
                wordCount++;
            }
        }
        words = new String[wordCount];
        this.getWords();
    }

    void getWords(){
        int prev = 0, counter = 0;
        for(int i = 0; i<sentence.length();i++){
            if(sentence.charAt(i)==' '|| sentence.charAt(i)=='.'){
                words[counter++] = sentence.substring(prev,i);
                prev = i+1;
            }
        }
    }

    void sort(){
        for(int i = 0; i < words.length - 1; i++){
            for (int j = 0; j < words.length - 1 - i; j++){
                if (words[j].length()> words[j+1].length()){
                    String temp = words[j];
                    words[j] = words[j+1];
                    words[j+1] = temp;
                }
            }
        }
    }

    void display(){
        String output = (Character.toUpperCase(words[0].charAt(0)))+(words[0].substring(1)).toLowerCase() + " ";
        for (int i = 1; i < words.length; i++){
            output += words[i].toLowerCase();
            output += (i== words.length-1)? ".": " ";
        }
        System.out.println(output);
    }

    public static void main(String[] args) {
        System.out.println("Enter your string");
        Question6 obj = new Question6((new Scanner(System.in)).nextLine());
        System.out.println("Original sentence:");
        obj.display();
        obj.sort();
        System.out.println("Sorted sentence:");
        obj.display();
    }

}
