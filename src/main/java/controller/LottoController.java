package controller;

import domain.Lotto;
import domain.Lottos;
import service.WinningService;
import view.InputView;

public class LottoController {

    private final WinningService winningService = new WinningService();


    public void start() {
        Lottos lottos = winningService.generateLottoNumber(InputView.purchasePriceInput());
        for (Lotto lotto : lottos.getLottos()) {
            System.out.println(lotto.getNumbers());
        }
    }
}
