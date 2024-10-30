package lotto;

public class LottoMachine {

    public void run() {
        Budget budget = inputBudget();
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
