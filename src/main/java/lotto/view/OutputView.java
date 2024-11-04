package lotto.view;

import lotto.model.Lotto;
import lotto.model.LottoTicket;

public class OutputView {
    public void inputMoney() {
        System.out.println(OutputMessage.INPUT_MONEY.getMessage());
    }

    public void purchaseHistory(int quantity, LottoTicket lottoTicket) {
        System.out.println("\n" + OutputMessage.PURCHASED_AMOUNT.getFormattedMessage(quantity));
        for (Lotto lotto : lottoTicket.getLottoTicket()) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void inputWinningNumbers() {
        System.out.println("\n" + OutputMessage.INPUT_WINNING_NUMBERS.getMessage());
    }

    public void inputBonusNumber() {
        System.out.println("\n" + OutputMessage.INPUT_BONUS_NUMBER.getMessage());
    }

    public void winningStatistics(Integer[] winningCount) {
        System.out.println("\n" + OutputMessage.WINNING_STATISTICS.getFormattedMessage((Object[]) winningCount));
    }

    public void rateOfReturn(double rateOfReturn) {
        System.out.println(OutputMessage.RATE_OF_RETURN.getFormattedMessage(rateOfReturn));
    }
}
