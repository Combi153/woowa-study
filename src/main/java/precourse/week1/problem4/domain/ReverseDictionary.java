package precourse.week1.problem4.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ReverseDictionary {

    private static final int START_OF_UPPER_CASE = 65;
    private static final int END_OF_UPPER_CASE = 90;
    private static final int START_OF_LOWER_CASE = 97;
    private static final int END_OF_LOWER_CASE = 122;

    public String translate(Word word) {
        List<Integer> alphabets = word.getAlphabets();
        List<Character> translatedAlphabets = new ArrayList<>();
        for (int alphabet : alphabets) {
            if (alphabet >= START_OF_UPPER_CASE && alphabet <= END_OF_UPPER_CASE) {
                int translatedValue = START_OF_UPPER_CASE + END_OF_UPPER_CASE - alphabet;
                translatedAlphabets.add((char) translatedValue);
            } else if (alphabet >= START_OF_LOWER_CASE && alphabet <= END_OF_LOWER_CASE) {
                int translatedValue = START_OF_LOWER_CASE + END_OF_LOWER_CASE - alphabet;
                translatedAlphabets.add((char) translatedValue);
            } else {
                translatedAlphabets.add((char) alphabet);
            }
        }

        return translatedAlphabets.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());
    }
}
