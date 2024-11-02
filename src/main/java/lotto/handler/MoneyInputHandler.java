package lotto.handler;

import camp.nextstep.edu.missionutils.Console;

import static lotto.message.ErrorMessage.INVALID_PURCHASE_AMOUNT;

public class MoneyInputHandler {
    public long readMoney() {
        while (true){
            try {
                String inputString = Console.readLine();
                long rawMoney = Long.parseLong(inputString);
            } catch (NumberFormatException e){
                System.out.println(INVALID_PURCHASE_AMOUNT.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
