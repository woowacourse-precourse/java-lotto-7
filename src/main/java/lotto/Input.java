package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Input {
    private static final String INPUT_DELIM = ",";

    private String inputAmount(){
        System.out.println(InputMessage.AMOUNT_INPUT_MESSAGE);
        String amount = Console.readLine();
        InputValidator.validateMoneyIsNumber(amount);

        return amount;
    }

    public Money setMoney(){
        String input = inputAmount();
        int amount = Integer.parseInt(input);

        return new Money(amount);
    }

    private String winnigNumbers(){
        System.out.println(InputMessage.NUMBER_INPUT_MESSAGE);
        String input = Console.readLine();
        InputValidator.validateNumbers(input);

        return input;
    }

    public Lotto setWinningNumbers(){
        Lotto winning = new Lotto(createWinningNumber());

        return winning;
    }

    private List<Integer> createWinningNumber(){
        String input = winnigNumbers();
        List<String> list = Arrays.asList(input.split(INPUT_DELIM));
        List<Integer> numbers = new ArrayList<>();
        for(String s : list){
            numbers.add(Integer.parseInt(s));
        }

        return numbers;
    }

}
