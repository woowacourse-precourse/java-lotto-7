package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Input {
    private Validator validator = new Validator();
    public int getMoney() {
        while (true) {
            System.out.println("구입금액을 입력해 주세요.");
            String input = Console.readLine();
            try {
                if (!input.matches("\\d+")) {
                    throw new IllegalArgumentException("[ERROR] 구입금액은 숫자여야 합니다.");
                }
                int money = Integer.parseInt(input);
                validator.validateMoney(money);
                return money;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    public List<Integer> getWinningNumbers() {
        while (true) {
            System.out.println("당첨 번호를 입력해 주세요 (쉼표로 구분하여 6개의 숫자를 입력하세요).");
            String[] winNumbers = Console.readLine().split(",");
            try {
                return validator.validateWinningNumbers(winNumbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    public int getBonus() {
        while (true) {
            System.out.println("보너스 번호를 입력해 주세요.");
            String input = Console.readLine();
            System.out.println();
            try {
                validator.validateBonus(input);
                int bonus = Integer.parseInt(input);
                return bonus;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
