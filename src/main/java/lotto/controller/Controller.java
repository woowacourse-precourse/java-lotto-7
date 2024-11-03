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

    private int chooseNumberOfLottoContinuously(){
        LottoCreator lottoCreator = new LottoCreator();
        int numberOfLotto;
        int purchasePrice;
        while (true) {
            purchasePrice = inputView.inputPurchasePrice();
            numberOfLotto = lottoCreator.chooseNumberOfLotto(purchasePrice);
            if (numberOfLotto != LottoCreator.INITIAL_NUMBER_OF_LOTTO) break;
        }
        ProfitCalculator profitCalculator = new ProfitCalculator();
        profitCalculator.settingPurchasePrice(purchasePrice);
        return numberOfLotto;
    }

    private List<Lotto> purchaseLottos() {
        int numberOfLotto = chooseNumberOfLottoContinuously();
        Lottos lottos = new Lottos(numberOfLotto);
        outputView.outputNumberOfLotto(numberOfLotto);
        List<Lotto> lottoTickets = lottos.getLottoTickets();
        outputView.outputLottos(lottoTickets);
        return lottoTickets;
    }

    private static List<Integer> convertToIntegerList(String winningNumber) {
        return Arrays.stream(winningNumber.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private WinningLotto createWinningLotto(){
        String winningNumbersBeforeConvert = inputView.inputWinningNumbers();
        List<Integer> winningNumbers = convertToIntegerList(winningNumbersBeforeConvert);
        WinningLotto winningLotto = new WinningLotto(winningNumbers);
        int bonusNumber = inputView.inputBonusNumber();
        winningLotto.settingBonusNumber(bonusNumber);
        return winningLotto;
    }

    public void printStatistics(){
        ProfitCalculator profitCalculator = new ProfitCalculator();
        List<Lotto> lottoTickets = purchaseLottos();
        List<Integer> winningNumbers = createWinningLotto().getWinningNumbers();
        int bonusBallNumber = createWinningLotto().getBonusNumber();
        profitCalculator.calculateRankCount(lottoTickets, winningNumbers, bonusBallNumber);
        profitCalculator.calculateProfit();
    }
}
