package lotto.controller;

import lotto.model.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Controller {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    private int chooseNumberOfLottoContinuously(ProfitCalculator profitCalculator,LottoCreator lottoCreator) {
        int numberOfLotto;
        int purchasePrice;
        while (true) {
            purchasePrice = inputView.inputPurchasePrice();
            numberOfLotto = lottoCreator.chooseNumberOfLotto(purchasePrice);
            if (numberOfLotto != LottoCreator.INITIAL_NUMBER_OF_LOTTO) break;
        }
        profitCalculator.settingPurchasePrice(purchasePrice);
        return numberOfLotto;
    }

    private List<Lotto> purchaseLottos(ProfitCalculator profitCalculator) {
        LottoCreator lottoCreator = new LottoCreator();
        int numberOfLotto = chooseNumberOfLottoContinuously(profitCalculator, lottoCreator);
        Lottos lottos = new Lottos(numberOfLotto);
        outputView.outputNumberOfLotto(numberOfLotto);
        List<Lotto> lottoTickets = lottos.getLottoTickets();
        outputView.outputLottos(lottoTickets);
        return lottoTickets;
    }

    private static List<Integer> convertToInteger(String winningNumber) {
        return Arrays.stream(winningNumber.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private WinningLotto createWinningLotto() {
        while (true) {
            try {
                String winningNumbersBeforeConvert = inputView.inputWinningNumbers();
                List<Integer> winningNumbers = convertToInteger(winningNumbersBeforeConvert);
                WinningLotto winningLotto = new WinningLotto(winningNumbers);
                int bonusNumber = inputView.inputBonusNumber();
                winningLotto.settingBonusNumber(bonusNumber);
                return winningLotto;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void printStatistics(List<Lotto> lottoTickets, List<Integer> winningNumbers, int bonusBallNumber, ProfitCalculator profitCalculator) {
        OutputView outputView = new OutputView();
        profitCalculator.calculateRankCount(lottoTickets, winningNumbers, bonusBallNumber);
        profitCalculator.calculateProfit();
        outputView.outputStatistics(profitCalculator.getRankCounts(), profitCalculator.getProfitRate());
    }

    public void runLotto() {
        ProfitCalculator profitCalculator = new ProfitCalculator();
        List<Lotto> lottoTickets = purchaseLottos(profitCalculator);
        WinningLotto winningLotto = createWinningLotto();
        List<Integer> winningNumbers = winningLotto.getWinningNumbers();
        int bonusBallNumber = winningLotto.getBonusNumber();
        printStatistics(lottoTickets, winningNumbers, bonusBallNumber, profitCalculator);
    }
}
