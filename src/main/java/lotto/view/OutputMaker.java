package lotto.view;

import lotto.domain.LottoRank;
import lotto.dto.LottoDto;
import lotto.dto.LottosDto;
import lotto.dto.WinningResultDto;
import java.util.stream.Collectors;

public class OutputMaker {
    private static final String PURCHASE_MESSAGE = "\n%d개를 구매했습니다.\n";
    private static final String RETURN_RATE = "총 수익률은 %.1f%%입니다.";
    private static final String RESULT_MESSAGE = "\n당첨 통계\n---\n";
    private static final String CORRECT_CNT = "%d개 일치";
    private static final String BONUS_REQUIRED = ", 보너스 볼 일치";
    private static final String WINNING_AMOUNT = " (%,d원) - %d개";

    public static String makePurchaseOverview(LottosDto lottosDto) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(PURCHASE_MESSAGE, lottosDto.getSize()));
        for (LottoDto lotto : lottosDto.getLottos()) {
            sb.append(makeLottoInfo(lotto));
        }
        return sb.toString();
    }

    public static String makeFinalResult(WinningResultDto resultDto) {
        StringBuilder sb = new StringBuilder();
        sb.append(RESULT_MESSAGE);
        for (LottoRank value : LottoRank.values()) {
            if (value.equals(LottoRank.ETC)) continue;
            sb.append(String.format(CORRECT_CNT, value.getCorrectCnt()));
            if (value.isBonusNumberRequired()) {
                sb.append(BONUS_REQUIRED);
            }
            sb.append(String.format(WINNING_AMOUNT, value.getWinningAmount(),
                    resultDto.getWinningResults()
                            .getOrDefault(value, 0)));
            sb.append("\n");
        }
        sb.append(String.format(RETURN_RATE, resultDto.getReturnRate()));
        return sb.toString();
    }


    private static String makeLottoInfo(LottoDto lotto) {
        return lotto.getNumbers()
                .stream()
                .map(l -> String.valueOf(l))
                .collect(Collectors.joining(", ", "[", "]\n"));
    }
}
