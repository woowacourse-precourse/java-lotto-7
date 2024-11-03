package lotto.domain;

import lotto.dto.Lotto;
import lotto.dto.Result;
import lotto.util.LottoRank;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class LotteryMachine {
    public static final int LOTTO_TICKET_PRICE = 1000;

    public void purchaseLottoTickets(User user) {
        int purchaseAmount = user.getPurchaseAmount();
        validatePurchaseAmount(purchaseAmount);
        int numberOfPurchase = purchaseAmount/LOTTO_TICKET_PRICE;
        IntStream.range(0,numberOfPurchase).forEach(i -> purchaseLotto(user));
    }

    private void purchaseLotto(User user) {
        List<Integer> pickedNumbers = user.pickNumbersSorted();
        Lotto lotto = new Lotto(pickedNumbers);
        user.buyLotto(lotto);
    }
    public void checkLottery(User user, Result result) {
        Lotto winningLotto = result.getLotto();
        int bonusNumber = result.getBonusNumber();
        LottoResult lottoResult = user.getLottoResult();
        user.getPurchasedLotto().forEach(lotto -> {
            LottoRank lottoRank = getLottoRank(winningLotto, lotto, bonusNumber);
            lottoResult.addRank(lottoRank);
        });
    }
    private LottoRank getLottoRank(Lotto winningLotto, Lotto purchasedLotto, int bonusNumber) {
        List<Integer> winningLottoNumbers = winningLotto.getNumbers();
        List<Integer> purchasedLottoNumbers = purchasedLotto.getNumbers();
        int sameNumberCount = (int) getSameNumberCount(winningLottoNumbers,purchasedLottoNumbers);
        boolean haveBonusNumber = isContainBonusNumber(purchasedLottoNumbers,bonusNumber);
        return LottoRank.fromSameNumberCount(sameNumberCount,haveBonusNumber);
    }
    private long getSameNumberCount(List<Integer> winningLottoNumbers,List<Integer> purchasedLottoNumbers) {
        return purchasedLottoNumbers.stream().filter(purchasedLottoNumber -> winningLottoNumbers.stream().anyMatch(Predicate.isEqual(purchasedLottoNumber)))
                .count();
    }
    private boolean isContainBonusNumber(List<Integer> purchasedLottoNumbers, int bonusNumber) {
        return purchasedLottoNumbers.contains(bonusNumber);
    }

    private void validatePurchaseAmount(int purchaseAmount) {
        if(purchaseAmount%LOTTO_TICKET_PRICE!=0)
            throw new IllegalArgumentException("[ERROR] 구매금액은 로또가격단위여야합니다.");
    }
}
