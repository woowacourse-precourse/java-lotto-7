package lotto;

import java.util.Arrays;
import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.domain.machine.LottoGenerator;
import lotto.domain.machine.LottoMoney;
import lotto.domain.machine.impl.RandomNumberGenerator;
import lotto.domain.machine.impl.SimpleNumberGenerator;
import lotto.domain.winning.LottoRank;
import lotto.domain.winning.WinningNumber;
import lotto.domain.winning.WinningStatistics;
import lotto.ui.InputView;
import lotto.ui.OutputView;
import lotto.ui.dto.LottoStatisticsResponse;
import lotto.ui.dto.PurchasedLottoResponse;
import lotto.ui.dto.WinningCountByPrize;
import lotto.ui.prompt.impl.ConsolePrompt;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView(new ConsolePrompt());
        OutputView outputView = new OutputView();
        try {
            // 금액 입력 + 발행한 로또 출력
            LottoMoney lottoMoney = LottoMoney.from(inputView.displayReadPurchaseAmount());
            LottoGenerator lottoGenerator = new LottoGenerator(new RandomNumberGenerator());
            List<Lotto> lottos = lottoGenerator.issueLottos(lottoMoney.getDrawCount());
            outputView.displayPurchasedLotto(PurchasedLottoResponse.of(lottoMoney.getDrawCount(), lottos));

            // 당첨 번호 + 보너스 번호 입력 + 로또 추첨 시작
            List<Integer> winningNumbers = inputView.displayReadWinningNumbers();
            SimpleNumberGenerator simpleNumberGenerator = new SimpleNumberGenerator();
            simpleNumberGenerator.setNumbers(winningNumbers);

            LottoGenerator winningLottoGenerator = new LottoGenerator(simpleNumberGenerator);
            Lotto winningLotto = winningLottoGenerator.issueLotto();
            int bonusNumber = inputView.displayReadBonusNumber();

            WinningNumber winningNumber = new WinningNumber(winningLotto, bonusNumber);
            WinningStatistics winningStatistics = new WinningStatistics();
            for (Lotto lotto : lottos) {
                LottoRank lottoRank = winningNumber.match(lotto);
                winningStatistics.addWinCountByRank(lottoRank);
            }

            // 로또 당첨 결과
            List<WinningCountByPrize> winningCountByPrizes = Arrays.stream(LottoRank.values())
                    .filter(LottoRank::isWinning)
                    .sorted((r1, r2) -> Integer.compare(r2.getRank(), r1.getRank()))
                    .map(rank -> WinningCountByPrize.of(rank, winningStatistics.getWinningCountByRank(rank)))
                    .toList();

            outputView.displayWinningStatistics(LottoStatisticsResponse.of(
                    winningCountByPrizes,
                    lottoMoney.getProfitRate(winningStatistics.getTotalPrize())
            ));
        } catch (IllegalArgumentException exception) {
            outputView.displayException(exception.getMessage());
        }
    }

}
