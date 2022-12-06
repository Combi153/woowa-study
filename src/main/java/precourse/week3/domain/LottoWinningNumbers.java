package precourse.week3.domain;

import java.util.List;

public class LottoWinningNumbers {

    private final List<WinningNumber> winningNumbers;
    private final WinningNumber bonusNumber;

    public LottoWinningNumbers(List<WinningNumber> winningNumbers, WinningNumber bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }
}
