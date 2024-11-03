package lotto;

import java.util.List;

public class LottoStore {
    private static final int MINIMUM_MONEY_UNIT = 1000;

    private final int money;
    private int tickets;
    private List<Integer> winningNumbers;
    InputView inputView;

    public LottoStore(InputView inputView) {
        this.inputView = inputView;
        this.money = Integer.parseInt(inputView.inputMoney());
    }

    public List<Integer> getLottoNumbers() {
        this.winningNumbers = inputView.inputWinningNumber();
        return winningNumbers;
    }

    public int getMoney() {
        return money;
    }

    public void changeTickets() {
        this.tickets = money/MINIMUM_MONEY_UNIT;
    }

    public int getTickets() {
        changeTickets();
        return tickets;
    }

    public int getBonusNumber() {
        return inputView.inputBonusNumber(winningNumbers);
    }

}
