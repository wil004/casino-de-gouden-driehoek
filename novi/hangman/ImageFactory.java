package novi.hangman;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ImageFactory {
    public static String getImage(int index) {
        List<String> image = new ArrayList<>();
        image.add("___");
        image.add("  |");
        image.add(" \\");
        image.add("0");
        image.add("/");
        image.add("  |");
        image.add(" /");
        image.add(" \\");
        return image.get(index);
    }

    public static String createWord() {
        Random random = new Random();
        List<String> randomWords = new ArrayList<>();
        randomWords.add("hallo");
        randomWords.add("televisie");
        randomWords.add("kebab");
        randomWords.add("computer");
        randomWords.add("programmeren");
        randomWords.add("novi");
        randomWords.add("encyclopedie");
        return randomWords.get(random.nextInt(randomWords.size()));
    }


}
