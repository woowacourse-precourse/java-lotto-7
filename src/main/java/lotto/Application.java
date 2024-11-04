package lotto;

import lotto.domain.Lotto;
import lotto.service.LottoService;
import lotto.util.InputHandler;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        LottoService lottoService = new LottoService();

        int money = InputHandler.getPurchaseAmount();
        int lottoCount = money / 1000;

        List<Lotto> lottos = lottoService.createLottos(lottoCount);
    }
}
