package lotto.controller;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.Revenue;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public void StartBuyLotto() {
        OutputView.purchasedBudget();

        Revenue revenue = new Revenue(InputView.budget());
        int lottoTicketCount = lottoService.getLottoTicketCount(revenue.getInitialCapital());

        OutputView.PurchasedLottoTicketsMessage(lottoTicketCount);

//        List<Lotto> boughtLottos = lottoService.buyLottos(lottoTicketCount);
//        List<List<Integer>> lottoNums = boughtLottos.stream()  // 이거 나중 수정 필요
//                .map(Lotto::getNumbers)
//                .toList();

//        OutputView.printLottos(lottoNums);

    }
}
