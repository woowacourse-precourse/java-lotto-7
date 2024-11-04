package lotto.winning.controller;

import java.util.List;
import java.util.Map;
import lotto.common.constant.*;
import lotto.common.model.Lotto;
import lotto.dto.LottoTicketsDto;
import lotto.winning.CheckingWinningService;
import lotto.winning.model.*;
import lotto.winning.view.*;

public class WinningController {
    private final List<Lotto> LottoTickets;
    private final InputWinningNumberView inputWinningNumberView;
    private final OutputwinningResultView outputwinningResultView;
    private CheckingWinningService checkingWinningService;
    private WinningNumber winningNumber;
    private WinningStatistics winningStatistics;

    public WinningController() {
        this.LottoTickets = LottoTicketsDto.getLottoTicketsDto().LottoTickets();
        this.inputWinningNumberView = new InputWinningNumberView();
        this.outputwinningResultView = new OutputwinningResultView();

        checkingWinningService = new CheckingWinningService();
        winningNumber = new WinningNumber();
        winningStatistics = new WinningStatistics(checkingWinningService);
    }

    public void presentRanksAndRates() {
        Map<RankConstant, Integer> ranks = getRanksOfLottoTickets();
        outputwinningResultView.printRanks(ranks);
        int payment = LottoTickets.size() * 1_000;
        double rateOfReturn = winningStatistics.getRateOfWinning(ranks, payment);
        outputwinningResultView.printRateOfWinning(rateOfReturn);
    }

    private Map<RankConstant, Integer> getRanksOfLottoTickets() {
        List<Integer> winningNumbers = setWinningNumbers();
        int bonusNumber = setBonusNumber();
        return winningStatistics.getRanks(winningNumbers, bonusNumber, LottoTickets);
    }

    private List<Integer> setWinningNumbers() {
        try {
            String inputWinningNumbers = inputWinningNumberView.getInputWinningNumbers();
            return winningNumber.getWinningNumbers(inputWinningNumbers);
        } catch (Exception exception) {
            System.out.println(exception.getMessage() + "/n");
            return setWinningNumbers();
        }
    }

    private int setBonusNumber() {
        try {
            String inputBonusNumber = inputWinningNumberView.getInputBonusNumber();
            return winningNumber.getBonusNumber(inputBonusNumber);
        } catch (Exception exception) {
            System.out.println(exception.getMessage() + "/n");
            return setBonusNumber();
        }
    }


}
