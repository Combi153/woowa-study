package precourse.week3.domain;

public class WinningNumber {

    private final int winningNumber;

    public WinningNumber(int winningNumber) {
        validate(winningNumber);
        this.winningNumber = winningNumber;
    }

    private void validate(int number) {
        if (isOutOfRange(number)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호가 로또 범위를 초과하였습니다.");
        }
    }

    private boolean isOutOfRange(int number) {
        return number < LottoNumberGenerator.START_NUMBER_INCLUSIVE || number > LottoNumberGenerator.END_NUMBER_INCLUSIVE;
    }
}
