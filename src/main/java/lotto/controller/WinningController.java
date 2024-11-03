package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.model.Lotto;
import lotto.model.WinningNumber;
import lotto.model.WinningStatistics;
import lotto.service.CheckingWinningService;
import lotto.view.Winning_InputView;

public class WinningController {
    private final List<Lotto> LottoTickets;
    private final Winning_InputView winningInputView;
    private CheckingWinningService checkingWinningService;
    private WinningNumber winningNumber;
    private WinningStatistics winningStatistics;

    public WinningController(List<Lotto> LottoTickets, Winning_InputView winningInputView) {
        this.LottoTickets = LottoTickets;
        this.winningInputView = winningInputView;
        checkingWinningService = new CheckingWinningService();
        winningNumber = new WinningNumber();
        winningStatistics = new WinningStatistics(checkingWinningService);
    }

    public void presentWinningLottoTickets() {
        List<Integer> winningNumbers = setWinningNumbers();
        int bonusNumber = setBonusNumber();
        Map<Integer, Integer> ranks = winningStatistics.getRanks(winningNumbers, bonusNumber, LottoTickets);
    }

    private List<Integer> setWinningNumbers() {
        try {
            String inputWinningNumbers = winningInputView.getInputWinningNumbers();
            return winningNumber.getWinningNumbers(inputWinningNumbers);
        } catch (Exception exception) {
            System.out.println(exception.getMessage() + "/n");
            return setWinningNumbers();
        }
    }

    private int setBonusNumber() {
        try {
            String inputBonusNumber = winningInputView.getInputBonusNumber();
            return winningNumber.getBonusNumber(inputBonusNumber);
        } catch (Exception exception) {
            System.out.println(exception.getMessage() + "/n");
            return setBonusNumber();
        }
    }

}
