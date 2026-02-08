import java.util.*;
import java.io.*;

public class hangman {

    static String HangmanArt(int wrongG) {
        return switch (wrongG) {
            case 0 -> """
                    
                    
                    
                    """;
            case 1 -> """
                      O
                      
                      
                    """;
            case 2 -> """
                      O
                      |
                      
                    """;
            case 3 -> """
                      O
                     /|
                      
                    """;
            case 4 -> """
                      O
                     /|\\
                      
                    """;
            case 5 -> """
                      O
                     /|\\
                     / \\
                    """;
            default -> "";
        };
    }

    public static void main(String[] args) {

        // Load words from file
        String filePath = "words.txt";
        ArrayList<String> fileWords = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.trim().isEmpty())
                    fileWords.add(line.trim().toLowerCase());
            }
        } catch (Exception e) {
            System.out.println("Couldn't read file, using default word.");
        }

        Random random = new Random();
        String word;

        if (fileWords.isEmpty()) {
            word = "pizza";
        } else {
            word = fileWords.get(random.nextInt(fileWords.size()));
        }

        Scanner sc = new Scanner(System.in);
        ArrayList<Character> guessed = new ArrayList<>();
        int wrongG = 0;

        for (int i = 0; i < word.length(); i++) {
            guessed.add('_');
        }

        System.out.println("------------------------");
        System.out.println("JAVA HANGMAN");
        System.out.println("------------------------");

        while (wrongG < 6) {

            System.out.println(HangmanArt(wrongG));
            System.out.print("Word: ");
            for (char c : guessed) {
                System.out.print(c + " ");
            }
            System.out.println();

            System.out.print("Guess a letter: ");
            char guess = sc.next().toLowerCase().charAt(0);

            if (word.indexOf(guess) >= 0) {
                System.out.println("Correct Guess!");
                for (int i = 0; i < word.length(); i++) {
                    if (word.charAt(i) == guess) {
                        guessed.set(i, guess);
                    }
                }

                if (!guessed.contains('_')) {
                    System.out.println("\n🎉 You Won!");
                    System.out.println("The word was: " + word);
                    break;
                }

            } else {
                wrongG++;
                System.out.println("Wrong Guess!");
            }
        }

        if (wrongG >= 6) {
            System.out.println(HangmanArt(wrongG));
            System.out.println("\nGame Over ☠");
            System.out.println("The word was: " + word);
        }

        sc.close();
    }
}
