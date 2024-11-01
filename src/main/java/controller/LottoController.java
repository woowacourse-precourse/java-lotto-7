package controller;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;
import lotto.Prize;
import view.InputHandler;
import view.OutputHandler;

import java.sql.Array;
import java.util.*;

public class LottoController {
    private InputHandler inputHandler;
    private OutputHandler outputHandler;

    public LottoController() {
        this.inputHandler = new InputHandler();
        this.outputHandler = new OutputHandler();
    }

    public void run() {
        EnumMap<Prize, Integer> prizeCount = initPrizes();

        int amountInput = getInputAmount();

        int count = calculateLottoCount(amountInput);

        outputHandler.displayPurchasedLottoCount(count);

        List<Lotto> generatedLottos = generateLottos(count);

        Lotto winningLotto = generateWinningLotto();

        int bonusNumber = getInputBonusNumber(winningLotto);

        EnumMap<Prize, Integer> prizeResult = calculatePrizes(prizeCount, generatedLottos, winningLotto, bonusNumber);

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
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            lottos.add(lotto);
            System.out.println(lotto.showNumbers()); //로또 번호는 오름차순이여야함
        }
        return lottos;
    }

    private Lotto generateWinningLotto() {
        while (true) {
            try {
                outputHandler.promptForLottoNumber();
                List<Integer> lottoNumbers = inputHandler.getLottoNumber();
                Lotto winningLotto = new Lotto(lottoNumbers);
                return winningLotto;
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

    private EnumMap<Prize, Integer> calculatePrizes(EnumMap<Prize, Integer> prizeCount, List<Lotto> lottos, Lotto winningLotto, int bonusNumber) {
        for (Lotto lotto : lottos) {
            int matchCount = lotto.compareTo(winningLotto);

            for (Prize prize : Prize.values()) {
                if (matchCount == prize.getRanking()) {
                    if (lotto.hasBonusNumber(bonusNumber) && prize.equals(Prize.THIRD)) {
                        continue;
                    }

                    prizeCount.put(prize, prizeCount.get(prize) + 1);
                }
            }
        }
        return prizeCount;
    }


}
