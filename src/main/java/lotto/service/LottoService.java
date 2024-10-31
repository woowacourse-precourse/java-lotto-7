package lotto.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.enums.PrizeAmount;
import lotto.model.Lotto;
import camp.nextstep.edu.missionutils.Randoms;

public class LottoService {

    ValidateService validateService = new ValidateService();

    // 로또 발행
    public List<Lotto> lottoIssuance (int M) {
        List<Lotto> newLotto = new ArrayList<>();
        for (int i = 0; i < M / 1000; i++) {
            List<Integer> pickNum = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            pickNum.sort(Comparator.naturalOrder());
            Lotto lotto = new Lotto(pickNum);
            newLotto.add(lotto);
        }
        return newLotto;
    }

    // 당첨 여부 검사
    public Set<PrizeAmount> lottoWinning(List<Lotto> newLotto, List<Integer> numbers, int bonus) {
        Set<PrizeAmount> prizeAmounts = new HashSet<>();
        for (Lotto lotto: newLotto) {
            int count = lottoWinNumber(lotto, numbers);
            boolean isBonus = isBounsWinnig(numbers, bonus);
            prizeAmounts.add(countPrize(prizeAmounts, count, isBonus));
        }

        return prizeAmounts;
    }

    // 당첨 횟수 갱신
    public PrizeAmount countPrize(Set<PrizeAmount> prizeAmounts, int count, boolean isBonus) {
        PrizeAmount prizeA = cntPrizeAmount(count, isBonus);
        if (prizeAmounts.contains(prizeA)) {
            prizeAmounts.remove(prizeA);
            prizeA.setCount(prizeA.getCount() + 1);
        }
        return prizeA;
    }

    // 로또 번호 두 개 비교하여 몇개 맞는지 반환
    public int lottoWinNumber(Lotto lotto, List<Integer> numbers) {
        List<Integer> common = new ArrayList<>(lotto.getNumbers());
        common.retainAll(numbers);
        return common.size();
    }

    // Bonus 번호 맞는지 반환
    public boolean isBounsWinnig(List<Integer> numbers, int bonus) {
        for (int num: numbers) {
            if (bonus == num) { return true; }
        }
        return false;
    }

    // count에 맞는 prizeAmount 반환
    public PrizeAmount cntPrizeAmount(int count, boolean isBonus) {
        if (count == 3) {
            return PrizeAmount.THREE_MATCH;
        } else if (count == 4) {
            return PrizeAmount.FOUR_MATCH;
        } else if (count == 5 && !isBonus) {
            return PrizeAmount.FIVE_MATCH;
        } else if (count == 5 && isBonus) {
            return PrizeAmount.FIVE_BONUS_MATCH;
        } else if (count == 6) {
            return PrizeAmount.SIX_MATCH;
        }
        return null;
    }
}
