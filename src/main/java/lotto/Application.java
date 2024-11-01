package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Application {
    private static int purchaseCost;
    private static int purchaseCount;
    private static List<Integer> winningNums;
    private static int bonusNum;
    
    public static void main(String[] args) {
        purchaseCost = getPurchaseCost();
        purchaseCount = purchaseCost / 1000;

        printGeneratedLotto();
        
        winningNums = getWinningNumbers();
        
        bonusNum = getBonusNumber();
    } 
    
    private static int getPurchaseCost() {
        return (int)getParsedUserInput(UserInputType.PURCHASE_COST);
    }
    
    private static List<Integer> getWinningNumbers() {
        return (List<Integer>)getParsedUserInput(UserInputType.WINNING_NUMBERS);
    }
    
    private static int getBonusNumber() {
        return (int)getParsedUserInput(UserInputType.BONUS_NUMBER);
    }
    
    private static Object getParsedUserInput(UserInputType inputType) {
        Object value;
        while (true) { 
            System.out.println(InputMessageFactory.getInputMessage(inputType));
            try {
                value = UserInputParser.getParsedInput(Console.readLine(), inputType);
                System.out.println();
                return value;
            }
            catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    
    private static void printGeneratedLotto() {
        System.out.println(purchaseCount + "개를 구입했습니다.");
        for (Lotto l : LottoGenerator.getLottos(purchaseCount)) {
            System.out.println(l.toString());
        }
        System.out.println();
    }
}
