package lotto.view;

import static lotto.view.Message.DISPLAY_LOTTO_BUY_COUNT_MESSAGE;
import static lotto.view.Message.DISPLAY_LOTTO_INFO_MESSAGE;
import static lotto.view.Message.DISPLAY_PROFIT;
import static lotto.view.Message.DISPLAY_RESULT_TITLE_DIVIDER;
import static lotto.view.Message.DISPLAY_RESULT_TITLE_MESSAGE;
import static lotto.view.Message.INPUT_LOTTO_BONUS_NUMBER_MESSAGE;
import static lotto.view.Message.INPUT_LOTTO_WINNING_NUMBER_MESSAGE;
import static lotto.view.Message.INPUT_PRICE_MESSAGE;
import static lotto.view.Message.getResultInfo;

import java.util.stream.Collectors;
import lotto.dto.LottoStatistics;
import lotto.dto.LottosDTO;

public class OutputView {

    public void printInputPriceMessage() {
        INPUT_PRICE_MESSAGE.print();
    }

    public void printDisplayBuyCountMessage(LottosDTO lottosDTO) {
        PrintStringBuilder stringBuilder = new PrintStringBuilder();
        appendBuyHeader(stringBuilder, lottosDTO);
        appendBuyContent(stringBuilder, lottosDTO);
        stringBuilder.print();
    }

    private void appendBuyHeader(PrintStringBuilder stringBuilder, LottosDTO lottosDTO) {
        stringBuilder.appendLine(DISPLAY_LOTTO_BUY_COUNT_MESSAGE.format(lottosDTO.lottos().size()));
    }

    private void appendBuyContent(PrintStringBuilder stringBuilder, LottosDTO lottosDTO) {
        lottosDTO.lottos().forEach(lottoNumbers -> {
            String lottoInfo = lottoNumbers.numbers()
                    .stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(", "));
            stringBuilder.appendLine(DISPLAY_LOTTO_INFO_MESSAGE.format(lottoInfo));
        });
    }

    public void printInputWinningNumbers() {
        INPUT_LOTTO_WINNING_NUMBER_MESSAGE.print();
    }

    public void printInputBonusNumber() {
        INPUT_LOTTO_BONUS_NUMBER_MESSAGE.print();
    }

    public void printStatistics(LottoStatistics lottoStatistics) {
        PrintStringBuilder stringBuilder = new PrintStringBuilder();
        appendStatisticsHeader(stringBuilder);
        appendStatisticsContent(stringBuilder, lottoStatistics);
        appendStatisticsProfit(stringBuilder, lottoStatistics.profit());
        stringBuilder.print();
    }

    private void appendStatisticsHeader(PrintStringBuilder stringBuilder) {
        stringBuilder.appendLine(DISPLAY_RESULT_TITLE_MESSAGE.format());
        stringBuilder.appendLine(DISPLAY_RESULT_TITLE_DIVIDER.format());
    }

    private void appendStatisticsContent(PrintStringBuilder stringBuilder, LottoStatistics lottoStatistics) {
        lottoStatistics.statistics().forEach(((rankDTO, count) -> stringBuilder.appendLine(getResultInfo(
                rankDTO.rank(),
                rankDTO.matchCount(),
                rankDTO.price(),
                lottoStatistics.statistics().get(rankDTO)
        ))));
    }

    private void appendStatisticsProfit(PrintStringBuilder stringBuilder, double profit) {
        stringBuilder.appendLine(DISPLAY_PROFIT.format(profit));
    }

    public void printErrorMessage(String message) {
        System.out.println(message);
    }
}
