package lotto;

public class Application {
    public static void main(String[] args) {
        LottoView view = new LottoView();
        LottoLogic logic = new LottoLogic();

        LottoController controller = new LottoController(view, logic);
        controller.run();
    }
}
