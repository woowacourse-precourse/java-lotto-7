package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputView {

    public int inputMoney() {
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                int money = Integer.parseInt(Console.readLine().trim());
                if (money % 1000 != 0) {
                    throw new IllegalArgumentException("[ERROR] 입력된 금액은 1000원 단위여야 합니다.");
                }
                return money;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public Lotto LottoNumber() {
        while (true) {
            try {
                System.out.println("당첨 번호를 입력해 주세요.");
                List<Integer> numbers = parseNumbers(Console.readLine());
                return new Lotto(numbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int bonusNum(Lotto winningLotto) {
        while (true) {
            try {
                System.out.println("보너스 번호를 입력해 주세요.");
                int bonus = Integer.parseInt(Console.readLine().trim());
                if (bonus < 1 || bonus > 45 || winningLotto.getNumbers().contains(bonus)) {
                    throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
                }
                return bonus;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private List<Integer> parseNumbers(String input) {
        List<Integer> numbers = new ArrayList<>();
        String[] tokens = input.split(",");
        for (String token : tokens) {
            numbers.add(Integer.parseInt(token.trim()));
        }
        return numbers;
    }
}
