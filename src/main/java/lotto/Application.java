package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    private static final String QUERY_PURCHASE_COST = "구입금액을 입력해 주세요.";
    
    public static void main(String[] args) {
        getPurchaseCost();
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
}
