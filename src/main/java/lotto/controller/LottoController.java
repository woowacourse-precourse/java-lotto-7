package lotto.controller;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import lotto.domain.LottoPrice;
import lotto.mapper.LottoMapper;
import lotto.domain.util.LottoNumberParser;
import lotto.domain.rank.LottoRanks;
import lotto.domain.Number;
import lotto.domain.lotto.WinningLotto;
import lotto.domain.lotto.random.CreateRandomNumbers;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.Lottos;
import lotto.domain.Money;
import lotto.domain.util.LottoStatistics;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.view.dto.LottoCountResponse;
import lotto.view.dto.LottoErrorResponse;
import lotto.view.dto.LottoRankResponse;
import lotto.view.dto.LottoResponse;
import lotto.view.dto.ReturnRateResponse;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;
    private final CreateRandomNumbers createRandomNumbers;

    public LottoController(InputView inputView, OutputView outputView, CreateRandomNumbers createRandomNumbers) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.createRandomNumbers = createRandomNumbers;
    }

    public void startLotto() {
        Money money = getMoney();
        Lottos lottos = butLottos(money.buyLottos());
        WinningLotto winningLotto = makeWinningLotto();
        LottoRanks lottoRanks = new LottoRanks(lottos.displayLottos(), winningLotto);
        showStatistics(lottoRanks, money);
    }

    private void showStatistics(LottoRanks lottoRanks, Money money) {
        List<Integer> sortedLottoRankCounts = lottoRanks.provideSortedRankCounts();
        double sumLottoPrice = lottoRanks.sumLottoPrice();
        Map<LottoPrice, Integer> statistics = LottoStatistics.makeRankToPrice(sortedLottoRankCounts);
        showLottoRanks(statistics);
        showReturnRate(money, sumLottoPrice);
    }

    private void showReturnRate(Money money, double sumLottoPrice) {
        ReturnRateResponse response = LottoMapper.toReturnRateResponse(
                LottoStatistics.calculateReturnRate(sumLottoPrice, money.getMoney())
        );
        outputView.showReturnRate(response.returnRate());
    }

    private void showLottoRanks(Map<LottoPrice, Integer> statistics) {
        outputView.guideStatistics();

        for (Entry<LottoPrice, Integer> entry : statistics.entrySet()) {
            LottoRankResponse response = LottoMapper.toLottoRankResponse(entry);
            outputView.showWinningResult(
                    response.lottoCount(),
                    response.lottoRankPrice(),
                    response.lottoRankCounts(),
                    response.bonus()
            );
        }
    }

    private WinningLotto makeWinningLotto() {
        WinningLotto winningLotto = getWinningNumber();
        getBonusNumber(winningLotto);

        return winningLotto;
    }

    private Lottos butLottos(int lottoCount) {
        LottoCountResponse lottoCountResponse = LottoMapper.toLottoCountResponse(lottoCount);
        outputView.buyLotto(lottoCountResponse.lottoCount());
        Lottos lottos = new Lottos(createRandomNumbers, lottoCount);

        for (Lotto lotto : lottos.displayLottos()) {
            LottoResponse lottoResponse = LottoMapper.toLottoResponse(lotto);
            outputView.displayLotto(lottoResponse.lottoNumber());
        }

        return lottos;
    }

    private Money getMoney() {
        outputView.getMoney();

        while (true) {
            try {
                return Money.from(inputView.getMoney());
            } catch (IllegalArgumentException e) {
                LottoErrorResponse response = LottoMapper.tolottoErrorResponse(e.getMessage());
                outputView.showError(response.error());
            }
        }
    }

    private WinningLotto getWinningNumber() {
        outputView.getWinningNumber();

        while (true) {
            try {
                return new WinningLotto(LottoNumberParser.parse(inputView.getWinningNumber()));
            } catch (IllegalArgumentException e) {
                LottoErrorResponse response = LottoMapper.tolottoErrorResponse(e.getMessage());
                outputView.showError(response.error());
            }
        }
    }

    private void getBonusNumber(WinningLotto winningLotto) {
        outputView.getBonusNumber();

        while (true) {
            try {
                winningLotto.addBonusNumber(Number.from(inputView.getBonusNumber()));
                break;
            } catch (IllegalArgumentException e) {
                LottoErrorResponse response = LottoMapper.tolottoErrorResponse(e.getMessage());
                outputView.showError(response.error());
            }
        }
    }
}
