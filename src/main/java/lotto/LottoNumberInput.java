package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class LottoNumberInput {

    public int getPurchaseAmount() {
        int money;

        do {
            System.out.println("구입금액을 입력해주세요.");
            try {
                money = Integer.parseInt(Console.readLine());
                if (money % 1000 != 0) {
                    System.out.println("[ERROR] 구입 금액은 1000원 단위로 입력해야 합니다.");
                    throw new IllegalArgumentException();
                }
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 숫자를 입력해 주세요.");
                money = -1;
            }
        } while (money <= 0 || money % 1000 != 0);
        return money;
    }

    public List<Integer> getWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return Arrays.stream(Console.readLine().split(","))
                .map(Integer::parseInt)
                .toList();
    }

    public int getBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }

}
