package lotto.domain;

import java.util.List;
import lotto.util.NumberUtil;
import lotto.view.InputView;

public class LottoStore {

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

    private void changeTickets() {
        this.tickets = money/ NumberUtil.LOTTO_PER_PURCHASE_UNIT;
    }

    public int getTickets() {
        changeTickets();
        return tickets;
    }

    public int getBonusNumber() {
        return inputView.inputBonusNumber(winningNumbers);
    }

}
