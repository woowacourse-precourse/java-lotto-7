package lotto.controller;

public class MainController {

    public void run() {
        AmountController amountController = new AmountController();
        int amount = amountController.inputAmount();
        System.out.println(amount);
    }

}
