package precourse.week3.domain.ranking;

import precourse.week3.domain.result.LottoResult;

public enum Ranking {

    FIRST_PLACE(1, 6, false, 2_000_000_000),
    SECOND_PLACE(2, 5, true, 30_000_000),
    THIRD_PLACE(3, 5, false, 1_500_000),
    FOURTH_PLACE(4, 4, null, 50_000),
    FIFTH_PLACE(5, 3, null, 5_000);

    private final int ranking;
    private final int numberOfMatching;
    private final Boolean isMatchingWithBonus;
    private final int prize;

    Ranking(int ranking, int numberOfMatching, Boolean isMatchingWithBonus, int prize) {
        this.ranking = ranking;
        this.numberOfMatching = numberOfMatching;
        this.isMatchingWithBonus = isMatchingWithBonus;
        this.prize = prize;
    }

    public int getRanking() {
        return ranking;
    }

    public int getNumberOfMatching() {
        return numberOfMatching;
    }

    public Boolean isMatchingWithBonus() {
        return isMatchingWithBonus;
    }

    public int getPrize() {
        return prize;
    }

    public LottoResult getLottoResult() {
        return new LottoResult(numberOfMatching, isMatchingWithBonus);
    }

    public LottoResult getTrueLottoResult() {
        return new LottoResult(numberOfMatching, true);
    }

    public LottoResult getFalseLottoResult() {
        return new LottoResult(numberOfMatching, false);
    }
}
