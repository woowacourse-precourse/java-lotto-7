package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        try {
            int bonus_number;

            isAllowedCount(numbers);
            isDuplicate(numbers);
            isAllowedRange(numbers);
            this.numbers = numbers;

            List<List<Integer>> lotto_numbers = buyLotto();

            numbers = getWinningNumbers();
            bonus_number = getBonusNumber();
            printResult(lotto_numbers, numbers, bonus_number);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new IllegalArgumentException(e.getMessage());
        }
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
        System.out.println();

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
            System.out.println(e.getMessage());
            throw new IllegalArgumentException("[ERROR] 잘못된 형식의 구입 금액이 입력되었습니다.");
        }
    }

    private static List<List<Integer>> buyLotto() {
        List<List<Integer>> numbers = new ArrayList<>(List.of());
        int price = 1000;

        int count = getPurchaseAmount() / price;
        System.out.println("\n" + count + "개를 구매했습니다.");
        for (int i = 0; i < count; i++) {
            List<Integer> buffer = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            numbers.add(buffer);
            System.out.println(buffer);
        }
        System.out.println();
        return numbers;
    }

    private static int matchNumbers(List<Integer> numbers, List<Integer> winning_numbers) {
        return numbers.stream().filter(winning_numbers::contains).toList().size();
    }

    private static void printResult(List<List<Integer>> numbers, List<Integer> winning_numbers, int bonus_number) {
        List<Integer> result = new ArrayList<>();
        float yield = 0;

        for (int i = 0; i < 5; i++) { //Initialize list space for 1st ~ 5th winner count
            result.add(0);
        }

        for (List<Integer> number : numbers) {
            if (matchNumbers(number, winning_numbers) == 6) {
                result.set(0, result.getFirst() + 1);
            }
            if (matchNumbers(number, winning_numbers) == 5 && number.contains(bonus_number)) {
                result.set(1, result.get(1) + 1);
            }
            if (matchNumbers(number, winning_numbers) == 5 && !number.contains(bonus_number)) {
                result.set(2, result.get(2) + 1);
            }
            if (matchNumbers(number, winning_numbers) == 4) {
                result.set(3, result.get(3) + 1);
            }
            if (matchNumbers(number, winning_numbers) == 3) {
                result.set(4, result.get(4) + 1);
            }
        }
        yield = (float) (2000000000 * result.get(0) + 30000000 * result.get(1) + 1500000 * result.get(2) + 50000 * result.get(3) + 5000 * result.get(4)) / (numbers.size() * 10);

        System.out.println("\n당첨 통계\n---");
        System.out.println("3개 일치 (5,000원) - " + result.get(4) + "개");
        System.out.println("4개 일치 (50,000원) - " + result.get(3) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + result.get(2) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + result.get(1) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + result.get(0) + "개");
        System.out.println("총 수익률은 " + yield + "%입니다.");
    }
}
