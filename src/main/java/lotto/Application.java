package lotto;

public class Application {
    public static void main(String[] args) {
        LottoController controller = new LottoController();
        do {
            controller.run();
        } while (controller.isFlag());
    }
}
