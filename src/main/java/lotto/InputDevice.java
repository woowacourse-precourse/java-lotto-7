package lotto;

import camp.nextstep.edu.missionutils.Console;

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

    private void validatePrice(int price) {
        if ((price % 1000) != 0) {
            throw new IllegalArgumentException("[ERROR] 입력한 금액이 1000으로 나누어 떨어지지 않습니다.");
        }
    }
}
