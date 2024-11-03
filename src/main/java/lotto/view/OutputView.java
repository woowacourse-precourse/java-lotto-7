package lotto.view;

public class OutputView {
    public void inputMoney() {
        System.out.println(OutputMessage.INPUT_MONEY.getMessage());
    }

    public void purchasedAmount() {
        System.out.println(OutputMessage.PURCHASED_AMOUNT.getMessage());
    }

    public void inputWinningNumbers() {
        System.out.println(OutputMessage.INPUT_WINNING_NUMBERS.getMessage());
    }

    public void inputBonusNumber() {
        System.out.println(OutputMessage.INPUT_BONUS_NUMBER.getMessage());
    }

    public void winningStatistics(Integer[] winningCount) {
        System.out.println(OutputMessage.WINNING_STATISTICS.getFormattedMessage((Object[]) winningCount));
    }

    public void rateOfReturn(double rateOfReturn) {
        System.out.println(OutputMessage.RATE_OF_RETURN.getFormattedMessage(rateOfReturn));
    }
}
