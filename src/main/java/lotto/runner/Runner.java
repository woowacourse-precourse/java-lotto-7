package lotto.runner;

import lotto.application.LottoGenerator;
import lotto.application.LottoService;
import lotto.domain.Lotto;
import lotto.global.LottoPrize;
import lotto.parser.InputParser;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class Runner {

    public static void run() {
        LottoGenerator lottoGenerator = LottoGenerator.getInstance();
        LottoService lottoService = LottoService.getInstance(lottoGenerator);

        int lottoPrice = InputParser.parseLottoPrice(InputView.inputLottoPurchase());
        List<Lotto> purchasedLottos = lottoService.buyLottos(lottoPrice);
        OutputView.printLottos(purchasedLottos);

        List<Integer> winningLottoNumbers = InputParser.parseLottoNumber(InputView.inputLottoNumber());
        Lotto winningLotto = Lotto.of(winningLottoNumbers);

        int bonusNumber = InputParser.parseBonusNumber(InputView.inputBonusNumber());

        List<LottoPrize> results = purchasedLottos.stream()
                .map(lotto -> lottoService.calculatePrize(lotto, winningLotto, bonusNumber))
                .collect(Collectors.toList());

        OutputView.printResult(results);

        double profitRate = lottoService.calculateProfitRate(results, lottoPrice);
        OutputView.printProfit(profitRate);
    }
}
