package lotto;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import lotto.input.InputHandler;

public class LottoGame {

    public void run() {
        final int purchaseAmount = InputHandler.inputLottoPurchaseAmount();
        final int lottoAmount = purchaseAmount / 1000;
        final List<Lotto> lottos = LottoGenerator.createLottos(lottoAmount);

        WinningLotto winningLotto = getWinningLotto();
        LottoManager lottoManager = getLottoManager(lottos, winningLotto);
        LottoReferee referee = new LottoReferee(lottoManager);

        final List<WinningStatus> winningStatuses = referee.judgeWinning();
        PrizeProvider prizeProvider = new PrizeProvider(winningStatuses);
        Map<WinningRank, Long> prizes = prizeProvider.getPrizes();
        showWinningResult(prizes);

        final double rateOfReturn = prizeProvider.calculateRateOfReturn(purchaseAmount);
        showRateOfReturn(rateOfReturn);
    }

    private LottoManager getLottoManager(final List<Lotto> lottos, final WinningLotto winningLotto) {
        return new LottoManager(lottos, winningLotto);
    }

    private WinningLotto getWinningLotto() {
        final List<Integer> winningLottoNumbers = InputHandler.inputWinningLottoNumbers();
        final int bonusNumber = InputHandler.inputBonusNumber(winningLottoNumbers);
        return new WinningLotto(winningLottoNumbers, bonusNumber);
    }

    private void showWinningResult(Map<WinningRank, Long> prizes) {
        System.out.println("당첨 통계");
        System.out.println("---");
        NumberFormat numberFormat = NumberFormat.getInstance(Locale.US);
        prizes.entrySet().stream()
                .filter(prize -> prize.getKey() != WinningRank.NO_WINNING)
                .forEach(prize -> {
                    String formattedMoney = numberFormat.format(prize.getKey().getMoney());
                    if (prize.getKey() == WinningRank.SECOND) {
                        System.out.printf("5개 일치, 보너스 볼 일치 (%s원) - %d개\n", formattedMoney, prize.getValue());
                    } else {
                        System.out.printf("%d개 일치 (%s원) - %d개\n",
                                prize.getKey().getMatchedNumberCount(),
                                formattedMoney,
                                prize.getValue());
                    }
                });
    }

    private void showRateOfReturn(final double rateOfReturn) {
        System.out.printf("총 수익률은 %.1f%%입니다.", rateOfReturn);
    }
}
