package precourse.week1.problem2;

import precourse.week1.problem2.domain.Decoder;

public class Problem2 {
    public static String solution(String cryptogram) {
        Decoder decoder = new Decoder(cryptogram);
        return decoder.decodeCryptogram();
    }
}
