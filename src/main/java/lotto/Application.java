package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;


public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("구입금액을 입력해 주세요.");
        while (true) {
            String purchase = Console.readLine();
            Integer purchaseInt = Integer.parseInt(purchase);
            if (validatePurchase(purchaseInt)) {
                break;
            }
        }

        System.out.println("당첨번호를 입력해 주세요.");
        while (true) {
            String winningNum = Console.readLine();
            String winningNumber[] = winningNum.split(",");
            if (validateWinningNumber(winningNumber)) {
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

    private static boolean validateWinningNumber(String[] numbers) {
        try {
            if (numbers.length != 6) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.");
            }
            if (!checkNumbersRange(numbers)) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 1~45 사이 숫자여야 합니다.");
            }
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    private static boolean checkNumbersRange(String[] numbers) {
        for (String number : numbers) {
            if(!(Integer.parseInt(number) >= 1 && Integer.parseInt(number) <= 45)) {
                return false;
            }
        }
        return true;
    }
}
