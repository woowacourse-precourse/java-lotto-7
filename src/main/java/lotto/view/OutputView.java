package lotto.view;

import java.util.List;
import lotto.domain.Lotto;
import lotto.util.message.PromptMessage;

public class OutputView {

    private static OutputView outputView;

    private OutputView(){
    }

    public static OutputView getInstance() {
        if (outputView == null) {
            outputView = new OutputView();
        }
        return outputView;
    }

    public void displayLottoList(int purchaseAmount, List<Lotto> lottoList) {
        System.out.println();
        System.out.println(purchaseAmount + PromptMessage.LOTTO_AMOUNT_MESSAGE);
        lottoList.forEach(Lotto::displayNumbers);
        System.out.println();
    }

    public void close() {
        if (outputView != null) {
            outputView = null;
        }
    }
}
