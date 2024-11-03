package lotto.controller;

import lotto.constant.Constants;
import lotto.model.Lotto;
import lotto.service.LottoManager;
import lotto.model.Prize;
import lotto.model.WinningLotto;
import lotto.service.PrizeCalculator;
import lotto.view.InputHandler;
import lotto.view.OutputHandler;

import java.util.*;

public class LottoController {
    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;
    private final LottoManager lottoManager;
    private WinningLotto winningLotto;
    private final PrizeCalculator prizeCalculator;

    public LottoController(InputHandler inputHandler, OutputHandler outputHandler, LottoManager lottoManager, PrizeCalculator prizeCalculator) {
        this.inputHandler = inputHandler;
        this.outputHandler = outputHandler;
        this.lottoManager = lottoManager;
        this.prizeCalculator = prizeCalculator;

    }

    public void run() {
        int amountInput = getInputAmount();
        int count = calculateLottoCount(amountInput);

        outputHandler.displayPurchasedLottoCount(count);

        List<Lotto> generatedLottos = generateLottos(count);

        displayLottos(generatedLottos);

        winningLotto = generateWinningLotto();

        EnumMap<Prize, Integer> prizeResult = calculatePrizes(generatedLottos, winningLotto);

        outputHandler.displayPrizes(prizeResult);

        outputHandler.displayWinningRate(calculateWinningRate(amountInput));


    }



    private double calculateWinningRate(int amountInput) {
        return prizeCalculator.calculateWinningRate(amountInput);
    }

    private int getInputAmount() {
        while (true) {
            try {
                outputHandler.promptForAmountInput();
                return inputHandler.getAmountInput();

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }


    private int calculateLottoCount(int money) {
        return money / Constants.THOUSAND_UNIT;
    }

    private List<Lotto> generateLottos(int count) {

        lottoManager.buyLottos(count);

        return lottoManager.getLottos();

    }

    private void displayLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            outputHandler.showLottos(lotto.getNumbers());
        }
    }

    private WinningLotto generateWinningLotto() {
        while (true) {
            try {
                outputHandler.promptForLottoNumber();
                List<Integer> lottoNumbers = inputHandler.getLottoNumber();
                Lotto winningLottoWithoutBonusNumber = lottoManager.generateLottoWithNumbers(lottoNumbers);
                int bonusNumber = getInputBonusNumber(winningLottoWithoutBonusNumber);
                return new WinningLotto(winningLottoWithoutBonusNumber, bonusNumber);

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int getInputBonusNumber(Lotto winningLotto) {
        while (true) {
            try {
                outputHandler.promptForBonusNumber();
                List<Integer> winningLottoNumbers = winningLotto.getNumbers();
                return inputHandler.getBonusNumber(winningLottoNumbers);
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    private EnumMap<Prize, Integer> calculatePrizes(List<Lotto> lottos, WinningLotto winningLotto) {
        prizeCalculator.calculatePrizes(lottos, winningLotto);

        return prizeCalculator.getPrizeCount();
    }

}
