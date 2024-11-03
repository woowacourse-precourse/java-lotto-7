package lotto.controller;

import java.util.List;
import lotto.domain.Bonus;
import lotto.domain.DrawNumbers;
import lotto.domain.Lotto;
import lotto.domain.Purchase;
import lotto.service.DrawService;
import lotto.service.PurchaseService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    DrawService drawService ;
    PurchaseService purchaseService;

    public LottoController() {
        this.drawService = new DrawService();
        this.purchaseService = new PurchaseService();
    }

    public void draw() {
        int purchaseAmount = InputView.getPurchaseAmount();
        Purchase purchase = purchaseService.purchaseLotto(purchaseAmount);

        List<Integer> lottoNumbers = InputView.getLottoNumber();
        //inputView를 서비스에서도 호출하고 컨틀롤러에서도 호출하는게 이상함 리팩토링 필요
        Lotto lotto = drawService.getLotto(lottoNumbers);

        int bonusNumber = InputView.getBonusNumber();
        Bonus bonus = drawService.getBonus(bonusNumber, lotto.getNumbers());

        DrawNumbers winningNumbers = new DrawNumbers(lotto.getNumbers(), bonus.getNumber());

        List<DrawNumbers> drawSets = purchaseService.getRandomDrawNumbersByTicketCount(purchase.getTicketCount());
        OutputView.printPurchaseLotto(drawSets);
    }
}
