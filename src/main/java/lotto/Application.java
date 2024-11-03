package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    	System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        validatePurchaseAmount(Integer.parseInt(input));
    }

    private static void validatePurchaseAmount(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위여야 합니다.");
        }
    
    }
}
