package lotto;

public class Application {
    public static void main(String[] args) {

    }
    public static int validateAmount(int input) {
        if(input <= 0 || input % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1,000원 단위여야 합니다.");
        }
        return input;
    }
}
