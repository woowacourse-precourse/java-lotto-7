package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class InputValidator {

    public static Lotto readWinningNumbers() {
        while (true) {
            try {
                String input = Console.readLine();
                List<Integer> numbers = Arrays.stream(input.split(","))
                        .map(String::trim)
                        .map(Integer::parseInt)
                        .toList();

                return new Lotto(numbers);

            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자만 입력 가능합니다.");
                System.out.println("다시 입력해 주세요.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.out.println("다시 입력해 주세요.");
            }
        }
    }

    public static LottoBonus readBonusNumber(Lotto winningLotto) {
        while (true) {
            try {
                String input = Console.readLine();
                int bonus = Integer.parseInt(input.trim());

                return new LottoBonus(bonus, winningLotto);

            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자만 입력 가능합니다.");
                System.out.println("다시 입력해 주세요.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.out.println("다시 입력해 주세요.");
            }
        }
    }

    public static LottoAmount readAmount() {
        while (true) {
            try {
                String input = Console.readLine();
                int amount = Integer.parseInt(input.trim());

                return new LottoAmount(amount);

            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자만 입력 가능합니다.");
                System.out.println("다시 입력해 주세요.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.out.println("다시 입력해 주세요.");
            }
        }
    }

}
