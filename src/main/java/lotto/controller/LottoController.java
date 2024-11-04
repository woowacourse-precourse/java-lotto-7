package lotto.controller;

import java.util.List;
import lotto.domain.Bonus;
import lotto.domain.DrawNumbers;
import lotto.domain.Lotto;
import lotto.domain.Purchase;
import lotto.service.CalculateService;
import lotto.service.DrawService;
import lotto.service.PurchaseService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    DrawService drawService;
    PurchaseService purchaseService;
    CalculateService calculateService;

    public LottoController() {
        this.drawService = new DrawService();
        this.purchaseService = new PurchaseService();
        this.calculateService = new CalculateService();
    }

    public Purchase purchaseLotto() {
        Purchase purchase = null;
        while (purchase == null) {
            try {
                int purchaseAmountNumber = InputView.getPurchaseAmount();
                purchase = purchaseService.purchaseLotto(purchaseAmountNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return purchase;
    }

    public List<DrawNumbers> drawPurchaseLotto(Purchase purchase) {
        return purchaseService.getRandomDrawNumbersByTicketCount(purchase.getTicketCount());
    }

    public DrawNumbers drawWinningLotto() {
        Lotto lotto = getLotto();
        List<Integer> lottoNumbers = lotto.getNumbers();

        Bonus bonus = getBonus(lottoNumbers);

        return new DrawNumbers(lottoNumbers, bonus.getNumber());
    }

    public void showDraw(List<DrawNumbers> randomDrawNumbers, DrawNumbers winningNumbers, Purchase purchase) {
        OutputView.printPurchaseLotto(randomDrawNumbers);

        List<Integer> prizeMoneyGroup = calculateService.calculatePrizeMoney(winningNumbers, randomDrawNumbers);
        Double profitRatio = calculateService.calculateProfitRatio(prizeMoneyGroup, purchase.getPriceAmount());

        OutputView.printPrizeMoney(prizeMoneyGroup);
        OutputView.printProfitRatio(profitRatio);
    }

    private Bonus getBonus(List<Integer> lottoNumbers) {
        Bonus bonus = null;
        while (bonus == null) {
            try {
                int bonusNumberInput = InputView.getBonusNumber();
                bonus = drawService.getBonus(bonusNumberInput, lottoNumbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return bonus;
    }

    private Lotto getLotto() {
        Lotto lotto = null;
        while (lotto == null) {
            try {
                List<Integer> lottoNumbersInput = InputView.getLottoNumber();
                lotto = drawService.getLotto(lottoNumbersInput);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return lotto;
    }
}
