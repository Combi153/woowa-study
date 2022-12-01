package precourse.week1.problem2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class DecoderTest {

    @DisplayName("생성자에 소문자 이외의 문자를 포함하는 문자열을 입력하였을 때 에러를 발생시키는지 확인")
    @ParameterizedTest
    @ValueSource(strings = {"Brown", "ooooo3ooooo", "OoooO", "123", "AAAA"})
    void validate_form_error_test(String errorCryptogram) {
        assertThatThrownBy(() -> new Decoder(errorCryptogram)).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 암호는 소문자만 가능합니다.");
    }

    @DisplayName("생성자에 1미만 1000초과의 문자열을 입력하였을 때 에러를 발생시키는지 확인")
    @ParameterizedTest
    @ValueSource(strings = {"", "a", "ab", "alskdfjlskdaflkdasflas"})
    void validate_length_error_test(String errorCryptogram) {
        if (errorCryptogram.length() > 0) {
            errorCryptogram = makeBigString(errorCryptogram);
        }
        String finalErrorCryptogram = errorCryptogram;

        assertThatThrownBy(() -> new Decoder(finalErrorCryptogram)).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 암호의 길이는 1 이상 1000 이하여야 합니다.");
    }

    private String makeBigString(String word) {
        StringBuilder stringBuilder = new StringBuilder();
        while(stringBuilder.length() <= 1000) {
            stringBuilder.append(word);
        }
        return stringBuilder.toString();
    }

    @DisplayName("생성자에 소문자로 구성된 1 이상 1000이하의 문자열을 입력하였을 때 Decoder 객체가 생성되는지 확인")
    @ParameterizedTest
    @ValueSource(strings = {"brown", "oooooooooo", "aoooasdfasdf", "as", "brwonrwonrndn"})
    void validate_true_test(String cryptogram) {
        Decoder decoder = new Decoder((cryptogram));

        assertThat(decoder).isInstanceOf(Decoder.class);
    }

    @DisplayName("decodeCryptogram 메소드를 호출하였을 때 연속된 중복 문자가 제거된 문자열을 반환하는지 확인")
    @ParameterizedTest
    @CsvSource({"browoanoommnaon, brown", "browoannaon, brown", "brown, brown", "zyelleyza, a"})
    void decodeCryptogram_test(String cryptogram, String expectedValue) {
        Decoder decoder = new Decoder((cryptogram));

        String actualValue = decoder.decodeCryptogram();

        assertThat(actualValue).isEqualTo(expectedValue);
    }
}