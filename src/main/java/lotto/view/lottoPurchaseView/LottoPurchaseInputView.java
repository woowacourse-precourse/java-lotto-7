package lotto.view.lottoPurchaseView;

import lotto.util.DefaultNumberConverter;
import lotto.view.InputProvider;

public class LottoPurchaseInputView{

    private final InputProvider inputProvider;
    private final DefaultNumberConverter numberConverter;

    public LottoPurchaseInputView(InputProvider inputProvider, DefaultNumberConverter numberConverter){
        this.inputProvider = inputProvider;
        this.numberConverter = numberConverter;
    }

    public int getLottoPurchasePrice(){
        System.out.println("구입금액을 입력해 주세요.");
        return numberConverter.convertNumber(inputProvider.getInput());
    }

}
