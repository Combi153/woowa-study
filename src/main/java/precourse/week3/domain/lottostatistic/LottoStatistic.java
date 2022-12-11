package precourse.week3.domain.lottostatistic;

import precourse.week3.domain.ranking.Ranking;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LottoStatistic {

    private static final int INITIAL_VALUE = 0;
    private static final int FIRST_DECIMAL_PLACE = 1;
    private final Map<Ranking, Integer> rankingAndCount;
    private final int totalPurchase;

    public LottoStatistic(Map<Ranking, Integer> rankingAndCount, int totalPurchase) {
        this.rankingAndCount = rankingAndCount;
        this.totalPurchase = totalPurchase;
    }

    public List<List<Integer>> getStatisticsByDescendingRank() {
        List<Ranking> rankings = makeDescendingRankings();
        return rankings.stream()
                .map(makeDetails())
                .collect(Collectors.toList());
    }

    private List<Ranking> makeDescendingRankings() {
        return rankingAndCount.keySet().stream()
                .sorted(Comparator.comparing(Ranking::getPrize))
                .collect(Collectors.toList());
    }

    private Function<Ranking, List<Integer>> makeDetails() {
        return ranking -> List.of(ranking.getRanking(), ranking.getNumberOfMatching(), ranking.getPrize(), rankingAndCount.get(ranking));
    }

    public String calculateRateOfReturn() {
        BigDecimal lottoPurchase = toBigDecimal(totalPurchase);
        BigDecimal totalReturn = calculateReturn().multiply(toBigDecimal(100));
        return divideAndRoundHalfUpToSecondPlace(lottoPurchase, totalReturn).toString();
    }

    private BigDecimal divideAndRoundHalfUpToSecondPlace(BigDecimal divisor, BigDecimal dividend) {
        validateDivisor(divisor.intValue());
        return dividend.divide(divisor, FIRST_DECIMAL_PLACE, RoundingMode.HALF_UP);
    }

    private void validateDivisor(int price) {
        if (price == INITIAL_VALUE) {
            throw new ArithmeticException("[ERROR] 0으로 나눌 수 없습니다.");
        }
    }

    private BigDecimal calculateReturn() {
        BigDecimal totalReturn = BigDecimal.valueOf(INITIAL_VALUE);
        for (Ranking ranking : rankingAndCount.keySet()) {
            totalReturn = totalReturn.add(calculateEachReturn(ranking));
        }
        return totalReturn;
    }

    private BigDecimal calculateEachReturn(Ranking ranking) {
        return multiplyTwoNumberByBigDecimal(rankingAndCount.get(ranking), ranking.getPrize());
    }

    private BigDecimal multiplyTwoNumberByBigDecimal(int numberA, int numberB) {
        BigDecimal bigNumberA = toBigDecimal(numberA);
        BigDecimal bigNumberB = toBigDecimal(numberB);
        return bigNumberA.multiply(bigNumberB);
    }

    private BigDecimal toBigDecimal(int integer) {
        return BigDecimal.valueOf(integer);
    }
}
