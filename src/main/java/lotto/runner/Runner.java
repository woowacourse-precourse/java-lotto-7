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
        List<Lotto> purchasedLottos = getLottos(lottoService, lottoPrice);

        Lotto winningLotto = getWinningLotto();

        int bonusNumber = InputParser.parseBonusNumber(InputView.inputBonusNumber());

        List<LottoPrize> results = getLottoPrizes(purchasedLottos, lottoService, winningLotto, bonusNumber);

        getProfit(lottoService, results, lottoPrice);
    }

    private static List<Lotto> getLottos(LottoService lottoService, int lottoPrice) {
        List<Lotto> purchasedLottos = lottoService.buyLottos(lottoPrice);
        OutputView.printLottos(purchasedLottos);
        return purchasedLottos;
    }

    private static Lotto getWinningLotto() {
        List<Integer> winningLottoNumbers = InputParser.parseLottoNumber(InputView.inputLottoNumber());
        return Lotto.of(winningLottoNumbers);
    }

    private static void getProfit(LottoService lottoService, List<LottoPrize> results, int lottoPrice) {
        double profitRate = lottoService.calculateProfitRate(results, lottoPrice);
        OutputView.printProfit(profitRate);
    }

    private static List<LottoPrize> getLottoPrizes(List<Lotto> purchasedLottos, LottoService lottoService, Lotto winningLotto, int bonusNumber) {
        List<LottoPrize> results = purchasedLottos.stream()
                .map(lotto -> lottoService.calculatePrize(lotto, winningLotto, bonusNumber))
                .collect(Collectors.toList());

        OutputView.printResult(results);
        return results;
    }
}
