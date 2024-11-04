package lotto;

import java.util.*;

public class LottoCompare {

    public List<Integer> compareLottoNumbers(List<Integer> numbers, List<List<Integer>> lottoNumbers, int bonusNumber) {
        List<Integer> result = new ArrayList<>();

        for (List<Integer> lotto : lottoNumbers) {
            List<Integer> tempNumbers = new ArrayList<>(numbers);
            tempNumbers.retainAll(lotto);

            if (tempNumbers.size() > 2) {
                result.add(compareBonusNumber(lotto, tempNumbers, bonusNumber));
            }
        }

        return result;
    }

    public int compareBonusNumber(List<Integer> lotto, List<Integer> tempNumbers, int bonusNumber) {
        if (lotto.contains(bonusNumber) && tempNumbers.size() == 5) {
            return tempNumbers.size() + 2;
        }
        return tempNumbers.size();
    }

    public Map<WinningType, Integer> storeNumbers(List<Integer> result) {
        Map<WinningType, Integer> counts = new EnumMap<>(WinningType.class);
        for (WinningType type : WinningType.values()) {
            counts.put(type, 0);
        }

        for (int count : result) {
            WinningType type = WinningType.fromCount(count);
            if (type != null) {
                counts.put(type, counts.get(type) + 1);
            }
        }

        return counts;
    }
}