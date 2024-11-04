package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Input {
    private static final String INPUT_DELIM = ",";

    private static String inputAmount(){
        System.out.println(InputMessage.AMOUNT_INPUT_MESSAGE.getMessage());
        String amount = Console.readLine();
        InputValidator.validateMoneyIsNumber(amount);

        return amount;
    }

    public static Money setMoney(){
        String input = inputAmount();
        int amount = Integer.parseInt(input);

        return new Money(amount);
    }

    private static String winnigNumbers(){
        System.out.println(InputMessage.NUMBER_INPUT_MESSAGE.getMessage());
        String input = Console.readLine();
        InputValidator.validateNumbers(input);

        return input;
    }

    public static Lotto setWinningNumbers(){
        String input = winnigNumbers();
        List<Integer> numbers = new ArrayList<>();
        for(String s : input.split(INPUT_DELIM)){
            numbers.add(Integer.parseInt(s));
        }

        return new Lotto(numbers);
    }


    private static String bonusNumbers(){
        System.out.println(InputMessage.BONUS_INPUT_MESSAGE.getMessage());
        String input = Console.readLine();
        InputValidator.validateBonus(input);

        return input;
    }

    public static Integer setBonusNumber(){
        return Integer.parseInt(bonusNumbers());
    }

}
