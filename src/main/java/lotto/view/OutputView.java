package lotto.view;

import lotto.Lotto;
import lotto.constant.OutputMessage;

import java.util.List;

public class OutputView {

    public void printPurchaseGuide() {
        System.out.println(OutputMessage.PURCHASE_GUIDE.getMessage());
    }

    public void printPurchaseAmount(int amount) {
        System.out.println(String.format(OutputMessage.PURCHASE_AMOUNT.getMessage(), amount));
    }

    public void printLotto(List<Lotto> lottoes) {
        lottoes.forEach(lotto -> System.out.println(lotto.getScreen()));
    }
}
