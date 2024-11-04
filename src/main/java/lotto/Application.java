package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        LottoManager lottoManager = new LottoManager();
        LottoService lottoService = new LottoService(lottoManager);
        LottoView lottoView = new LottoView();
        LottoController lottoController = new LottoController(lottoService, lottoView);

        List<Lotto> lottoTickets = lottoController.purchaseLottoTickets();
        lottoController.setWinningAndBonusLottoNumbers();
        lottoController.lottoResults(lottoTickets);
    }
}
