package lotto.winning.controller;

import java.util.List;
import java.util.Map;
import lotto.common.constant.*;
import lotto.dto.BonusNumberDto;
import lotto.dto.NumberOfMatchingDto;
import lotto.dto.WinningNumberDto;
import lotto.winning.model.*;
import lotto.winning.view.*;

public class WinningController {
    private final InputWinningNumberView inputWinningNumberView;
    private final OutputWinningResultView outputwinningResultView;
    private final WinningNumbers winningNumbers;
    private final BonusNumber bonusNumber;

    public WinningController() {
        this.inputWinningNumberView = new InputWinningNumberView();
        this.outputwinningResultView = new OutputWinningResultView();
        this.winningNumbers = new WinningNumbers();
        this.bonusNumber = new BonusNumber();
    }

    public void presentRanksAndRates() {
        receiveWinningNumbers();
        receiveBonusNumbers();
        calculateMatching();
        generateWinningStatics();
    }

    private void receiveWinningNumbers() {
        try {
            String inputWinningNumbers = inputWinningNumberView.getInputWinningNumbers();
            List<Integer> validWinningNumbers = winningNumbers.getWinningNumbers(inputWinningNumbers);
            WinningNumberDto.set(validWinningNumbers);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage() + "\n");
            inputWinningNumberView.setNullInputWinningNumbers();
            receiveWinningNumbers();
        }
    }

    private void receiveBonusNumbers() {
        try {
            String inputBonusNumber = inputWinningNumberView.getInputBonusNumber();
            int validBonusNumber = bonusNumber.getBonusNumber(inputBonusNumber);
            BonusNumberDto.set(validBonusNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage() + "\n");
            inputWinningNumberView.setNullInputBonusNumber();
            receiveBonusNumbers();
        }
    }

    private void calculateMatching() {
        MatchingBetweenWinningAndTickets matching = new MatchingBetweenWinningAndTickets();
        List<Integer> numberOfMatching = matching.getMatching();
        NumberOfMatchingDto.set(numberOfMatching);
    }

    private void generateWinningStatics() {
        WinningStatistics winningStatistics = new WinningStatistics();
        Map<RankConstant, Integer> ranks = winningStatistics.getRanksOfLottoTickets();
        double rateOfReturn = winningStatistics.getRateOfReturn();

        outputwinningResultView.printRanksOfLottoTickets(ranks);
        outputwinningResultView.printRateOfReturn(rateOfReturn);
    }
}
