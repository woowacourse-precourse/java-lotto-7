package lotto.view;

public class InputValidator {

    public void isDivisibleByThousand(long price) {
        if (price != 1000) {
            throw new IllegalArgumentException("금액은 1,000원 단위로 나뉘어져야 합니다");
        }
    }
}
