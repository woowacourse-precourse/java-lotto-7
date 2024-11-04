package lotto;

public class Application {
    public static void main(String[] args) {
        LottoView view = new ConsoleView();
        LottoModel model = new LottoModel();
        LottoPresenter presenter = new LottoPresenter(view, model);
        presenter.start();
    }
}
