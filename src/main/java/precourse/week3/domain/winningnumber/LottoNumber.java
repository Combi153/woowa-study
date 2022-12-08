package precourse.week3.domain.winningnumber;

import precourse.week3.domain.lottomaker.LottoNumberGenerator;

import java.util.Objects;

public class LottoNumber {

    private final int lottoNumber;

    public LottoNumber(int lottoNumber) {
        validate(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    private void validate(int number) {
        if (isOutOfRange(number)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호가 로또 범위를 초과하였습니다.");
        }
    }

    private boolean isOutOfRange(int number) {
        return number < LottoNumberGenerator.START_NUMBER_INCLUSIVE || number > LottoNumberGenerator.END_NUMBER_INCLUSIVE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoNumber that = (LottoNumber) o;
        return lottoNumber == that.lottoNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumber);
    }
}
