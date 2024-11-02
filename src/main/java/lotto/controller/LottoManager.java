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

        int price = NumberParser.stringToInt(inputView.price()); // 구입금액 입력 받기
        Price money = new Price(price); // 검사 후 저장

        randomLotto(money.getPrice()); // 금액에 맞게 로또 발행

        List<Integer> lottoNumbers = new ArrayList<>();
        String[] winningNum = inputView.winningNumber().split(","); // 당첨번호 입력 받기
        for (String num : winningNum) {
            lottoNumbers.add(NumberParser.stringToInt(num)); // 정수로 변환 후 List로 전달
        }
        Lotto lotto = new Lotto(lottoNumbers); // 당첨번호 검사 후 저장

        int bonusNum = NumberParser.stringToInt(inputView.bonusNumber()); // 보너스 번호 입력 받기
        BonusLotto bonusLotto = new BonusLotto(bonusNum); // 보너스번호 숫자 범위 검사 후 저장
        bonusLotto.bonusDuplicate(bonusNum, lotto.getLottoNumbers()); // 중복 검사

        ResultJudging resultJudging = new ResultJudging();
        PurchasedLotto purchasedLotto = PurchasedLotto.getInstance();

        Result result = resultJudging.lottoResult(
                purchasedLotto.getPurchasedLotto(),
                lotto.getLottoNumbers(),
                bonusLotto.getBonusNumber()
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
