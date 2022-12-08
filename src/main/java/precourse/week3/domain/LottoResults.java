package precourse.week3.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoResults {

    private final List<LottoResult> results;

    public LottoResults(List<LottoResult> results) {
        this.results = results;
    }

    public List<Integer> countByRank() {
        List<Integer> counts = new ArrayList<>();
        for (Rank rank : Rank.values()) {
            counts.add(countFrequency(rank));
        }
        return counts;
    }

    private int countFrequency(Rank rank) {
        if (rank.isMatchingWithBonus() == null) {
            return Collections.frequency(results, rank.getTrueLottoResult()) + Collections.frequency(results, rank.getFalseLottoResult());
        }
        return Collections.frequency(results, rank.getLottoResult());
    }
}
