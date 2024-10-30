package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {

    private static final int LOTTO_PRICE = 1000;

    private List<Lotto> purchasedLotto;

    public LottoMachine() {
        purchasedLotto = new ArrayList<>();
    }

    public void run() {
        Budget budget = inputBudget();
        int lottoQuantity = budget.getAmount() / LOTTO_PRICE;
        purchaseLotto(lottoQuantity);
        OutputView.displayPurchasedLottoNumbers(purchasedLotto);
    }

    private Budget inputBudget() {
        while (true) {
            try {
                return new Budget(InputView.readBudget());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void purchaseLotto(int lottoQuantity) {
        for (int i = 0; i < lottoQuantity; i++) {
            List<Integer> numbers = LottoNumbersGenerator.generate();
            purchasedLotto.add(new Lotto(numbers));
        }
    }
}
