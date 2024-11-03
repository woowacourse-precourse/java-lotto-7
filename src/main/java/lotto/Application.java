package lotto;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        LottoView view = new LottoView();
        LottoModel model = new LottoModel();
        LottoController controller = new LottoController(model, view);

        controller.startLotto();
    }
}