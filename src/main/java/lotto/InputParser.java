package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputParser {
    private static final Scanner scanner = new Scanner(System.in);

    public static int parsePurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        int amount = Integer.parseInt(scanner.nextLine());
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
        }
        return amount;
    }

    public static List<Integer> parseWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return Arrays.stream(scanner.nextLine().split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static int parseBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return Integer.parseInt(scanner.nextLine().trim());
    }
}
