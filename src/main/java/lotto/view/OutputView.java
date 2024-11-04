package lotto.view;

import static lotto.view.ViewMessage.INPUT_BONUS_NUMBER;
import static lotto.view.ViewMessage.INPUT_PURCHASE_PRICE;
import static lotto.view.ViewMessage.INPUT_WINNING_NUMBERS;
import static lotto.view.ViewMessage.PRINT_DIVIDER;
import static lotto.view.ViewMessage.PRINT_MATCH_3;
import static lotto.view.ViewMessage.PRINT_MATCH_4;
import static lotto.view.ViewMessage.PRINT_MATCH_5;
import static lotto.view.ViewMessage.PRINT_MATCH_5_AND_BONUS;
import static lotto.view.ViewMessage.PRINT_MATCH_6;
import static lotto.view.ViewMessage.PRINT_RETURN_RATE;
import static lotto.view.ViewMessage.PRINT_TICKET_COUNT;
import static lotto.view.ViewMessage.PRINT_WINNING_STATISTICS;

import lotto.common.LottoRank;
import lotto.model.Lotto;
import lotto.model.LottoResult;

public class OutputView {
    private OutputView() {
    }

    public static void printInputPurchasePrice() {
        printMessage(INPUT_PURCHASE_PRICE.getMessage());
    }

    public static void printLottoTicketCounts(int ticketCount) {
        printMessage();
        printMessage(PRINT_TICKET_COUNT.getMessage(), ticketCount);
    }

    public static void printLotto(Lotto lotto) {
        printMessage(lotto.toString());
    }

    public static void printInputWinningNumbers() {
        printMessage();
        printMessage(INPUT_WINNING_NUMBERS.getMessage());
    }

    public static void printInputBonusNumber() {
        printMessage();
        printMessage(INPUT_BONUS_NUMBER.getMessage());
    }

    public static void printStatistics(LottoResult lottoResult) {
        printMessage();
        printMessage(PRINT_WINNING_STATISTICS.getMessage());
        printMessage(PRINT_DIVIDER.getMessage());
        printMessage(PRINT_MATCH_3.getMessage(), lottoResult.getWinningCount(LottoRank.FIFTH));
        printMessage(PRINT_MATCH_4.getMessage(), lottoResult.getWinningCount(LottoRank.FOURTH));
        printMessage(PRINT_MATCH_5.getMessage(), lottoResult.getWinningCount(LottoRank.THIRD));
        printMessage(PRINT_MATCH_5_AND_BONUS.getMessage(), lottoResult.getWinningCount(LottoRank.SECOND));
        printMessage(PRINT_MATCH_6.getMessage(), lottoResult.getWinningCount(LottoRank.FIRST));
    }

    public static void printReturnRate(double returnRate) {
        printMessage(PRINT_RETURN_RATE.getMessage(), returnRate);
    }

    public static void printErrorMessage(String message) {
        printMessage(message);
    }

    private static void printMessage() {
        System.out.println();
    }

    private static void printMessage(String message) {
        System.out.println(message);
    }

    private static void printMessage(String message, Object... args) {
        System.out.println(String.format(message, args));
    }
}