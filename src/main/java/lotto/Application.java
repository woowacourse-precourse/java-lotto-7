package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Application {
    private static final String QUERY_PURCHASE_COST = "구입금액을 입력해 주세요.";
    private static final String QUERY_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String QUERY_BONUS_NUMBERS = "보너스 번호를 입력해 주세요.";
    
    public static void main(String[] args) {
        getPurchaseCost();
        getWinningNumbers();
        getBonusNumber();
    }
    
    private static long getPurchaseCost() {
        while (true) { 
            System.out.println(QUERY_PURCHASE_COST);
            try {
                return UserInputParser.getPurchaseCost(Console.readLine());
            }
            catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    
    private static List<Integer> getWinningNumbers() {
        while (true) { 
            System.out.println(QUERY_WINNING_NUMBERS);
            try {
                return UserInputParser.getWinningNumbers(Console.readLine());
            }
            catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    
    private static int getBonusNumber() {
        while (true) { 
            System.out.println(QUERY_BONUS_NUMBERS);
            try {
                return UserInputParser.getBonusNumber(Console.readLine());
            }
            catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
