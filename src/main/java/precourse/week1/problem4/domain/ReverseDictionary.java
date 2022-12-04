package precourse.week1.problem4.domain;

public class ReverseDictionary {

    private static final Range UPPER_CASE = (number) -> number >= AsciiCode.START_OF_UPPER_CASE.getNumber() && number <= AsciiCode.END_OF_UPPER_CASE.getNumber();
    private static final Range LOWER_CASE = (number) -> number >= AsciiCode.START_OF_LOWER_CASE.getNumber() && number <= AsciiCode.END_OF_LOWER_CASE.getNumber();
    private static final Translator UPPER_CASE_TRANSLATOR = (original) -> AsciiCode.START_OF_UPPER_CASE.getNumber() + AsciiCode.END_OF_UPPER_CASE.getNumber() - original;
    private static final Translator LOWER_CASE_TRANSLATOR = (original) -> AsciiCode.START_OF_LOWER_CASE.getNumber() + AsciiCode.END_OF_LOWER_CASE.getNumber() - original;

    public Word reverse(Word word) {
        Word reversedWord = word.changeBy(UPPER_CASE_TRANSLATOR, UPPER_CASE);
        reversedWord = reversedWord.changeBy(LOWER_CASE_TRANSLATOR, LOWER_CASE);
        return reversedWord;
    }
}
