package lotto;

import java.util.*;

public class LottoCompare {

    public List<Integer> compareLottoNumbers(List<Integer> numbers, List<List<Integer>> lottoNumbers, int bonusNumber) {
        List<Integer> result = new ArrayList<>();

        for (List<Integer> lotto : lottoNumbers) {
            List<Integer> tempNumbers = new ArrayList<>(numbers);
            tempNumbers.retainAll(lotto);

            if (tempNumbers.size() > 2) {
                result.add(tempNumbers.size());
            }
        }

        return result;
    }

    public boolean isBonusMatched(List<Integer> lotto, int bonusNumber) {
        return lotto.contains(bonusNumber);
    }

    public Map<WinningType, Integer> storeNumbers(List<Integer> matchCounts, List<List<Integer>> lottoNumbers, int bonusNumber) {
        Map<WinningType, Integer> counts = new EnumMap<>(WinningType.class);
        for (WinningType type : WinningType.values()) {
            counts.put(type, 0);
        }
        for (int i = 0; i < matchCounts.size(); i++) {
            int count = matchCounts.get(i);
            List<Integer> lotto = lottoNumbers.get(i);
            if (count == 5 && isBonusMatched(lotto, bonusNumber)) {
                count += 2;
            }
            WinningType type = WinningType.fromCount(count);
            if (type != null) {
                counts.put(type, counts.get(type) + 1);
            }
        }
        return counts;
    }
}