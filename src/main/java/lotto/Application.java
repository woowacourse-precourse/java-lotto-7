package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        getPurchaseCost();
        getWinningNumbers();
        getBonusNumber();
    } 
    
    private static long getPurchaseCost() {
        return (long)getParsedUserInput(UserInputType.PURCHASE_COST);
    }
    
    private static List<Integer> getWinningNumbers() {
        return (List<Integer>)getParsedUserInput(UserInputType.WINNING_NUMBERS);
    }
    
    private static int getBonusNumber() {
        return (int)getParsedUserInput(UserInputType.BONUS_NUMBER);
    }
    
    private static Object getParsedUserInput(UserInputType inputType) {
        while (true) { 
            System.out.println(InputMessageFactory.getInputMessage(inputType));
            try {
                return UserInputParser.getParsedInput(Console.readLine(), inputType);
            }
            catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
