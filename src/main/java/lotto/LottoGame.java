package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoGame {
    private static final int LOTTO_PRICE = 1000;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;


    static int getLottoAmount() {
        while (true) {
            System.out.println("로또 금액을 입력해주세요");
            int amount = Integer.parseInt(Console.readLine());
            if (amount % LOTTO_PRICE != 0 || amount <= 0) {
                throw new IllegalArgumentException("[ERROR] 금액은 1,000원 단위여야 합니다.");
            }
            return amount;
        }
    }

    static List<Integer> getWinningNumbers() {
        while (true) {
            try {
                System.out.println("당첨 번호를 입력해 주세요.");
                String input = Console.readLine();
                List<Integer> winningNumbers = parseNumbers(input);
                return winningNumbers;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    static List<Integer> parseNumbers(String input) {
        List<Integer> numbers = Arrays.stream(input.split(","))
                .map(String::trim)  // 공백 제거
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        validateWinningNumbers(numbers);
        return numbers;
    }

    static int getBonusNumber(){
        while (true) {
            try {
                System.out.println("보너스  번호를 입력해 주세요.");
                String input = Console.readLine();
                int result = Integer.parseInt(input);
                return result;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    static void validateWinningNumbers(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.");
        }
        for (int number : numbers) {
            if (number < MIN_NUMBER || number > MAX_NUMBER) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
        if (numbers.stream().distinct().count() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 중복된 번호가 있습니다.");
        }
    }
}
