package precourse.week1.problem2.domain;

public class Decoder {

    private static final int START_OF_RANGE = 1;
    private static final int END_OF_RANGE = 1000;
    private final String cryptogram;

    public Decoder(String cryptogram) {
        validate(cryptogram);
        this.cryptogram = cryptogram;
    }

    private void validate(String cryptogram) {
        if (isOutOfRange(cryptogram.length())) {
            throw new IllegalArgumentException("[ERROR] 암호의 길이는 1 이상 1000 이하여야 합니다.");
        }
        if (!isContainingOnlyLowercase(cryptogram)) {
            throw new IllegalArgumentException("[ERROR] 암호는 소문자만 가능합니다.");
        }
    }

    private boolean isOutOfRange(int length) {
        return length < START_OF_RANGE || length > END_OF_RANGE;
    }

    private boolean isContainingOnlyLowercase(String cryptogram) {
        return cryptogram.matches("[a-z]+");
    }

    public String decodeCryptogram() {
        String decodedCryptogram = cryptogram;
        while (hasConsecutiveDuplicate(decodedCryptogram)) {
            decodedCryptogram = removeConsecutiveDuplicate(decodedCryptogram);
        }
        return decodedCryptogram;
    }

    private boolean hasConsecutiveDuplicate(String cryptogram) {
        return cryptogram.matches(".*([a-z]+)\\1.*");
    }

    private String removeConsecutiveDuplicate(String cryptogram) {
        return cryptogram.replaceAll("([a-z]+)\\1", "");
    }
}
