import java.util.*;

public class Hangman {
    public static void StartGame() {
        Scanner s = new Scanner(System.in);
        List<Map.Entry<String, String[]>> Words = new ArrayList<>();

        Words.add(Map.entry("Elephant", new String[]{"A large mammal with a trunk", "It has big ears", "It has a long trunk"}));
        Words.add(Map.entry("Giraffe", new String[]{"The tallest land animal with a long neck", "It has spots", "It has a long neck"}));
        Words.add(Map.entry("Python", new String[]{"A type of large snake and also a programming language", "It can be a reptile", "It can be a programming language"}));
        Words.add(Map.entry("Pyramid", new String[]{"Ancient monumental structure in Egypt", "It has a triangular shape", "It is a tomb"}));
        Words.add(Map.entry("Volcano", new String[]{"A mountain that erupts lava", "It spews lava", "It can erupt"}));
        Words.add(Map.entry("Guitar", new String[]{"A musical instrument", "It has strings", "You can strum it"}));
        Words.add(Map.entry("Diamond", new String[]{"A precious gemstone known for its hardness", "It is very hard", "It is shiny"}));
        Words.add(Map.entry("Rocket", new String[]{"A vehicle used to travel into space", "It is used by astronauts", "It travels to space"}));
        Words.add(Map.entry("Castle", new String[]{"A large fortified building from the medieval period", "It has walls", "It was used by knights"}));
        Words.add(Map.entry("Skeleton", new String[]{"The internal framework of bones in a body", "It is inside your body", "It is made of bones"}));


        Collections.shuffle(Words);


        System.out.println("\t\t\t\tWelcome to Hangman\n");
        for (Map.Entry<String, String[]> word : Words) {
            System.out.println("Your Clue - " + word.getValue()[0]);

            int CurrentWordLength = word.getKey().length();
            StringBuilder DisplayWord = new StringBuilder("_".repeat(CurrentWordLength));
            System.out.println(DisplayWord);

            int count = 0;

            for (int i = 0; i < CurrentWordLength; i++) {
                System.out.print("Guess a letter: ");
                String InputLetter = s.next();



                if (InputLetter.length() == 1 && InputLetter.equalsIgnoreCase(String.valueOf(word.getKey().charAt(i)))){
                    System.out.println("Correct, Find Next Word");

                    DisplayWord.setCharAt(i, InputLetter.charAt(0));
                } else {
                    System.out.println("Wrong, Try Again");
                    count++;

                    if (count == 2) {
                        System.out.println("Oh Boy, Seems like you're Bad at this, here's another clue -" + word.getValue()[1]);
                    } else if (count == 3) {
                        System.out.println("Again?? Okay, Last one - " + word.getValue()[2]);
                    } else if (count == 4) {
                        System.out.println("You know what? Fuck it!! This was the word -" + word.getKey());
                        StartGame();
                    }

                    i--;
                }

                System.out.println(DisplayWord);
            }
        }
    }

    public static void main(String[] args) {
        StartGame();
    }
}