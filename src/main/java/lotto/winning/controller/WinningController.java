package lotto.winning.controller;

import java.util.List;
import java.util.Map;
import lotto.common.constant.*;
import lotto.common.model.Lotto;
import lotto.dto.LottoTicketsDto;
import lotto.dto.WinningNumberDto;
import lotto.winning.CheckingWinningService;
import lotto.winning.model.*;
import lotto.winning.view.*;

public class WinningController {
    private final List<Lotto> LottoTickets;
    private final InputWinningNumberView inputWinningNumberView;
    private final OutputwinningResultView outputwinningResultView;
    private CheckingWinningService checkingWinningService;
    private final WinningNumbers winningNumbers;
    private WinningStatistics winningStatistics;

    public WinningController() {
        this.LottoTickets = LottoTicketsDto.getLottoTicketsDto().LottoTickets();
        this.inputWinningNumberView = new InputWinningNumberView();
        this.outputwinningResultView = new OutputwinningResultView();
        this.winningNumbers = new WinningNumbers();
    }

    public void presentRanksAndRates() {
        receiveWinningNumbers();
        Map<RankConstant, Integer> ranks = getRanksOfLottoTickets();
        outputwinningResultView.printRanks(ranks);
        int payment = LottoTickets.size() * 1_000;
        double rateOfReturn = winningStatistics.getRateOfWinning(ranks, payment);
        outputwinningResultView.printRateOfWinning(rateOfReturn);
    }

    private void receiveWinningNumbers() {
        try {
            String inputWinningNumbers = inputWinningNumberView.getInputWinningNumbers();
            List<Integer> validWinningNumbers = winningNumbers.getWinningNumbers(inputWinningNumbers);
            new WinningNumberDto(validWinningNumbers);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage() + "\n");
            inputWinningNumberView.setNullInputWinningNumbers();
            receiveWinningNumbers();
        }
    }

    private Map<RankConstant, Integer> getRanksOfLottoTickets() {
        List<Integer> winningNumbers = setWinningNumbers();
        int bonusNumber = setBonusNumber();
        return winningStatistics.getRanks(winningNumbers, bonusNumber, LottoTickets);
    }

    private int setBonusNumber() {
        try {
            String inputBonusNumber = inputWinningNumberView.getInputBonusNumber();
            return winningNumbers.getBonusNumber(inputBonusNumber);
        } catch (Exception exception) {
            System.out.println(exception.getMessage() + "/n");
            return setBonusNumber();
        }
    }


}
