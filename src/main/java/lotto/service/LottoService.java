package lotto.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
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
            List<Integer> modifiableList = new ArrayList<>(pickNum);
            Collections.sort(modifiableList);
            Lotto lotto = new Lotto(modifiableList);
            newLotto.add(lotto);
        }
        return newLotto;
    }

    // 당첨 여부 검사
    public Map<PrizeAmount, Integer> lottoWinning(List<Lotto> newLotto, List<Integer> numbers, int bonus) {
        Map<PrizeAmount, Integer> prizeAmounts = initPrizeAmounts();
        for (Lotto lotto : newLotto) {
            int count = lottoWinNumber(lotto, numbers);
            boolean isBonus = isBonusWinning(numbers, bonus);
            PrizeAmount prizeA = cntPrizeAmount(count, isBonus);

            if (prizeA != null) {
                prizeAmounts.put(prizeA, prizeAmounts.getOrDefault(prizeA, 0) + 1);
            }
        }
        return prizeAmounts;
    }

    public Map<PrizeAmount, Integer> initPrizeAmounts() {
        Map<PrizeAmount, Integer> prizeAmounts = new LinkedHashMap<>();
        prizeAmounts.put(PrizeAmount.THREE_MATCH, 0);
        prizeAmounts.put(PrizeAmount.FOUR_MATCH, 0);
        prizeAmounts.put(PrizeAmount.FIVE_MATCH, 0);
        prizeAmounts.put(PrizeAmount.FIVE_BONUS_MATCH, 0);
        prizeAmounts.put(PrizeAmount.SIX_MATCH, 0);
        return prizeAmounts;
    }

    // 로또 번호 두 개 비교하여 몇개 맞는지 반환
    public int lottoWinNumber(Lotto lotto, List<Integer> numbers) {
        List<Integer> common = lotto.getNumbers();
        common.retainAll(numbers);
        return common.size();
    }

    // Bonus 번호 맞는지 반환
    public boolean isBonusWinning(List<Integer> numbers, int bonus) {
        return numbers.contains(bonus);
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
