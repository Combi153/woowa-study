package precourse.week1.problem4.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Word {

    private static final int START_OF_RANGE = 1;
    private static final int END_OF_RANGE = 1000;
    private final String word;

    public Word(String word) {
        validateLength(word);
        this.word = word;
    }

    private void validateLength(String word) {
        if (isOutOfRange(word.length())) {
            throw new IllegalArgumentException("[ERROR] 문자열의 길이는 1이상 1,000 이하여야 합니다.");
        }
    }

    private List<Character> makeAlphabets(String word) {
        return word.chars()
                .mapToObj(alphabet -> (char) alphabet)
                .collect(Collectors.toList());
    }

    private boolean isOutOfRange(int length) {
        return length < START_OF_RANGE || length > END_OF_RANGE;
    }

    public Word changeBy(Translator translator, Range range) {
        List<Character> alphabets = makeAlphabets(this.word);
        for (int i = 0; i < alphabets.size(); i++) {
            int alphabet = alphabets.get(i);
            if (range.contains(alphabet)) {
                alphabets.set(i, (char) translator.translate(alphabet));
            }
        }
        return createWord(alphabets);
    }

    private Word createWord(List<Character> alphabets) {
        return new Word(makeWord(alphabets));
    }

    private String makeWord(List<Character> alphabets) {
        return alphabets.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());
    }

    public String getWord() {
        return word;
    }
}
