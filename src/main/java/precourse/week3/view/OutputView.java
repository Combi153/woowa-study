package precourse.week3.view;

import precourse.week3.domain.Ranking;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {

    public void printLottoTickets(int size, String message) {
        print(String.format(Message.PAYMENT_MESSAGE.getMessage(), size));
        print(message);
    }

    public void printStatistics(Map<Ranking, Integer> rankingAndCount, int rateOfReturn) {
        print(Message.STATISTICS_TITLE_MESSAGE.getMessage());
        printRankingAndCount(rankingAndCount);
        print(String.format(Message.RATE_OF_RETURN_MESSAGE.getMessage(), rateOfReturn));
    }

    private void printRankingAndCount(Map<Ranking, Integer> rankingAndCount) {
        List<Map.Entry<Ranking, Integer>> entries = makeAscendingEntries(rankingAndCount);
        for (Map.Entry<Ranking, Integer> entry : entries) {
            Ranking ranking = entry.getKey();
            int count = entry.getValue();
            String message = makeStatisticsMessageBy(ranking, count);
            print(message);
        }
    }

    private List<Map.Entry<Ranking, Integer>> makeAscendingEntries(Map<Ranking, Integer> rankingAndCount) {
        List<Map.Entry<Ranking, Integer>> entries = rankingAndCount.entrySet().stream()
                .sorted(Comparator.comparing(entry -> entry.getKey().getRanking()))
                .collect(Collectors.toList());
        Collections.reverse(entries);
        return entries;
    }

    private String makeStatisticsMessageBy(Ranking ranking, int count) {
        int prize = ranking.getPrize();
        int numberOfMatching = ranking.getNumberOfMatching();
        return String.format(getStatisticsMessageBy(ranking), numberOfMatching, prize, count);
    }

    private static String getStatisticsMessageBy(Ranking ranking) {
        if (ranking.getRanking() == 2) {
            return Message.STATISTICS_BONUS_CONTENT_MESSAGE.getMessage();
        }
        return Message.STATISTICS_NORMAL_CONTENT_MESSAGE.getMessage();
    }

    public void print(String message) {
        System.out.print(message);
    }
}
