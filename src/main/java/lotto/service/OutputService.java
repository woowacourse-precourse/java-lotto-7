package lotto.service;

import lotto.message.IOMessage;
import lotto.message.WinningNumMessage;
import lotto.model.Lotto;

import java.util.List;

public class OutputService {

    public String getLottoCountMessage(int lottoCount) {
        return String.format(IOMessage.NUMBER_OF_PURCHASES.getMessage(), lottoCount);
    }

    public String getLottosMessage(List<Lotto> lottos) {
        StringBuilder lottoListMessage = new StringBuilder();
        for (Lotto lotto : lottos) {
            lottoListMessage.append(lotto).append("\n");
        }
        return lottoListMessage.toString();
    }

    public String getLottoStatisticsMessage(int[] matchCounts) {
        StringBuilder statisticsMessage = new StringBuilder();
        statisticsMessage.append(IOMessage.WINNING_STATISTICS_OUTPUT.getMessage());
        statisticsMessage.append(String.format(WinningNumMessage.MATCHES_3_WINNING.getMessage(), matchCounts[0]));
        statisticsMessage.append(String.format(WinningNumMessage.MATCHES_4_WINNING.getMessage(), matchCounts[1]));
        statisticsMessage.append(String.format(WinningNumMessage.MATCHES_5_WINNING.getMessage(), matchCounts[2]));
        statisticsMessage.append(String.format(WinningNumMessage.MATCHES_BONUS_WINNING.getMessage(), matchCounts[3]));
        statisticsMessage.append(String.format(WinningNumMessage.MATCHES_6_WINNING.getMessage(), matchCounts[4]));
        return statisticsMessage.toString();
    }

    public String getYieldMessage(double yield) {
        return String.format(IOMessage.RATE_OF_RETURN_OUTPUT.getMessage(), yield);
    }
}
