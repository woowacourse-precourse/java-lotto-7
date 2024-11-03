package lotto.controller;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.Winning;
import lotto.service.CheckingWinningService;
import lotto.view.Winning_InputView;

public class WinningController {
    private final List<Lotto> LottoTickets;
    private final Winning_InputView winningInputView;
    private CheckingWinningService checkingWinningService;
    private Winning winning;

    public WinningController(List<Lotto> LottoTickets, Winning_InputView winningInputView) {
        this.LottoTickets = LottoTickets;
        this.winningInputView = winningInputView;
        checkingWinningService = new CheckingWinningService();
        winning = new Winning(checkingWinningService);
    }

    public void presentWinningLottoTickets() {
        setWinningNumbers();
        setBonusNumber();

    }

    private List<Integer> setWinningNumbers() {
        try {
            String inputWinningNumbers = winningInputView.getInputWinningNumbers();
            return winning.getWinningNumbers(inputWinningNumbers);
        } catch (Exception exception) {
            System.out.println(exception.getMessage() + "/n");
            return setWinningNumbers();
        }
    }

    private int setBonusNumber() {
        try {
            String inputBonusNumber = winningInputView.getInputBonusNumber();
            return winning.getBonusNumber(inputBonusNumber);
        } catch (Exception exception) {
            System.out.println(exception.getMessage() + "/n");
            return setBonusNumber();
        }
    }
}
