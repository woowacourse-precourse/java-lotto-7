package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) { runLottoSystem(); }

    private static void runLottoSystem() {
        Input input = new Input();
        Output output = new Output();
        Customer customer = new Customer();

        boolean isRunning = true;
        while (isRunning) {
            try {
                startLottoProcess(input, output, customer);
                isRunning = false;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.out.println("다시 시도해 주세요.");
            }
        }
    }

    private static void startLottoProcess(Input input, Output output, Customer customer) {
        output.printGetMoneyMessage();
        int money = input.getCustomerMoney();
        customer.purchaseLotto(money);
        output.printPurchaseHistory(customer);

        output.printGetWinningNumbersMessage();
        List<Integer> winningNumbers = input.getWinningNumbers();

        output.printGetBonusNumberMessage();
        int bonusNumber = input.getBonusNumber(winningNumbers);

        List<Rank> rankResult = customer.checkMyLotto(winningNumbers, bonusNumber);
        output.printWinningStatistics(rankResult);
    }
}
