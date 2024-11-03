package lotto;

import java.util.List;

public class Controller {

    private final LottoService lottoService;

    public Controller(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public List<Lotto> buyLotto(Money money) {
        return lottoService.buyLotto(money);
    }
}
