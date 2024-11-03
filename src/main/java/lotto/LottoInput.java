package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class LottoInput {

    public static final int LOTTO_UNIT = 1000;
    public static final int LOTTO_START = 1;
    public static final int LOTTO_END = 45;

    public static int getValidPurchasePrice() {
        while (true) {
            try {
                int purchasePrice = parsePrice(Console.readLine());
                validatePrice(purchasePrice);
                return purchasePrice;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.out.println("구입금액을 입력해 주세요.");
            }
        }
    }

    public static void validatePrice(int purchasePrice) {
        if (purchasePrice < LOTTO_UNIT || purchasePrice % LOTTO_UNIT != 0) {
            throw new IllegalArgumentException("[ERROR] 구매 금액은 1000이상, 1000원 단위여야 합니다.");
        }
    }

    public static List<Integer> getValidWinningNo() {
        while (true) {
            try {
                List<Integer> winningNumber = getWinningNumber();
                validLotto(winningNumber);
                return winningNumber;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.out.println("\n당첨 번호를 입력해 주세요.");
            }
        }
    }

    public static List<Integer> getWinningNumber() {
        int[] numbers = getIntArray(split(Console.readLine()));
        List<Integer> winningNumber = new ArrayList<>();
        for (int number : numbers) {
            winningNumber.add(number);
        }
        return winningNumber;
    }

    public static int getValidBonus(List<Integer> winningNumber) {
        while (true) {
            try {
                int bonus = parsePrice(Console.readLine());
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

    public static int parsePrice(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해 주세요");
        }
    }


    public static void validLotto(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < LOTTO_START || number > LOTTO_END) {
                throw new IllegalArgumentException("[ERROR] 1 ~ 45 사이의 숫자를 입력해주세요!");
            }
        }
    }

    public static int[] getIntArray(String[] input) {
        int[] number = new int[input.length];
        for (int i = 0; i < number.length; i++) {
            number[i] = parsePrice(input[i]);
        }
        return number;
    }

    private static String[] split(String input) {
        return input.replaceAll(" ","").split(",");
    }

}
