package lotto.view.lottoPurchaseView;

import lotto.exception.LottoException;
import lotto.model.lotto.LottoConstant;
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

    public int getAge(){
        System.out.println("구매자님의 나이를 입력해 주세요.");
        int age = numberConverter.convertNumber(inputProvider.getInput());
        validateAge(age);
        return age;
    }

    private void validateAge(int age){
        if (age < LottoConstant.MINIMUM_LOTTO_PURCHASE_AGE){
            throw new IllegalArgumentException(LottoException.UNDER_MINIMUM_PURCHASE_AMOUNT.getMessage());
        }
        if (age > LottoConstant.MAXIMUM_LOTTO_PURCHASE_AGE){
            throw new IllegalArgumentException(LottoException.EXCEED_MINIMUM_PURCHASE_AGE.getMessage());
        }
    }

}
