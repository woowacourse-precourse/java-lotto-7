package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.service.LottoService;
import lotto.service.PurchaseService;
import lotto.view.InputView;

import java.util.ArrayList;
import java.util.List;

import static lotto.common.Constants.*;

public class LottoController {
    private final InputView inputView;
    private final PurchaseService purchaseService;
    private final LottoService lottoService;

    public LottoController(InputView inputView, PurchaseService purchaseService,
                           LottoService lottoService) {
        this.inputView = inputView;
        this.purchaseService = purchaseService;
        this.lottoService = lottoService;
    }

    public void run () {
        Integer lottoTicketCount = lottoPurchase();

        Lottos lottos = generateLottos(lottoTicketCount);
    }

    public Lottos generateLottos (Integer lottoTicketCount) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < lottoTicketCount; i ++ ) {
            List<Integer> randomNumbers = generateRandomNumbers();
            Lotto lotto = lottoService.generateLotto(randomNumbers);
            lottos.add(lotto);
        }

        return lottoService.generateLottos(lottos);
    }

    private Integer lottoPurchase () {
        String rawPurchaseAmount = inputView.getPurchaseAmount();

        return purchaseService.purchaseLotto(rawPurchaseAmount);
    }

    private List<Integer> generateRandomNumbers () {
        return Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER, LOTTO_SIZE);
    }

}
