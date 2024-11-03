package lotto.controller;

import lotto.domain.*;
import lotto.dto.LottosDto;
import lotto.dto.WinningResultDto;
import lotto.common.factory.LottoFactory;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.Arrays;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        inputView.requestPurchaseAmount();
        Cost cost = initCost();
        Lottos lottos = LottoFactory.sizeFrom(calculateSize(cost));
        outputView.printPurchaseOverview(new LottosDto(lottos));

        DrawnNumbers drawnNumbers = initDrawnNumbers();
        Buyer buyer = new Buyer(cost, lottos);
        buyer.recordTotalScore(drawnNumbers);
        outputView.printWinningResult(new WinningResultDto(buyer.getScoreBoard(), buyer.calculateReturnRate()));
    }

    private int calculateSize(Cost cost) {
        return cost.getCost() / 1000;
    }

    private DrawnNumbers initDrawnNumbers() {
        inputView.requestWinningNumber();
        WinningNumbers winningNumbers = makeWinningNumbers();

        inputView.requestBonusNumber();
        return makeDrawnNumbers(winningNumbers);
    }

    private DrawnNumbers makeDrawnNumbers(WinningNumbers winningNumbers) {
        try {
            BonusNumber bonusNumber = new BonusNumber(inputView.getInput());
            return new DrawnNumbers(winningNumbers, bonusNumber);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e);
            return makeDrawnNumbers(winningNumbers);
        }
    }

    private WinningNumbers makeWinningNumbers() {
        try {
            String input = inputView.getInput();
            return new WinningNumbers(Arrays.stream(input.split(","))
                    .toList());
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e);
            return makeWinningNumbers();
        }
    }

    private Cost initCost() {
        try {
            return new Cost(inputView.getInput());
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e);
            return initCost();
        }
    }
}
