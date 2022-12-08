package precourse.week3.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResults {

    private final int INITIAL_VALUE = 0;
    private final List<LottoResult> results;

    public LottoResults(List<LottoResult> results) {
        this.results = results;
    }

    public Map<Ranking, Integer> countByRank() {
        Map<Ranking, Integer> counts = new HashMap<>();
        for (Ranking ranking : Ranking.values()) {
            counts.put(ranking, countFrequency(ranking));
        }
        return counts;
    }

    public int calculateRateOfReturn(int lottoPrice) {
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
        int totalReturn = INITIAL_VALUE;
        for (Ranking ranking : Ranking.values()) {
            totalReturn += calculateEachReturn(ranking);
        }
        return totalReturn;
    }

    private int calculateEachReturn(Ranking ranking) {
        return countFrequency(ranking) * ranking.getPrize();
    }

    private int countFrequency(Ranking ranking) {
        if (ranking.isMatchingWithBonus() == null) {
            return Collections.frequency(results, ranking.getTrueLottoResult()) + Collections.frequency(results, ranking.getFalseLottoResult());
        }
        return Collections.frequency(results, ranking.getLottoResult());
    }
}
