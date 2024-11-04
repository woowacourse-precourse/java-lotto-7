package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.stream.Stream;

public class Source {

    public static int inputAmount() {
        while (true) {
            System.out.println("구입금액을 입력해 주세요.");
            String input = Console.readLine();
            try {
                int amount = Integer.parseInt(input);
                if (amount % 1000 != 0) {
                    throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
                }
                return amount;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자만 입력하세요.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static Lotto inputWinningNumbers() {
        while (true) {
            System.out.println("\n당첨번호를 입력해 주세요.");
            String input = Console.readLine();
            try {
                String[] winningNumbers = input.split(",");
                List<Integer> parsedNumbers = Stream.of(winningNumbers)
                        .map(Integer::parseInt)
                        .toList();
                return new Lotto(parsedNumbers);
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자만 입력하세요.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static int inputBonusNumber() {
        while (true) {
            System.out.println("\n보너스 번호를 입력해 주세요.");
            String input = Console.readLine();
            try {
                int bonusNumber = Integer.parseInt(input);
                if (bonusNumber < 1 || bonusNumber > 45) {
                    throw new IllegalArgumentException("[ERROR] 보너스 번호는 1과 45 사이의 숫자여야 합니다.");
                }
                return bonusNumber;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자만 입력하세요.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
