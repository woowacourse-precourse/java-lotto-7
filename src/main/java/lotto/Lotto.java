package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    public int buyLotto() {
        System.out.println("구입 금액을 입력해 주세요.");
        int amount = 0;

        while (true) {
            try {
                amount = Integer.parseInt(Console.readLine());

                if (amount % 1000 != 0) {
                    throw new IllegalArgumentException("구입 금액은 1,000원 단위여야 합니다.");
                }
                System.out.println("구입 금액: " + amount + "원");
                return (amount / 1000);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("숫자로만 입력해주세요");
            }
        }
    }
}
