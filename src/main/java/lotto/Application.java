package lotto;

import controller.LottoController;
import service.LottoService;
import view.LottoView;

public class Application {
    public static void main(String[] args) {
        try {
            LottoView lottoView = new LottoView();
            LottoService lottoService = new LottoService();

            LottoController lottoController = new LottoController(lottoView, lottoService);
            lottoController.buyLotto();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}