package lotto.winning.controller;

import java.util.List;
import java.util.Map;
import lotto.common.constant.*;
import lotto.common.model.Lotto;
import lotto.dto.BonusNumberDto;
import lotto.dto.LottoTicketsDto;
import lotto.dto.NumberOfMatchingDto;
import lotto.dto.WinningNumberDto;
import lotto.winning.model.*;
import lotto.winning.view.*;

public class WinningController {
    private final List<Lotto> LottoTickets;
    private final InputWinningNumberView inputWinningNumberView;
    private final OutputwinningResultView outputwinningResultView;
    private final WinningNumbers winningNumbers;
    private final BonusNumber bonusNumber;

    public WinningController() {
        this.LottoTickets = LottoTicketsDto.getLottoTicketsDto().LottoTickets();
        this.inputWinningNumberView = new InputWinningNumberView();
        this.outputwinningResultView = new OutputwinningResultView();
        this.winningNumbers = new WinningNumbers();
        this.bonusNumber = new BonusNumber();
    }

    public void presentRanksAndRates() {
        receiveWinningNumbers();
        receiveBonusNumbers();
        calculateMatching();

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

    private void receiveBonusNumbers() {
        try {
            String inputBonusNumber = inputWinningNumberView.getInputBonusNumber();
            int validBonusNumber = bonusNumber.getBonusNumber(inputBonusNumber);
            new BonusNumberDto(validBonusNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage() + "\n");
            inputWinningNumberView.setNullInputBonusNumber();
            receiveBonusNumbers();
        }
    }

    private void calculateMatching() {
        MatchingBetweenWinningAndTickets matching = new MatchingBetweenWinningAndTickets();
        List<Integer> numberOfMatching = matching.getMatching();
        new NumberOfMatchingDto(numberOfMatching);
    }

    private Map<RankConstant, Integer> getRanksOfLottoTickets() {
        List<Integer> winningNumbers = setWinningNumbers();
        int bonusNumber = setBonusNumber();
        return winningStatistics.getRanks(winningNumbers, bonusNumber, LottoTickets);
    }
}
