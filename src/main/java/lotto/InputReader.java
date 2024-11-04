package lotto;

import camp.nextstep.edu.missionutils.Console;


public class InputReader {

    public void readInput() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        int givenAmount = Integer.parseInt(input);
    }

    private String checkNotEmpty(String input) {
        input = input.trim();
        if (input.isEmpty() || input == null) {
            throw new IllegalArgumentException("값을 입력해 주세요.");
        }
        return input;
    }

    private void validatePositiveAmount(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("구입 금액은 0 이상 이어야 합니다.");
        }
    }

    private void validateAmountInThousands(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("구입 금액은 1000원 단위여야 합니다.");
        }
    }

}
