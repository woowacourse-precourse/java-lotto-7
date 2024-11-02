package lotto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        //return Stream.of(inputView.inputWinningNumber().split(",")).map(Integer::parseInt).collect(Collectors.toList());
    }

    public int getMoney() {
        return money;
    }

    public void changeTickets() {
        this.tickets = money/1000;
    }

    public int getTickets() {
        changeTickets();
        return tickets;
    }

    public int getBonusNumber() {
        return inputView.inputBonusNumber(winningNumbers);
    }

}
