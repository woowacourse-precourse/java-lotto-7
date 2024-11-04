package lotto.view;
import java.util.HashSet;
import java.util.Set;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static int getPurchaseAmount() {
        while (true) {
            System.out.println("구입금액을 입력해 주세요.");
            try {
                int amount = Integer.parseInt(Console.readLine());
                if (amount < 1000 || amount % 1000 != 0) {
                    throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위의 양수여야 합니다.");
                }
                return amount;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 구입 금액은 숫자로 입력해 주세요.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }



    public static String getWinningNumbers() {
        while (true) {
            System.out.println("당첨 번호를 입력해 주세요.");
            String input = Console.readLine().trim();
            try {
                // 입력 형식 및 중복 검사를 위한 메서드 호출
                validateWinningNumbersFormat(input);
                return input;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void validateWinningNumbersFormat(String input) {
        String[] numbers = input.split(",");
        if (numbers.length != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 쉼표로 구분된 6개의 숫자로 입력해야 합니다.");
        }

        Set<Integer> uniqueNumbers = new HashSet<>();
        for (String number : numbers) {
            int num = Integer.parseInt(number.trim());
            if (num < 1 || num > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
            if (!uniqueNumbers.add(num)) {
                throw new IllegalArgumentException("[ERROR] 로또 번호에 중복된 숫자가 있습니다.");
            }
        }
    }

    public static int getBonusNumber() {
        while (true) {
            System.out.println("보너스 번호를 입력해 주세요.");
            try {
                int bonusNumber = Integer.parseInt(Console.readLine());
                if (bonusNumber < 1 || bonusNumber > 45) {
                    throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
                }
                return bonusNumber;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 보너스 번호는 숫자로 입력해 주세요.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
