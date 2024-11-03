package lotto.view;

import static lotto.domain.Winning.FIFTH;
import static lotto.domain.Winning.FIFTH_WITH_BONUS;
import static lotto.domain.Winning.FOURTH;
import static lotto.domain.Winning.SIXTH;
import static lotto.domain.Winning.THIRD;
import static lotto.message.OutputMessage.BONUS_NUMBER_PROMPT;
import static lotto.message.OutputMessage.MATCH_COUNT_MESSAGE_WITH_BONUS;
import static lotto.message.OutputMessage.PURCHASED_TICKET_COUNT;
import static lotto.message.OutputMessage.PURCHASE_AMOUNT_PROMPT;
import static lotto.message.OutputMessage.TOTAL_RETURN_MESSAGE;
import static lotto.message.OutputMessage.WINNING_NUMBER_PROMPT;
import static lotto.message.OutputMessage.WINNING_STATISTICS_HEADER;

import java.util.Map;
import lotto.domain.User;
import lotto.domain.Winning;
import lotto.message.OutputMessage;

public class OutputView {

    public void printPurchaseAmount() {
        System.out.println(PURCHASE_AMOUNT_PROMPT.getMessage());
    }

    public void printBuyingQuantity(User user) {
        System.out.println();
        System.out.printf(PURCHASED_TICKET_COUNT.getMessage(), user.getQuantityTickets());
    }

    public void printUserLottoNumbers(User user) {
        user.getLottoTickets().forEach(userLotto ->
                System.out.println(userLotto.getNumbers()));
    }

    public void printWinningNumbers() {
        System.out.println();
        System.out.println(WINNING_NUMBER_PROMPT.getMessage());
    }

    public void printBonusNumber() {
        System.out.println();
        System.out.println(BONUS_NUMBER_PROMPT.getMessage());
    }

    public void printWinningHistory(Map<Winning, Integer> winningCounts) {
        System.out.println(WINNING_STATISTICS_HEADER.getMessage());

        printWinningCount(THIRD, winningCounts);
        printWinningCount(FOURTH, winningCounts);
        printWinningCount(FIFTH, winningCounts);
        printWinningCountWithBonus(FIFTH_WITH_BONUS, winningCounts);
        printWinningCount(SIXTH, winningCounts);
    }

    private void printWinningCount(Winning winning, Map<Winning, Integer> winningCounts) {
        System.out.printf(OutputMessage.MATCH_COUNT_MESSAGE.getMessage(),
                winning.getLabel(),
                winning.getFormattedWinnings(),
                winningCounts.getOrDefault(winning, 0));
    }

    private void printWinningCountWithBonus(Winning winning, Map<Winning, Integer> winningCounts) {
        System.out.printf(MATCH_COUNT_MESSAGE_WITH_BONUS.getMessage(),
                winning.getFormattedWinnings(),
                winningCounts.getOrDefault(winning, 0));
    }

    public void printWinningYield(String yieldOfLotto) {
        System.out.printf(TOTAL_RETURN_MESSAGE.getMessage(), yieldOfLotto);
    }
}

