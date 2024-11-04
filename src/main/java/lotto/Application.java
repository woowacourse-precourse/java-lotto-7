package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Application {
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

    private static List<List<Integer>> buyLotto() {
        int amount, price = 1000;
        List<List<Integer>> lotto_numbers = new ArrayList<>(List.of());

        System.out.println("구입 금액을 입력해 주세요.");

        try {
            amount = Integer.parseInt(Console.readLine());
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 잘못된 형식의 구입 금액이 입력되었습니다.");
        }

        int count = amount / price;
        for (int i = 0; i < count; i++) {
            List<Integer> buffer = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lotto_numbers.add(buffer);
            System.out.println(buffer);
        }
        return lotto_numbers;
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현

    }
}
