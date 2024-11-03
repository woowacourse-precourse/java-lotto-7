package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.constant.LottoSystemConstant;
import lotto.domain.Lotto;
import lotto.domain.Rank;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.constant.ErrorMessage.BONUS_NUMBER_OUT_OF_BOUND;
import static lotto.constant.ErrorMessage.DUPLICATE_BONUS_NUMBER_INPUT;
import static lotto.constant.LottoSystemConstant.*;

public class LottoService {
    private final List<Lotto> purchasedLottos = new ArrayList<>();
    private Lotto winningLotto;
    private int bonusNumber;

    public LottoService() {}

    public void purchaseLottos(int amount) {
        int numberOfLotto = amount / LOTTO_PRICE;

        for (int i = 0; i < numberOfLotto; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(
                    LottoSystemConstant.LOTTO_LOWER_BOUNDARY,
                    LottoSystemConstant.LOTTO_UPPER_BOUNDARY,
                    LottoSystemConstant.LOTTO_PICK_COUNT
            );

            Lotto generatedLotto = new Lotto(numbers);

            purchasedLottos.add(generatedLotto);
        }
    }

    public void setWinningLotto(Lotto winningLotto) {
        this.winningLotto = winningLotto;
    }

    public void setBonusNumber(int bonusNumber) {
        validateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(int bonusNumber) {
        validateBonusNumberBoundary(bonusNumber);
        validateNonDuplicateBonusNumber(bonusNumber);
    }

    private void validateBonusNumberBoundary(int bonusNumber) {
        if(bonusNumber < LOTTO_LOWER_BOUNDARY || bonusNumber > LOTTO_UPPER_BOUNDARY) {
            throw new IllegalArgumentException(BONUS_NUMBER_OUT_OF_BOUND);
        }
    }

    private void validateNonDuplicateBonusNumber(int bonusNumber) {
        if (winningLotto.checkMatchNumber(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATE_BONUS_NUMBER_INPUT);
        }
    }

    public List<Lotto> getPurchasedLottos() {
        return purchasedLottos;
    }

    public List<Rank> calculateRankOfLottos() {
        List<Rank> ranks = purchasedLottos.stream()
                .map(lotto -> lotto.checkRank(winningLotto, bonusNumber))
                .collect(Collectors.toList());

        return ranks;
    }

    public long calculateTotalPrize() {
        List<Rank> rankOfLottos = calculateRankOfLottos();
        long totalPrize = 0;

        for (Rank rank: rankOfLottos) {
            totalPrize += rank.getPrize();
        }

        return totalPrize;
    }
}
