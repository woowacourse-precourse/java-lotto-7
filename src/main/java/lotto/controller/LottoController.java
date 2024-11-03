package lotto.controller;

import lotto.domain.input.InputValidator;
import lotto.domain.lotto.Lotto;
import lotto.domain.prize.PrizeSystem;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoController {

    private static final int PURCHASE_MIN_UNIT = 1000;

    private List<Lotto> lottos = new ArrayList<>();
    private PrizeSystem prizeSystem;

    private int purchaseMoney;
    private List<Integer> prizeNumbers;
    private int bonusNumber;

    /**
     * 컨트롤러 실행
     */
    public void start() {
        getPurchaseMoney();
        generateLotto();
        OutputView.printMyLottos(lottos);

        getPrizeNumberAndBonusNumber();
        prizeSystem = new PrizeSystem(prizeNumbers, bonusNumber);
        prizeSystem.checkPrizeResult(lottos);

        OutputView.printPrizeResult(prizeSystem.getPrizeCount());
        OutputView.printProfit(prizeSystem.getProfit(purchaseMoney));
    }

    /**
     * 사용자로부터 구입 금액 입력 받기
     */
    public void getPurchaseMoney() {
        purchaseMoney = InputValidator.getValidPurchaseMoney();
    }

    /**
     * 구입 금액만큼 로또 발행
     */
    public void generateLotto() {
        int size = purchaseMoney / PURCHASE_MIN_UNIT;
        for (int i = 0; i < size; i++) {
            List<Integer> lottoNumber = Lotto.generateLottoNumber();
            List<Integer> sortedLottoNumbers = Lotto.sortNumbers(lottoNumber);
            lottos.add(new Lotto(sortedLottoNumbers));
        }
    }

    /**
     * 당첨 번호 및 보너스 번호를 입력 받기
     */
    public void getPrizeNumberAndBonusNumber() {
        prizeNumbers = InputValidator.getValidPrizeNumber();
        bonusNumber = InputValidator.getValidBonusNumber(prizeNumbers);
    }
}
