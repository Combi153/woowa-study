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

    private boolean isOutOfRange(int length) {
        return length < START_OF_RANGE || length > END_OF_RANGE;
    }

    public List<Integer> getAlphabets() {
        return makeAlphabets(this.word);
    }

    private List<Integer> makeAlphabets(String word) {
        return word.chars()
                .boxed()
                .collect(Collectors.toList());
    }
}
