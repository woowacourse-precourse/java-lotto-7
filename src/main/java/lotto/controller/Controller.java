package lotto.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.lotto.Lotto;
import lotto.handler.InputHandler;
import lotto.handler.PrintHandler;
import lotto.lotto.LottoStore;
import lotto.lotto.LottoWinningNumbers;

public class Controller {
    InputHandler inputHandler;
    PrintHandler printHandler;
    LottoStore lottoStore;
    List<Lotto> purchasedLottos;

    public Controller() {
        inputHandler = new InputHandler();
        printHandler = new PrintHandler();
        lottoStore = new LottoStore();
        purchasedLottos = new ArrayList<>();
    }

    public void run() {
        while (true) {
            try {
                printHandler.printBuyMoneyAmount();
                int money = inputHandler.setInputMoney();
                lottoStore.calculateNumberOfPurchases(money);
                int lottoNumberOfPurchases = lottoStore.getLottoNumberOfPurchases();
                printHandler.printBuyLottoNumbersOfPurchases(lottoNumberOfPurchases);
                createLotto(lottoNumberOfPurchases);

                printHandler.printWinningNumbersPrompt();
                List<Integer> lottoNumbers = inputHandler.setInputLottoNumbers();
                LottoWinningNumbers lottoWinningNumbers = new LottoWinningNumbers(lottoNumbers);

                printHandler.printBonusNumberPrompt();
                int bonusNumber = inputHandler.setBonusNumber();
                lottoWinningNumbers.contains(bonusNumber);

                displayResults(lottoWinningNumbers, bonusNumber, money);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void createLotto(int lottoNumberOfPurchases) {
        for (int i = 0; i < lottoNumberOfPurchases; i++) {
            List<Integer> numbers = lottoStore.createLottoNumbers();
            printHandler.printLottoNumber(numbers);
            purchasedLottos.add(new Lotto(numbers));
        }
    }

    private void displayResults(LottoWinningNumbers winningNumbers, int bonusNumber, int totalMoney) {
        Map<String, Integer> results = new HashMap<>();
        int totalEarnings = 0;

        for (Lotto lotto : purchasedLottos) {
            totalEarnings += updateResultsAndGetEarnings(lotto, winningNumbers, bonusNumber, results);
        }

        double yield = totalMoney == 0 ? 0 : ((double) totalEarnings / totalMoney) * 100;
        printHandler.printResults(results, yield);
    }

    private int updateResultsAndGetEarnings(Lotto lotto, LottoWinningNumbers winningNumbers, int bonusNumber, Map<String, Integer> results) {
        int matchCount = (int) lotto.getNumbers().stream()
                .filter(winningNumbers::contains)
                .count();

        switch (matchCount) {
            case 3:
                results.merge("3개 일치", 1, Integer::sum);
                return 5000;
            case 4:
                results.merge("4개 일치", 1, Integer::sum);
                return 50000;
            case 5:
                if (lotto.getNumbers().contains(bonusNumber)) {
                    results.merge("5개 보너스 일치", 1, Integer::sum);
                    return 30000000;
                }
                results.merge("5개 일치", 1, Integer::sum);
                return 0;
            case 6:
                results.merge("6개 일치", 1, Integer::sum);
                return 2000000000;
            default:
                return 0;
        }
    }

}
