package precourse.week1.problem2.domain;

public class Decoder {

    private final String cryptogram;

    public Decoder(String cryptogram) {
        validate(cryptogram);
        this.cryptogram = cryptogram;
    }

    void validate(String cryptogram) {
        int length = cryptogram.length();
        if (length < 1 || length > 1000) {
            throw new IllegalArgumentException("[ERROR] 암호의 길이는 1 이상 1000 이하여야 합니다.");
        }
        if (!cryptogram.matches("[a-z]{1,}")) {
            throw new IllegalArgumentException("[ERROR] 암호는 소문자만 가능합니다.");
        }
    }

    public String decodeCryptogram() {
        String decodedCryptogram = cryptogram;
        while(hasConsecutiveDuplicate(decodedCryptogram)) {
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
