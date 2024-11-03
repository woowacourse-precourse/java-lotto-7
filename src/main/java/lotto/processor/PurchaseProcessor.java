package lotto.processor;

import lotto.view.InputView;

public class PurchaseProcessor extends Processor<Integer>{
    private static final int DIVISABLE_PRICE = 1000;
    private static final String ERROR = "[ERROR] ";
    private static final String NOT_DIVISABLE = ERROR + "구입 금액은 1000원으로 나누어 떨어져야 합니다.";
    @Override
    protected Integer getInput() {
        return InputView.getPurchasePrice();
    }

    @Override
    protected void validate(Integer input) {
        if (input % DIVISABLE_PRICE != 0){
            throw new IllegalArgumentException(NOT_DIVISABLE);
        }
    }
}
