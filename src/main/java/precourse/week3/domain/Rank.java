package precourse.week3.domain;

public enum Rank {

    FIRST_PLACE(6, false),
    SECOND_PLACE(5, true),
    THIRD_PLACE(5, false),
    FOURTH_PLACE(4, null),
    FIFTH_PLACE(3, null);

    private final int numberOfMatching;
    private final Boolean isMatchingWithBonus;

    Rank(int numberOfMatching, Boolean isMatchingWithBonus) {
        this.numberOfMatching = numberOfMatching;
        this.isMatchingWithBonus = isMatchingWithBonus;
    }

    public int getNumberOfMatching() {
        return numberOfMatching;
    }

    public Boolean isMatchingWithBonus() {
        return isMatchingWithBonus;
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
