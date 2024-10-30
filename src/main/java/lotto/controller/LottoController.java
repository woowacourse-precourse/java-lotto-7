package lotto.controller;

import lotto.util.LottoParser;
import lotto.validator.LottoPurchasePriceValidator;
import lotto.view.LottoView;

public class LottoController {

    private final LottoView lottoView;
    private final LottoPurchasePriceValidator lottoPurchasePriceValidator;

    public LottoController(LottoView lottoView, LottoPurchasePriceValidator lottoPurchasePriceValidator){
        this.lottoView = lottoView;
        this.lottoPurchasePriceValidator = lottoPurchasePriceValidator;
    }

    public void run(){
        int lottoPurchasePrice = requestLottoPurchasePrice();

    }


    private int requestLottoPurchasePrice(){
        String lottoPurchasePrice = lottoView.requestLottoPurchasePrice();
        lottoPurchasePriceValidator.validateLottoPurchasePrice(lottoPurchasePrice);
        return LottoParser.parseInt(lottoPurchasePrice);
    }
}
