package precourse.week3.domain.lottostatistic;

import precourse.week3.domain.lottostore.LottoTicketsStore;
import precourse.week3.domain.ranking.Ranking;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LottoStatistic {

    private static final int INITIAL_VALUE = 0;
    private final Map<Ranking, Integer> rankingAndCount;

    public LottoStatistic(Map<Ranking, Integer> rankingAndCount) {
        this.rankingAndCount = rankingAndCount;
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

    public int calculateRateOfReturn() {
        int lottoPrice = LottoTicketsStore.LOTTO_PRICE;
        validatePrice(lottoPrice);
        int totalReturn = calculateReturn();
        return totalReturn / lottoPrice;
    }

    private void validatePrice(int price) {
        if (price == INITIAL_VALUE) {
            throw new ArithmeticException("[ERROR] 0으로 나눌 수 없습니다.");
        }
    }

    private int calculateReturn() {
        return rankingAndCount.keySet().stream()
                .mapToInt(this::calculateEachReturn)
                .sum();
    }

    private int calculateEachReturn(Ranking ranking) {
        return rankingAndCount.get(ranking) * ranking.getPrize();
    }
}
