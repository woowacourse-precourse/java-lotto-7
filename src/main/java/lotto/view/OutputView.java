package lotto.view;

import static lotto.message.SystemMessage.PURCHASED_LOTTO_COUNT;
import static lotto.message.SystemMessage.SECTION_DIVIDER;
import static lotto.message.SystemMessage.TOTAL_PROFIT_RATE;
import static lotto.message.SystemMessage.WINNING_STATISTICS_HEADER;

import lotto.dto.ResultDto;

public class OutputView {

    public void printPurchasedLotto(int count, String lottos) {
        System.out.printf(PURCHASED_LOTTO_COUNT.getMessage(),count);
        System.out.print(System.lineSeparator());
        System.out.println(lottos);
        System.out.print(System.lineSeparator());
    }

    public void printWinningStatic(ResultDto resultDto) {
        System.out.println(WINNING_STATISTICS_HEADER.getMessage());
        System.out.println(SECTION_DIVIDER.getMessage());
        System.out.println(resultDto.toResults());
    }

    public void printProfitRate(Double profitRate) {
        System.out.printf(TOTAL_PROFIT_RATE.getMessage(), profitRate);
        System.out.print(System.lineSeparator());
    }

}
