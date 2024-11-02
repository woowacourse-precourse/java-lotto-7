package lotto;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.domain.machine.LottoMachine;
import lotto.domain.machine.Ticket;
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
import lotto.ui.impl.ConsolePrompt;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView(new ConsolePrompt());
        OutputView outputView = new OutputView();
        try {
            // 금액 입력 + 발행한 로또 출력
            int money = inputView.displayReadPurchaseAmount();
            int count = new Ticket(money).getCount();
            LottoMachine lottoMachine = new LottoMachine(new RandomNumberGenerator());
            List<Lotto> lottos = lottoMachine.issueLottos(count);
            PurchasedLottoResponse purchasedLottoResponse = PurchasedLottoResponse.of(count, lottos);
            outputView.displayPurchasedLotto(purchasedLottoResponse);

            // 당첨 번호 + 보너스 번호 입력 + 로또 추첨 시작
            List<Integer> winningNumbers = inputView.displayReadWinningNumbers();
            SimpleNumberGenerator simpleNumberGenerator = new SimpleNumberGenerator();
            simpleNumberGenerator.setNumbers(winningNumbers);

            LottoMachine winningLottoMachine = new LottoMachine(simpleNumberGenerator);
            Lotto winningLotto = winningLottoMachine.issueLotto();
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


            BigDecimal profitRate = winningStatistics.getTotalPrize()
                    .divide(BigDecimal.valueOf(money), 4, RoundingMode.HALF_UP)
                    .multiply(BigDecimal.valueOf(100));

            outputView.displayWinningStatistics(LottoStatisticsResponse.of(winningCountByPrizes, profitRate));
        } catch (IllegalArgumentException exception) {
            outputView.displayException(exception.getMessage());
        }
    }

}
