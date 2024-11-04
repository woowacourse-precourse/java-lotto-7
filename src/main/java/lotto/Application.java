package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        final LottoManager lottoManager = new LottoManager();
        final LottoService lottoService = new LottoService(lottoManager);
        final LottoView lottoView = new LottoView();
        final LottoController lottoController = new LottoController(lottoService, lottoView);

        final List<Lotto> lottoTickets = lottoController.purchaseLottoTickets();
        lottoController.setWinningAndBonusLottoNumbers();
        lottoController.lottoResults(lottoTickets);
    }
}
