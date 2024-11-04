package lotto.io.lotto;

import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoConstant;
import lotto.domain.lotto.WinningStatisticsResponseDto;

public class LottoOutputView {

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printEnterAndMessage(String message) {
        System.out.println();
        System.out.println(message);
    }

    public void printPurchaseResult(List<Lotto> lottoes) {
        System.out.println();
        System.out.println(lottoes.size() + LottoConstant.PURCHASE_COUNT_MESSAGE);
        lottoes.stream().forEach(l -> {
            System.out.println(l.getNumbers());
        });
    }

    public void printWinningStatisticsResult(WinningStatisticsResponseDto winningStatisticsDto) {
        System.out.println();
        StringBuilder sb = new StringBuilder();
        sb.append(LottoConstant.WINNING_STATISTICS_MESSAGE
                .replace("{threeStrikePrice}", String.format("%,d", LottoConstant.THREE_STRIKE_PRICE))
                .replace("{threeStrikeCount}", String.format("%s", winningStatisticsDto.getThreeStrike()))
                .replace("{fourStrikePrice}", String.format("%,d", LottoConstant.FOUR_STRIKE_PRICE))
                .replace("{fourStrikeCount}", String.format("%s", winningStatisticsDto.getFourStrike()))
                .replace("{fiveStrikePrice}", String.format("%,d", LottoConstant.FIVE_STRIKE_PRICE))
                .replace("{fiveStrikeCount}", String.format("%s", winningStatisticsDto.getFiveStrike()))
                .replace("{fiveStrikeAndBallPrice}", String.format("%,d", LottoConstant.FIVE_STRIKE_AND_BALL_PRICE))
                .replace("{fiveStrikeAndBallCount}", String.format("%s", winningStatisticsDto.getFiveStrikeAndBall()))
                .replace("{sixStrikePrice}", String.format("%,d", LottoConstant.SIX_STRIKE_PRICE))
                .replace("{sixStrikeCount}", String.format("%s", winningStatisticsDto.getSixStrike()))
                .replace("{rateOfReturn}", String.format("%.1f", winningStatisticsDto.getRateOfReturn()))
        );

        System.out.println(sb.toString());
    }
}
