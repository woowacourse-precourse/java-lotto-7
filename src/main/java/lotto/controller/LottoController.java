package lotto.controller;

import java.util.List;
import lotto.domain.Bonus;
import lotto.domain.Lotto;
import lotto.domain.PurchaseAmount;
import lotto.service.DrawService;
import lotto.service.PurchaseAmountService;
import lotto.view.InputView;

public class LottoController {
    DrawService drawService ;
    PurchaseAmountService purchaseAmountService ;

    public LottoController() {
        this.drawService = new DrawService();
    }

    public void draw() {
        int purchaseAmount = InputView.getPurchaseAmount();
        PurchaseAmount purchaseAmountService.getPurchaseAmount(purchaseAmount);

        List<Integer> lottoNumbers = InputView.getLottoNumber();
        //inputView를 서비스에서도 호출하고 컨틀롤러에서도 호출하는게 이상함 리팩토링 필요
        Lotto lotto = drawService.getLotto(lottoNumbers);

        int bonusNumber = InputView.getBonusNumber();
        Bonus bonus = drawService.getBonus(bonusNumber, lotto.getNumbers());
    }
}
