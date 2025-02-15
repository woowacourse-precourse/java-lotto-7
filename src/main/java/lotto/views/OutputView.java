package lotto.views;

import lotto.utils.Messages;
import lotto.utils.MessageFormatter;

import java.util.ArrayList;
import java.util.List;

public class OutputView extends LottoView {

    public void displayError(String error) {
        displayMessage(error);
    }
    public void displayLottoCount(int count) {
        System.out.println();
        displayMessage(MessageFormatter.formatMessage(Messages.PURCHASED_COUNT, count));
    }

    public void displayIssuedLotto(List<List<Integer>> allIssuedLotto) {
        for (List<Integer> singleIssuedLotto : allIssuedLotto) {
            displayMessage(singleIssuedLotto.toString());
        }
    }

    public void displayStatisticsHeaders() {
        System.out.println();
        displayMessage(Messages.STATISTICS_HEADER);
        displayMessage(Messages.DASHES);
    }

    public void displayLottoMatch(boolean withBonus, int matchCount, int matchAmount, int count) {
        if (withBonus) {
            displayMessage(MessageFormatter.formatMessage(Messages.LOTTO_MATCH_WITH_BONUS, matchCount, matchAmount, count));
            return;
        }
        displayMessage(MessageFormatter.formatMessage(Messages.LOTTO_MATCH, matchCount, matchAmount, count));
    }

    public void displayTotalYield(double yield) {
        displayMessage(MessageFormatter.formatMessage(Messages.TOTAL_YIELD, yield));

    }
}
