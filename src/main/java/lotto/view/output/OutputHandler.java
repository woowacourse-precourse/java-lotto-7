package lotto.view.output;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.rank.LottoRank;
import lotto.exception.LottoApplicationException;
import lotto.view.output.message.LottoMessageGenerator;
import lotto.view.output.message.RankMessageGenerator;
import lotto.view.output.message.RateOfReturnMessageGenerator;

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

    public void showEmptyLine() {
        System.out.println();
    }

    public void showPurchasedLottoQuantity(int purchasedLottoQuantity) {
        String purchaseQuantityMessage = lottoMessageGenerator.getPurchaseQuantityMessage(purchasedLottoQuantity);
        System.out.println(purchaseQuantityMessage);
    }

    public void showPurchasedLottos(List<Lotto> purchasedLottos) {
        purchasedLottos.forEach(this::showPurchasedLotto);
    }

    public void showWinningStatisticsComments() {
        System.out.println("당첨 통계");
        System.out.println("---");
    }

    public void showRanks(Map<LottoRank, Integer> ranks) {
        LottoRank.getRanksOrderByReward()
                .forEach(rank -> showRankResult(rank, ranks.get(rank)));
    }

    public void showRateOfReturn(double rateOfReturn) {
        String rateOfReturnMessage = rateOfReturnMessageGenerator.getMessage(rateOfReturn);
        System.out.println(rateOfReturnMessage);
    }

    public void showLottoApplicationException(LottoApplicationException exception) {
        System.out.println(exception.getMessage());
    }

    private void showPurchasedLotto(Lotto purchasedLotto) {
        String sortedNumbersMessage = lottoMessageGenerator.getSortedNumbersMessage(purchasedLotto);
        System.out.println(sortedNumbersMessage);
    }

    private void showRankResult(LottoRank rank, Integer count) {
        String message = rankMessageGenerator.getMessage(rank, count);
        System.out.println(message);
    }

}
