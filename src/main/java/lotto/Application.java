package lotto;

import lotto.controller.LottoController;

public class Application {
    public static void main(String[] args) {
        final LottoController controller = new LottoController();

        try {
            controller.start();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
