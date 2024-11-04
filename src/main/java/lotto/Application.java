package lotto;

import javax.swing.*;

public class Application {
    public static void main(String[] args) {
        LottoView view = new LottoView();
        LottoGame game = new LottoGame();
        LottoController controller = new LottoController(view, game);

        controller.start();
    }
}
