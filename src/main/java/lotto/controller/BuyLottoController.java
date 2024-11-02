package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.BuyPrice;
import lotto.view.BuyPriceView;

public class BuyLottoController {
    private BuyPrice buyPrice;
    private final BuyPriceView buyPriceView;

    public BuyLottoController() {
        this.buyPriceView = new BuyPriceView();
        buyPriceView.printPriceInputView();
        this.buyPrice = new BuyPrice(Console.readLine());
    }

    public BuyLottoController(String price){
        this.buyPriceView = new BuyPriceView();
        buyPriceView.printPriceInputView();
        this.buyPrice = new BuyPrice(price);
    }

    public Integer getBuyCount() {
        return this.buyPrice.getPrice() / 1000;
    }

    public Integer getBuyPrice() {
        return this.buyPrice.getPrice();
    }

}
