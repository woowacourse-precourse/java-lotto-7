package lotto;

public class InputDevice {
    private void validatePrice(int price) {
        if ((price % 1000) != 0) {
            throw new IllegalArgumentException("[ERROR] 입력한 금액이 1000으로 나누어 떨어지지 않습니다.");
        }
    }
}
