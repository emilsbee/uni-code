public class Strings {
    public static void main(String[] args) {
        final String[] words= {"the","quick","brown","fox","jumped","over","the","lazy","dog"};
        final String alphabet = "abcdefghijklmnopqrstuvwxyz";
        
        // Iterate over alphabet
        for (int i = 0; i < alphabet.length(); i++) {
            char currentLetter = alphabet.charAt(i);
            int count = 0;
            
            System.out.printf("Letter: %c%n", currentLetter);

            // Iterate over words
            for (int k = 0; k < words.length; k++) {
                String currentWord = words[k];
                
                // Iterate over letters in the word
                for (int j = 0; j < currentWord.length(); j++) {
                    if (currentWord.charAt(j) == currentLetter) {
                        System.out.println(currentWord);
                        count = count + 1;
                    }
                }
            }
            System.out.printf("Count: %d%n", count);
        }  
    }
}


