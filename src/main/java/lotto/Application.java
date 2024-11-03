package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;


public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("구입금액을 입력해 주세요.");
        while (true) {
            String purchase = Console.readLine();
            if (validatePurchase(Integer.parseInt(purchase))) {
                break;
            }
        }



    }

    private static boolean validatePurchase(Integer numbers) {
        try {
            if (numbers % 1000 != 0) {
                throw new IllegalArgumentException("[ERROR] 금액은 천 원 단위여야 합니다.");
            }
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
}
