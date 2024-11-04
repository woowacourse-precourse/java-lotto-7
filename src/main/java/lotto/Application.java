package lotto;

public class Application {
    public static void main(String[] args) {
        InputView view = new InputView();
        LottoController controller = new LottoController(view);
        controller.run();
    }
}
