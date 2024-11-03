package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.HashSet;

public class InputView {
    private static int purchaseAmount;

    public static int getPurchaseAmount() {
        return purchaseAmount;
    }

    public static int purchaseAmount() {
        OutputView.purchaseAmount();
        while (true) {
            try {
                purchaseAmount = Integer.parseInt(Console.readLine());
                if (purchaseAmount % 1000 != 0) {
                    System.out.println("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
                    continue;
                }
                return purchaseAmount / 1000;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 유효하지 않은 금액입니다. 숫자를 입력해 주세요.");
            }
        }
    }

    public static List<Integer> winningNumber() {
        OutputView.userNumber();
        while (true){
            List<Integer> numbers =  Arrays.stream(Console.readLine().split(","))
                    .map(Integer::parseInt)
                    .toList();
            if (numbers.size() != new HashSet<>(numbers).size()) {
                System.out.println("[ERROR] 당첨 번호는 중복될 수 없습니다.");
                continue;
            }
            return numbers;
        }
    }

    public static int bonusNumber() {
        return Integer.parseInt(Console.readLine());
    }
}
