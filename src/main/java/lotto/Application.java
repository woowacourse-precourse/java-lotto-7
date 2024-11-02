package lotto;

import lotto.controller.LottoController;
import lotto.domain.Lotto;
import lotto.domain.LottoDrawResult;
import lotto.service.draw.LottoDrawService;
import lotto.service.draw.impl.LottoDrawServiceImpl;
import lotto.service.lotto.LottoService;
import lotto.service.lotto.impl.LottoServiceImpl;
import lotto.service.prize.LottoPrizeService;
import lotto.service.prize.impl.LottoPrizeServiceImpl;
import lotto.service.statistic.LottoStatService;
import lotto.service.statistic.impl.LottoStatServiceImpl;
import lotto.view.input.LottoInputView;
import lotto.view.output.LottoOutputView;

import java.util.List;


public class Application {

    public static void main(String[] args) {

        LottoController controller = init();
        List<Lotto> lottoBundle = controller.purchaseLotto();
        LottoDrawResult drawResult = controller.drawLotto();
        controller.getLottoStats(lottoBundle, drawResult);
    }

    public static LottoController init() {
        LottoInputView providerInputView = new LottoInputView();
        LottoOutputView providerOutputView = new LottoOutputView();
        LottoService lottoService = new LottoServiceImpl();
        LottoDrawService lottoDrawService = new LottoDrawServiceImpl();
        LottoPrizeService lottoPrizeService = new LottoPrizeServiceImpl();
        LottoStatService lottoStatService = new LottoStatServiceImpl();

        return new LottoController(providerInputView, providerOutputView, lottoService,
                lottoDrawService, lottoPrizeService, lottoStatService);
    }
}