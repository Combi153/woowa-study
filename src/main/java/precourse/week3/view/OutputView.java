package precourse.week3.view;

import precourse.week3.domain.lottostatistic.LottoStatistic;

import java.text.DecimalFormat;
import java.util.List;

public class OutputView {

    public void printLottoTickets(int size, String message) {
        print(String.format(Message.PAYMENT_MESSAGE.getMessage(), size));
        print(message);
    }

    public void printStatistics(LottoStatistic lottoStatistic) {
        print(Message.STATISTICS_TITLE_MESSAGE.getMessage());
        printRankingAndCount(lottoStatistic);
        print(String.format(Message.RATE_OF_RETURN_MESSAGE.getMessage(), lottoStatistic.calculateRateOfReturn()));
    }

    private void printRankingAndCount(LottoStatistic lottoStatistic) {
        List<List<Integer>> statistics = lottoStatistic.getStatisticsByDescendingRank();
        for (List<Integer> statistic : statistics) {
            String message = makeStatisticsMessageBy(statistic);
            print(message);
        }
    }

    private String makeStatisticsMessageBy(List<Integer> statistic) {
        int ranking = statistic.get(0);
        int numberOfMatching = statistic.get(1);
        String prize = formatPrize(statistic.get(2));
        int count = statistic.get(3);
        return String.format(getStatisticsMessageBy(ranking), numberOfMatching, prize, count);
    }

    private String formatPrize(int prize) {
        DecimalFormat decimalFormat = new DecimalFormat("###,###");
        return decimalFormat.format(prize);
    }

    private static String getStatisticsMessageBy(int ranking) {
        if (ranking == 2) {
            return Message.STATISTICS_BONUS_CONTENT_MESSAGE.getMessage();
        }
        return Message.STATISTICS_NORMAL_CONTENT_MESSAGE.getMessage();
    }

    public void print(String message) {
        System.out.print(message);
    }
}
