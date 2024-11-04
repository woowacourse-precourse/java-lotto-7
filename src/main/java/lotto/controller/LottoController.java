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
    DrawService drawService ;
    PurchaseService purchaseService;
    CalculateService calculateService;

    public LottoController() {
        this.drawService = new DrawService();
        this.purchaseService = new PurchaseService();
        this.calculateService = new CalculateService();
    }

    public Purchase purchaseLotto() {
        int purchaseInput = InputView.getPurchaseAmount();
        return purchaseService.purchaseLotto(purchaseInput);
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
        int bonusNumberInput = InputView.getBonusNumber();
        return drawService.getBonus(bonusNumberInput, lottoNumbers);
    }

    private Lotto getLotto() {
        List<Integer> lottoNumbersInput = InputView.getLottoNumber();
        //inputView를 서비스에서도 호출하고 컨틀롤러에서도 호출하는게 이상함 리팩토링 필요
        return drawService.getLotto(lottoNumbersInput);
    }
}
