package precourse.week3.domain.result;

import java.util.Objects;

public class LottoResult {

    private final int numberOfMatching;
    private final boolean hasBonusNumber;

    public LottoResult(int numberOfMatching, boolean hasBonusNumber) {
        this.numberOfMatching = numberOfMatching;
        this.hasBonusNumber = hasBonusNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoResult that = (LottoResult) o;
        return numberOfMatching == that.numberOfMatching && hasBonusNumber == that.hasBonusNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberOfMatching, hasBonusNumber);
    }
}
