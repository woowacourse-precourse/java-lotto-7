package lotto.view;

import lotto.util.Utils;

public class OutputView {
    private static OutputView outputView;

    public static OutputView getInstance() {
        if (outputView == null) {
            outputView = new OutputView();
        }
        return outputView;
    }

    public void printGuide(){
        System.out.println(Utils.Purchase_AMOUNT);
    }
}
