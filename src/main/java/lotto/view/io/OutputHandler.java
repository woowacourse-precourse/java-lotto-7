package lotto.view.io;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.rank.LottoRank;
import lotto.exception.LottoApplicationException;
import lotto.view.io.message.LottoMessageGenerator;
import lotto.view.io.message.RankMessageGenerator;
import lotto.view.io.message.RateOfReturnMessageGenerator;

public class OutputHandler {

    private final LottoMessageGenerator lottoMessageGenerator = new LottoMessageGenerator();
    private final RankMessageGenerator rankMessageGenerator = new RankMessageGenerator();
    private final RateOfReturnMessageGenerator rateOfReturnMessageGenerator = new RateOfReturnMessageGenerator();

    public void askPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void askWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void askBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public void showPurchasedLottos(List<Lotto> purchasedLottos) {
        showPurchasedLottoSize(purchasedLottos);
        purchasedLottos.forEach(this::showPurchasedLotto);
        showEmptyLine();
    }

    public void showEmptyLine() {
        System.out.println();
    }

    public void showWinningStatistics(Map<LottoRank, Integer> ranks, double rateOfReturn) {
        showWinningStatisticsComments();
        LottoRank.getRanksOrderByReward()
                .forEach(rank -> showRankResult(rank, ranks.get(rank)));
        showRateOfReturn(rateOfReturn);
    }

    private void showPurchasedLottoSize(List<Lotto> purchasedLottos) {
        String purchaseQuantityMessage = lottoMessageGenerator.getPurchaseQuantityMessage(purchasedLottos.size());
        System.out.println(purchaseQuantityMessage);
    }

    private void showPurchasedLotto(Lotto purchasedLotto) {
        String sortedNumbersMessage = lottoMessageGenerator.getSortedNumbersMessage(purchasedLotto);
        System.out.println(sortedNumbersMessage);
    }

    private void showWinningStatisticsComments() {
        System.out.println("당첨 통계");
        System.out.println("---");
    }

    private void showRankResult(LottoRank rank, Integer count) {
        String message = rankMessageGenerator.getMessage(rank, count);
        System.out.println(message);
    }

    private void showRateOfReturn(double rateOfReturn) {
        String rateOfReturnMessage = rateOfReturnMessageGenerator.getMessage(rateOfReturn);
        System.out.println(rateOfReturnMessage);
    }

    public void showLottoApplicationException(LottoApplicationException exception) {
        System.out.println(exception.getMessage());
    }

}
