package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class InputView {

    public int readPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();

        int purchaseAmount = inputToInteger(input);
        validate(purchaseAmount);
        return purchaseAmount;
    }

    public List<Integer> readWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        // TODO: 검증
        return Arrays.stream(Console.readLine().split(","))
                .mapToInt(Integer::parseInt)
                .boxed()
                .toList();
    }

    public int readBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return inputToInteger(Console.readLine());
    }

    private void validate(int input) {
        if (input % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 한 장의 가격은 1,000원입니다. 1,000원 단위로 입력해주세요.");
        }
    }

    private Integer inputToInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력할 수 있습니다.");
        }
    }
}
