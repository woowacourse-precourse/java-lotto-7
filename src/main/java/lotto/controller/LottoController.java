package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoDrawResult;
import lotto.domain.LottoPrize;
import lotto.domain.LottoStats;
import lotto.service.draw.LottoDrawService;
import lotto.service.lotto.LottoService;
import lotto.service.prize.LottoPrizeService;
import lotto.service.statistic.LottoStatService;
import lotto.view.input.LottoInputView;
import lotto.view.output.LottoOutputView;

import java.util.List;

public class LottoController {

    private final LottoInputView inputView;
    private final LottoOutputView outputView;
    private final LottoService lottoService;
    private final LottoDrawService lottoDrawService;
    private final LottoPrizeService lottoPrizeService;
    private final LottoStatService lottoStatService;

    public LottoController(LottoInputView inputView, LottoOutputView outputView, LottoService lottoService,
                           LottoDrawService drawService, LottoPrizeService lottoPrizeService, LottoStatService statService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoService = lottoService;
        this.lottoDrawService = drawService;
        this.lottoPrizeService = lottoPrizeService;
        this.lottoStatService = statService;
    }

    public List<Lotto> purchaseLotto() {
        try {
            List<Lotto> lottoBundle = lottoService.createLottoBundle(promptPurchaseCount());
            outputView.printLottoBundle(lottoBundle);

            return lottoBundle;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return this.purchaseLotto();
        }
    }

    public LottoDrawResult drawLotto() {
        try {
            Lotto drewLotto = getDrewLotto();
            return getLottoDrawResult(drewLotto);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return this.drawLotto();
        }
    }

    public LottoStats getLottoStats(List<Lotto> lottoBundle, LottoDrawResult drawResult) {
        try {
            List<LottoPrize> lottoPrizes = lottoPrizeService.getLottoPrizes(lottoBundle, drawResult);
            LottoStats lottoStats = lottoStatService.getLottoStats(lottoPrizes, lottoBundle.size() * 1000);
            outputView.printLottoStats(lottoStats);
            return lottoStats;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return this.getLottoStats(lottoBundle, drawResult);
        }
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
