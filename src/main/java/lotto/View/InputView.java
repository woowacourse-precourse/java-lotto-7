package lotto.View;

import camp.nextstep.edu.missionutils.Console;
import lotto.Lotto;
import lotto.Messages.ErrorMessage;

import java.util.Arrays;
import java.util.stream.Collectors;

public class InputView {
    public static final String DELIMITER = ",";

    public static Integer readPurchaseAmount(){
        Integer purchasePrice = 0;
        try {
            String rawPurchasePrice = Console.readLine();
            purchasePrice = parseInt(rawPurchasePrice);
        }
        catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.ONLY_NUMBER.getError());
        }
        return purchasePrice;
    }

    public static Lotto readWinningNum(){
        String rawWinningInput = Console.readLine();
        return new Lotto(Arrays.asList(rawWinningInput.split(DELIMITER)).stream()
                .map(InputView::parseInt)
                .collect(Collectors.toList()));
    }

    public static Integer readBonus(Lotto answer){
        String rawBonus = Console.readLine();
        Integer bonus = parseInt(rawBonus);
        checkBonus(bonus, answer);
        checkRange(bonus);
        return bonus;
    }

    public static Integer parseInt(String input) {
        int result = 0;
        try{
            result = Integer.parseInt(input);
        }
        catch(NumberFormatException e){
            throw new IllegalArgumentException(ErrorMessage.ONLY_NUMBER.getError());
        }
        return result;
    }

    public static void checkBonus(Integer input, Lotto answer){
        if(!(answer.getNumbers().stream()
                .allMatch(number -> number != input))) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_DUPLICATE.getError());
        }
    }

    public static void checkRange(Integer input){
        if(!(input >= 1 && input <= 45)) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_RANGE.getError());
        }
    }
}
