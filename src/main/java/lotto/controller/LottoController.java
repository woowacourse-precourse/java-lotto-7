package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoDrawResult;
import lotto.service.draw.LottoDrawService;
import lotto.service.lotto.LottoService;
import lotto.view.input.LottoInputView;
import lotto.view.output.LottoOutputView;

import java.util.List;

public class LottoController {

    private final LottoInputView inputView;
    private final LottoOutputView outputView;
    private final LottoService lottoService;
    private final LottoDrawService lottoDrawService;

    public LottoController(LottoInputView inputView, LottoOutputView outputView,
                           LottoService lottoService, LottoDrawService lottoDrawService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoService = lottoService;
        this.lottoDrawService = lottoDrawService;
    }

    public List<Lotto> purchaseLotto() {
        List<Lotto> lottoBundle = lottoService.createLottoBundle(promptPurchaseCount());
        outputView.printLottoBundle(lottoBundle);

        return lottoBundle;
    }

    public LottoDrawResult drawLotto() {
        Lotto drewLotto = getDrewLotto();
        return getLottoDrawResult(drewLotto);
    }

    private LottoDrawResult getLottoDrawResult(Lotto drewLotto) {
        int bonusNumber = promptBonusNumber();
        return lottoDrawService.getLottoDrawResult(drewLotto, bonusNumber);
    }

    private Lotto getDrewLotto() {
        List<Integer> numbers = promptLottoNumbers();
        Lotto drewLotto = lottoService.createLotto(numbers);
        return drewLotto;
    }

    private List<Integer> promptLottoNumbers() {
        outputView.promptLottoDrawNumber();
        List<Integer> numbers = inputView.readLottoNumbers();
        return numbers;
    }

    private int promptBonusNumber() {
        outputView.promptBonusNumber();
        int bonusNumber = inputView.readBonusNumber();
        return bonusNumber;
    }

    private int promptPurchaseCount() {
        outputView.promptPurchaseAmount();
        int money = inputView.readMoney();

        return money / 1000;
    }
}
