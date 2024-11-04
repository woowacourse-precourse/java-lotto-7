package controller;

import camp.nextstep.edu.missionutils.Randoms;
import domain.LottoResult;
import lotto.Lotto;
import service.LottoService;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoService lottoService;

    public LottoController(InputView inputView, OutputView outputView, LottoService lottoService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoService = lottoService;
    }

    public void run() {
        LottoResult result = getTotalCost();
        setLottoAmount(result);
        setLottos(result);
        setWinningNumbers(result);
    }

    private LottoResult getTotalCost() {
        LottoResult result = new LottoResult();
        String purchaseAmount = inputView.getCost();
        result.setPurchaseAmount(Integer.parseInt(purchaseAmount));
        return result;
    }

    private void setLottoAmount(LottoResult result) {
        result.setTotalLottos(result.getPurchaseAmount() / 1000);
        outputView.printPurchaseMsg(result);
    }

    private void setLottos(LottoResult result) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < result.getTotalLottos(); i++) {
            Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            lottos.add(lotto);
            outputView.printLotto(lotto);
        }
        result.setPurchasedLottos(lottos);
    }

    private void setWinningNumbers(LottoResult result) {
        String input = inputView.getLottoNumbers();

    }
}
