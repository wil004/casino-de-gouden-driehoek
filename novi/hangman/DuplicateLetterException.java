package novi.hangman;

import java.util.ArrayList;
import java.util.List;

public class DuplicateLetterException {
    private List<String> wrongLetters;
    private boolean letterAlreadyGuessed;

    public DuplicateLetterException() {
        wrongLetters = new ArrayList<>();
    }

    public void setWrongLetters(char letter) {
        String letters = String.valueOf(letter);
        if (!wrongLetters.contains(letters)) {
            System.out.println("Wrong guessed letter: " + letters);
            wrongLetters.add(letters);
            this.letterAlreadyGuessed = false;
        } else {
            this.letterAlreadyGuessed = true;
        }
        String wrongLettersString = "";
            for (int i = 0; i < wrongLetters.size(); i++) {
                wrongLettersString = wrongLetters.get(i) + "," + wrongLettersString;
        }
        System.out.println(wrongLettersString);
    }

    public boolean getLetterAlreadyGuessed() {
        return letterAlreadyGuessed;
    }

    public List<String> getWrongLetters() {
        return wrongLetters;
    }
}
