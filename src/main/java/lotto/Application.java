package lotto;
import lotto.controller.LottoController;
import lotto.model.LottoGame;
import lotto.view.LottoView;

public class Application {
    public static void main(String[] args) {
        LottoView lottoView = new LottoView();
        LottoGame game = new LottoGame();
        LottoController controller = new LottoController(lottoView, game);
        controller.start();
    }
}
