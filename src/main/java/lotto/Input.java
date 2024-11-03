package lotto;

public class Input {
    public void validateRemainder(String input) {
        if(Integer.parseInt(input) % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위로 입력해야 합니다.");
        }
    }
}
