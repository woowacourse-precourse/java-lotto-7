package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class InputDevice {
    public int receivePrice() {
        String input = Console.readLine();
        try {
            int price = Integer.parseInt(input);
            validatePrice(price);
            return price;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 올바르지 않은 가격 형식입니다.");
        }
    }

    public List<Integer> receiveNumbers() {
        String input = Console.readLine();
        String[] splitInput = input.split(",");

        try {
            return Arrays.stream(splitInput)
                    .map(Integer::parseInt)
                    .toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자와 (,) 구분자만 입력해주세요.");
        }
    }

    private void validatePrice(int price) {
        if ((price % 1000) != 0) {
            throw new IllegalArgumentException("[ERROR] 입력한 금액이 1000으로 나누어 떨어지지 않습니다.");
        }
    }
}
