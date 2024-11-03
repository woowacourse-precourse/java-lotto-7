package lotto.view;

import static lotto.view.Message.*;

import java.util.stream.Collectors;
import lotto.dto.LottoStatistics;
import lotto.dto.LottoStatistics.RankDTO;
import lotto.dto.LottosDTO;

public class OutputView {

    public void printInputPriceMessage() {
        INPUT_PRICE_MESSAGE.printMessage();
    }

    public void printDisplayBuyCountMessage(LottosDTO lottosDTO) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(DISPLAY_LOTTO_BUY_COUNT_MESSAGE.formatWith(lottosDTO.lottos().size()));
        stringBuilder.append('\n');
        lottosDTO.lottos().forEach(lottoNumbers -> {
            String list = lottoNumbers.numbers().stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(", "));
            stringBuilder.append(DISPLAY_LOTTO_INFO_MESSAGE.formatWith(list)).append('\n');
        });
        stringBuilder.append('\n');
        System.out.print(stringBuilder);
    }

    public void printInputWinningNumbers() {
        INPUT_LOTTO_WINNING_NUMBER_MESSAGE.printMessage();
    }

    public void printInputBonusNumber() {
        INPUT_LOTTO_BONUS_NUMBER_MESSAGE.printMessage();
    }

    public void printStatistics(LottoStatistics lottoStatistics) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(DISPLAY_RESULT_TITLE_MESSAGE.formatWith()).append('\n');
        stringBuilder.append(DISPLAY_RESULT_TITLE_DIVIDER.formatWith()).append('\n');
        for (RankDTO rankDTO : lottoStatistics.statistics().keySet()) {
            if (rankDTO.rank() == 0) {
                continue;
            }
            stringBuilder.append(DISPLAY_RESULT_INFO.formatWith(
                    rankDTO.matchCount(),
                    isFiveRank(rankDTO),
                    rankDTO.price(),
                    lottoStatistics.statistics().get(rankDTO)
            ));
            stringBuilder.append('\n');
        }
        stringBuilder.append(DISPLAY_PROFIT.formatWith(String.valueOf(lottoStatistics.profit())));
        System.out.println(stringBuilder);
    }

    public void printErrorMessage(String message) {
        System.out.println(message);
    }

    private String isFiveRank(RankDTO rankDTO) {
        if (rankDTO.rank() == 2 && rankDTO.containsBonus()) {
            return ", 보너스 볼 일치 ";
        }
        return " ";
    }
}
