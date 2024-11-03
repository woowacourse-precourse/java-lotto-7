package lotto.controller;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.Winning;
import lotto.view.Winning_InputView;

public class WinningController {
    private final List<Lotto> LottoTickets;
    private final Winning_InputView winningInputView;

    public WinningController(List<Lotto> LottoTickets, Winning_InputView winningInputView) {
        this.LottoTickets = LottoTickets;
        this.winningInputView = winningInputView;
    }

    public void presentWinningLottoTickets() {
        String inputWinningNumbers = winningInputView.getInputWinningNumbers();
        Winning winning = new Winning(inputWinningNumbers);
        List<Integer> winningNumbers = winning.getWinningNumbers();
        String inputBonusNumber = winningInputView.getInputBonusNumber();

    }

}
