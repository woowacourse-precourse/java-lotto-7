package lotto;

public class Application {
    public static void main(String[] args) {
        LottoView view = new LottoView();
        LottoController controller = new LottoController();
        controller.run();
    }
}
