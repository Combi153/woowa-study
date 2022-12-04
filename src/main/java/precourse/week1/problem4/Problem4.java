package precourse.week1.problem4;

import precourse.week1.problem4.domain.ReverseDictionary;
import precourse.week1.problem4.domain.Word;

public class Problem4 {
    public static String solution(String word) {
        ReverseDictionary dictionary = new ReverseDictionary();
        return dictionary.translate(new Word(word));
    }
}
