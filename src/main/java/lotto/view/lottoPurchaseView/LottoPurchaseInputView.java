package lotto.view.lottoPurchaseView;

import lotto.util.NumberConverter;
import lotto.validator.LottoPurchasePriceValidator;
import lotto.view.InputProvider;
import lotto.view.RepeatInput;

public class LottoPurchaseInputView{

    private final InputProvider inputProvider;
    private final NumberConverter numberConverter;

    public LottoPurchaseInputView(InputProvider inputProvider, NumberConverter numberConverter){
        this.inputProvider = inputProvider;
        this.numberConverter = numberConverter;
    }

    public int getPurchasePrice(){
        System.out.println("구입금액을 입력해 주세요.");
        return RepeatInput.getValidInput(() -> {
            String input = inputProvider.getInput();
            int purchasePrice = numberConverter.convertNumber(input);
            LottoPurchasePriceValidator.validateLottoPurchasePrice(purchasePrice);
            return purchasePrice;
        });
    }

}
