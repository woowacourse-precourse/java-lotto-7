package lotto;


public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            lottoProcess();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            lottoProcess();

        }
    }

    public static void lottoProcess() {
        // 1. 로또 구입금액을 입력받고 예외처리한다
        PurchaseAmount amount = UserInputConsole.readPurchaseAmount();
    }
}


