package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        isAllowedCount(numbers);
        isDuplicate(numbers);
        isAllowedRange(numbers);
        this.numbers = numbers;
    }

    private void isAllowedCount(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void isDuplicate(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되지 않아야 합니다.");
        }
    }

    private void isAllowedRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(number -> number < 1 || number > 45)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private static List<Integer> getWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();

        try {
            return Arrays.stream(input.split(",")).map(Integer::parseInt).toList();
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 잘못된 형식의 로또 번호가 입력되었습니다.");
        }
    }

    private static int getBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");

        try {
            return Integer.parseInt(Console.readLine());
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 잘못된 형식의 보너스 번호가 입력되었습니다.");
        }
    }

    private static int getPurchaseAmount() {
        System.out.println("구입 금액을 입력해 주세요.");

        try {
            return Integer.parseInt(Console.readLine());
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 잘못된 형식의 구입 금액이 입력되었습니다.");
        }
    }

    private static List<List<Integer>> buyLotto() {
        List<List<Integer>> numbers = new ArrayList<>(List.of());
        int price = 1000;

        int count = getPurchaseAmount() / price;
        for (int i = 0; i < count; i++) {
            List<Integer> buffer = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            numbers.add(buffer);
            System.out.println(buffer);
        }
        return numbers;
    }
}
