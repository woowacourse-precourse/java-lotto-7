package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    private String inputAmount(){
        System.out.println(InputMessage.AMOUNT_INPUT_MESSAGE);
        String amount = Console.readLine();
        InputValidator.validateIsNumber(amount);

        return amount;
    }

    public Money setMoney(){
        String input = inputAmount();
        int amount = Integer.parseInt(input);

        return new Money(amount);
    }

}
