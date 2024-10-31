package lotto.domain.model.lotto;

import lotto.common.constant.LottoConst;
import lotto.domain.model.user.User;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoService {

    private final LottoGenerator lottoGenerator;

    public LottoService(LottoGenerator lottoGenerator) {
        this.lottoGenerator = lottoGenerator;
    }

    public List<Lotto> issueByAmount(int amount) {
        int quantity = amountToQuantity(amount);
        return lottoGenerator.generateByQuantity(quantity);
    }

    private int amountToQuantity(int amount) {
        return amount / LottoConst.LOTTO_PRICE;
    }

    public LottoSummary evaluateUserLotto(User user, Lotto winningLotto, int bonusNumber) {
        List<LottoRank> results = convertUserLottoToRank(user, winningLotto, bonusNumber);

        LottoSummary lottoSummary = groupingResult(results);

        int totalAmountPurchased = user.getTotalAmountPurchased();
        double calculatedProfitRate = lottoSummary.getProfitRate(totalAmountPurchased);

        user.changeProfitRate(calculatedProfitRate);

        return lottoSummary;
    }

    private static List<LottoRank> convertUserLottoToRank(User user, Lotto winningLotto, int bonusNumber) {
        return user.getLottos()
                .stream()
                .map(userLotto -> compareUserLottoWithWinningLotto(userLotto, winningLotto, bonusNumber))
                .collect(Collectors.toUnmodifiableList());
    }

    private static LottoRank compareUserLottoWithWinningLotto(Lotto userLotto, Lotto winningLotto, int bonusNumber) {
        int correctCount = (int) userLotto.getNumbers()
                .stream()
                .filter(winningLotto::isContainingNumber)
                .count();

        boolean isCorrectBonusNumber = userLotto.isContainingNumber(bonusNumber);

        return LottoRank.getMatchedLotto(correctCount, isCorrectBonusNumber);
    }

    private LottoSummary groupingResult(List<LottoRank> results) {
        Map<LottoRank, Long> rankCounts = results.stream()
                .collect(Collectors.groupingBy(result -> result, Collectors.counting()));
        return LottoSummary.create(rankCounts);
    }
}
