package controller;

import lotto.Lotto;
import service.LottoManager;
import lotto.Prize;
import lotto.WinningLotto;
import view.InputHandler;
import view.OutputHandler;

import java.util.*;

public class LottoController {
    private InputHandler inputHandler;
    private OutputHandler outputHandler;
    private LottoManager lottoManager;
    private WinningLotto winningLotto;

    public LottoController() {
        this.inputHandler = new InputHandler();
        this.outputHandler = new OutputHandler();
        this.lottoManager = new LottoManager();

    }

    public void run() {
        int amountInput = getInputAmount();
        int count = calculateLottoCount(amountInput);

        outputHandler.displayPurchasedLottoCount(count);

        List<Lotto> generatedLottos = generateLottos(count);

        displayLottos(generatedLottos);

        winningLotto = generateWinningLotto();

        EnumMap<Prize, Integer> prizeResult = calculatePrizes(initPrizes(), generatedLottos, winningLotto);

        outputHandler.displayPrizes(prizeResult);

        outputHandler.displayWinningRate(calculateWinningRate(prizeResult, amountInput));


    }

    private EnumMap<Prize, Integer> initPrizes() {
        EnumMap<Prize, Integer> prizeCount = new EnumMap<>(Prize.class);
        for (Prize prize : Prize.values()) {
            prizeCount.put(prize, 0);
        }
        return prizeCount;
    }

    private double calculateWinningRate(EnumMap<Prize, Integer> prizeCount, int amountInput) {
        int winningRate = 0;
        for (Prize prize : prizeCount.keySet()) {
            winningRate += (int) (prize.getPrizeMoney() * prizeCount.get(prize));
        }
        return (double) winningRate / amountInput * 100;
    }

    private int getInputAmount() {
        while (true) {
            try {
                outputHandler.promptForAmountInput();
                return inputHandler.getAmountInput();
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }
    }


    private int calculateLottoCount(int money) {
        return money / 1000;
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

            } catch (RuntimeException e) {
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
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private EnumMap<Prize, Integer> calculatePrizes(EnumMap<Prize, Integer> prizeCount, List<Lotto> lottos, WinningLotto winningLotto) {
        for (Lotto lotto : lottos) {
            int matchCount = lotto.compareTo(winningLotto.getNumber());

            for (Prize prize : Prize.values()) {
                if (matchCount == prize.getRanking()) {
                    if (lotto.hasBonusNumber(winningLotto.getBonusNumber()) && prize.equals(Prize.THIRD)) {
                        continue;
                    }

                    prizeCount.put(prize, prizeCount.get(prize) + 1);
                }
            }
        }
        return prizeCount;
    }


}
