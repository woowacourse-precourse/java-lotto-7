package lotto.controller;

import lotto.domain.AutoLotto;
import lotto.service.LottoService;
import lotto.view.InputView;

import java.util.List;

public class LottoController {
    private final InputView inputView;
    private final LottoService lottoService;

    public LottoController(InputView inputView, LottoService lottoService) {
        this.inputView = inputView;
        this.lottoService = lottoService;
    }

    public void run() {
        getValidAutoLotto();
    }

    private List<AutoLotto> getValidAutoLotto() {
        while (true) {
            try {
                String inputLottoPrice = inputView.getLottoPriceByUser();
                return lottoService.createAutoLottosByLottoPrice(inputLottoPrice);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage() + " " + "다시 입력하세요.");
            }
        }
    }


}
