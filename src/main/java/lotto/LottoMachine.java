package lotto;

import java.util.List;

public class LottoMachine {

    private static final int LOTTO_PRICE = 1000;

    private List<Lotto> purchasedLotto;

    public void run() {
        Budget budget = inputBudget();
        int lottoQuantity = budget.getAmount() / LOTTO_PRICE;
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
}
