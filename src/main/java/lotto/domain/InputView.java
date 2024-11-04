package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class InputView {
    public int getPurchaseMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        try {
            int money = Integer.parseInt(Console.readLine());
            if (money % 1000 != 0) {
                throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력해주세요. ");
            }
            return money;
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 잘못된 입력입니다.");
            return getPurchaseMoney();
        }
    }

    public List<Integer> getWinningNumber() {
        try {
            System.out.println("당첨번호를 입력해 주세요.");
            String winningNumbers = Console.readLine();
            return Arrays.stream(winningNumbers.split(",")).toList().stream().map(Integer::parseInt).toList();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return getWinningNumber();
        }
    }

    public int getBonusNumber() {
        try {
            System.out.println("보너스 번호를 입력해 주세요.");
            return Integer.parseInt(Console.readLine());
        } catch (Exception e) {
            return getBonusNumber();
        }
    }
}
