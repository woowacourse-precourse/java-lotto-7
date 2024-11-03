package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class LottoInput {

    public static int getValidPurchasePrice() {
        while (true) {
            try {
                int purchasePrice = getParseInt(Console.readLine());
                if (purchasePrice < 1000 || purchasePrice % 1000 != 0) {
                    throw new IllegalArgumentException("[ERROR] 구매 금액은 1000이상, 1000원 단위여야 합니다.");
                }
                return purchasePrice;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.out.println("구입금액을 입력해 주세요.");
            }
        }
    }

    public static List<Integer> getValidWinningNo() {
        while (true) {
            try {
                int[] numbers = getIntArray(split(Console.readLine()));
                validLotto(numbers);
                List<Integer> winningNumber = new ArrayList<>();
                for (int number : numbers) {
                    winningNumber.add(number);
                }
                return winningNumber;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.out.println("\n당첨 번호를 입력해 주세요.");
            }
        }
    }

    public static int getValidBonus(List<Integer> winningNumber) {
        while (true) {
            try {
                int bonus = getParseInt(Console.readLine());
                if (winningNumber.contains(bonus)) {
                    throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복 될수 없습니다.");
                }
                return bonus;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.out.println("\n보너스 번호를 입력해 주세요.");
            }
        }
    }

    private static int getParseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해 주세요");
        }
    }


    private static void validLotto(int[] numbers) {
        for (int number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 1 ~ 45 사이의 숫자를 입력해주세요!");
            }
        }
    }

    private static int[] getIntArray(String[] input) {
        int[] number = new int[input.length];
        for (int i = 0; i < number.length; i++) {
            number[i] = getParseInt(input[i]);
        }
        return number;
    }

    private static String[] split(String input) {
        return input.split(",");
    }

}
