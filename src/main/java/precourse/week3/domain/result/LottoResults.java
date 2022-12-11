package precourse.week3.domain.result;

import precourse.week3.domain.lottostatistic.LottoStatistic;
import precourse.week3.domain.lottostore.LottoTicketsStore;
import precourse.week3.domain.ranking.Ranking;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResults {

    private final List<LottoResult> results;

    public LottoResults(List<LottoResult> results) {
        this.results = results;
    }

    public LottoStatistic createLottoStatistic() {
        Map<Ranking, Integer> counts = countByRank();
        int totalPurchase = calculateTotalPurchase();
        return new LottoStatistic(counts, totalPurchase);
    }

    private Map<Ranking, Integer> countByRank() {
        Map<Ranking, Integer> counts = new HashMap<>();
        for (Ranking ranking : Ranking.values()) {
            counts.put(ranking, countFrequency(ranking));
        }
        return counts;
    }

    private int calculateTotalPurchase() {
        return results.size() * LottoTicketsStore.LOTTO_PRICE;
    }

    private int countFrequency(Ranking ranking) {
        if (ranking.isMatchingWithBonus() == null) {
            return Collections.frequency(results, ranking.getTrueLottoResult()) + Collections.frequency(results, ranking.getFalseLottoResult());
        }
        return Collections.frequency(results, ranking.getLottoResult());
    }
}
