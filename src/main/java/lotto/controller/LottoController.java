package lotto.controller;


import java.util.function.Supplier;
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
        int lottoPurchasePrice = retry(this::requestLottoPurchasePrice);
        System.out.println(lottoPurchasePrice);
    }


    private int requestLottoPurchasePrice(){
        String lottoPurchasePrice = lottoView.requestLottoPurchasePrice();
        lottoPurchasePriceValidator.validateLottoPurchasePrice(lottoPurchasePrice);
        return LottoParser.parseInt(lottoPurchasePrice);
    }

    private <T> T retry(Supplier<T> logic){
        boolean runFlag = true;
        T result = null;
        while (runFlag){
            try {
                result = logic.get();
                runFlag = false;
            }
            catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
        return result;
    }
}
