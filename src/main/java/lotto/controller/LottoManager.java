package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.model.BonusLotto;
import lotto.model.Lotto;
import lotto.model.Result;
import lotto.util.NumberParser;
import lotto.model.Price;
import lotto.model.PurchasedLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoManager {

    public LottoManager() {
        startLotto();
    }

    public void startLotto() {
        InputView inputView = new InputView();
        Price money = null;

        // 구입 금액 입력 받기
        while (money == null) {
            try {
                int price = NumberParser.stringToInt(inputView.price());
                money = new Price(price);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        randomLotto(money.getPrice());

        List<Integer> lottoNumbers = new ArrayList<>();
        boolean validWinningNumbers = false;

        // 당첨 번호 입력 받기
        while (!validWinningNumbers) {
            try {
                String[] winningNum = inputView.winningNumber().split(",");
                for (String num : winningNum) {
                    lottoNumbers.add(NumberParser.stringToInt(num));
                }
                new Lotto(lottoNumbers);
                validWinningNumbers = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                lottoNumbers.clear();
            }
        }

        int bonusNum = 0;
        boolean validBonusNumber = false;

        // 보너스 번호 입력 받기
        while (!validBonusNumber) {
            try {
                bonusNum = NumberParser.stringToInt(inputView.bonusNumber());
                new BonusLotto(bonusNum).bonusDuplicate(bonusNum, lottoNumbers);
                validBonusNumber = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        ResultJudging resultJudging = new ResultJudging();
        PurchasedLotto purchasedLotto = PurchasedLotto.getInstance();

        Result result = resultJudging.lottoResult(
                purchasedLotto.getPurchasedLotto(),
                lottoNumbers,
                bonusNum
        );

        OutputView outputView = new OutputView();
        outputView.printRanks(result);
        outputView.printReturnRate(resultPrint(money.getPrice(), result));
    }

    public void randomLotto(int money) {
        int count = money / 1000;
        OutputView outputView = new OutputView();
        outputView.count(count);

        PurchasedLotto purchasedLotto = PurchasedLotto.getInstance();
        for (int i = 0; i < count; i++) {
            List<Integer> lottoNumbers = RandomLotto.generateRandomLotto();
            outputView.printLotto(lottoNumbers);
            purchasedLotto.addPurchasedLotto(lottoNumbers);
        }
    }

    public double resultPrint(int price, Result result){
        ResultJudging resultJudging = new ResultJudging();
        return resultJudging.returnRate(price, result);
    }
}
