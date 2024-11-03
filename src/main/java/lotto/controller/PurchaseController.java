package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.processor.Processor;
import lotto.processor.PurchaseProcessor;
import lotto.service.PurchaseService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class PurchaseController {
    private final PurchaseService purchaseService;

    public PurchaseController(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    public Money purchaseLottos(){
        int price = getPrice();
        System.out.println();
        Money money = new Money(price);
        List<Lotto> lottos = purchaseService.purchase(money);
        OutputView.printPurchased(money, lottos);
        return money;
    }

    private int getPrice(){
        Processor<Integer> purchaseProcessor = new PurchaseProcessor();
        return purchaseProcessor.process();


    }


}
