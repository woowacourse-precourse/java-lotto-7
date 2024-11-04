package exception;

public class ValidationException {

    public static void validatePrice(int price) {
        if (price % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구매 금액이 1000단위여야 합니다.");
        }
    }

    public static void validateForm() {
        throw new IllegalArgumentException("[ERROR] 형식에 맞게 제대로 입력해야 합니다.");
    }
}
