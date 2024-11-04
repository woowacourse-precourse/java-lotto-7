package lotto;

import lotto.service.Purchase;
import lotto.view.input.Input;
import lotto.view.output.Output;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        Input input = new Input();
        Output output = new Output();

        Purchase purchase = new Purchase(input.purchaseAmount());

        output.getLottoNumbers(purchase.getPurchaseAccount());


    }
}
