package lotto.front.builder;

import java.util.Map;
import lotto.global.enums.OutputMessage;
import lotto.global.enums.WinningLottoRank;

public class LottoWinningResultOutputBuilder {
    private static final String NEW_LINE = "\n";
    private static final String THOUSANDS_SEPARATOR = "%,d";

    public static String build(Map<WinningLottoRank, Integer> winningCount, Double rateOfReturn) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(NEW_LINE).append(OutputMessage.LOTTO_WINNING_STAT.getMessage()).append(NEW_LINE);
        // 각 LottoDrawRank의 winningCount 수에 맞게 메시지를 생성
        winningCount.forEach((winningLottoRank, count) -> {
            String winningResultMessage = getWinningResultMessage(winningLottoRank);
            String winningResult = formatWinningResult(winningResultMessage, winningLottoRank, count);
            stringBuilder.append(winningResult).append(NEW_LINE);
        });
        stringBuilder.append(formatRateOfReturn(OutputMessage.RATE_OF_RETURN.getMessage(), rateOfReturn));

        return stringBuilder.toString();
    }

    // 수익률을 포맷팅
    private static String formatRateOfReturn(String rateOfReturnMessage, Double rateOfReturn) {
        return String.format(rateOfReturnMessage, rateOfReturn);
    }

    // LottoDrawRank에 맞는 메시지를 가져옴.
    private static String getWinningResultMessage(WinningLottoRank winningLottoRank) {
        if (winningLottoRank == WinningLottoRank.SECOND_PLACE) {
            return OutputMessage.SECOND_PLACE_RESULT.getMessage();
        }
        return OutputMessage.OTHER_PLACE_RESULT.getMessage();
    }

    // 돈을 천 단위로 끊고 결과 메시지를 포맷팅
    private static String formatWinningResult(String lottoResultMessage, WinningLottoRank winningLottoRank,
                                              Integer integer) {
        String formattedPrizeMoney = String.format(THOUSANDS_SEPARATOR, winningLottoRank.getPrizeMoney());
        return String.format(lottoResultMessage, winningLottoRank.getDrawnNumberCount(), formattedPrizeMoney, integer);
    }
}
