package lotto.view;

import static lotto.constants.OutputMessageConstants.CLOSE_BRACKET;
import static lotto.constants.OutputMessageConstants.GET_BONUS_MESSAGE;
import static lotto.constants.OutputMessageConstants.GET_MESSAGE;
import static lotto.constants.OutputMessageConstants.LINE;
import static lotto.constants.OutputMessageConstants.LOTTO_UNIT;
import static lotto.constants.OutputMessageConstants.MIDDLE_BAR;
import static lotto.constants.OutputMessageConstants.MONEY_UNIT;
import static lotto.constants.OutputMessageConstants.OPEN_BRACKET;
import static lotto.constants.OutputMessageConstants.PERCENT_END;
import static lotto.constants.OutputMessageConstants.RETURN_PERCENT;
import static lotto.constants.OutputMessageConstants.WINNING_DETAIL_MESSAGE;
import static lotto.constants.RegExpConstants.ESCAPE_ENTER;

import java.text.NumberFormat;
import lotto.model.WinningPriceStore;

public class WinningDetailView {

    private final StringBuilder sb = new StringBuilder();

    public void addMessage() {
        sb.append(WINNING_DETAIL_MESSAGE).append(ESCAPE_ENTER).append(LINE).append(ESCAPE_ENTER);
    }

    public void addMatchDetail(WinningPriceStore winningPriceStore) {
        String printPrice = NumberFormat.getInstance().format(winningPriceStore.getMatchPrice());
        String getMessage = GET_MESSAGE;
        if (winningPriceStore.isBonus()) {
            getMessage = GET_BONUS_MESSAGE;
        }
        sb.append(winningPriceStore.getNumberMatchCount()).append(getMessage).append(OPEN_BRACKET).append(printPrice)
                .append(MONEY_UNIT).append(CLOSE_BRACKET).append(MIDDLE_BAR).append(winningPriceStore.getLottoCount())
                .append(LOTTO_UNIT)
                .append(ESCAPE_ENTER);
    }

    public void addReturnPercent(long returnPercent) {
        sb.append(RETURN_PERCENT).append(returnPercent).append(PERCENT_END).append(ESCAPE_ENTER);
    }

    public void print() {
        System.out.println(sb);
    }

}
