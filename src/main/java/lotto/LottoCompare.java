package lotto;

import java.util.*;

public class LottoCompare {

    // 로또 번호 몇개 일치하는지 비교
    public List<Integer> compareLottoNumbers(List<Integer> numbers, List<List<Integer>> lottoNumbers, int bonusNumber) {
        List<Integer> result = new ArrayList<>();

        for (List<Integer> lotto : lottoNumbers) {
            List<Integer> tempNumbers = new ArrayList<>(numbers);
            tempNumbers.retainAll(lotto);  // 메인 당첨 번호 일치

            if (tempNumbers.size() > 2) {
                result.add(compareBonusNumber(lotto, tempNumbers, bonusNumber));
            }
        }

        return result;
    }

    // 보너스 번호 일치 여부 확인
    public int compareBonusNumber(List<Integer> lotto, List<Integer> tempNumbers, int bonusNumber) {
        if (lotto.contains(bonusNumber) && tempNumbers.size() == 5) {
            return tempNumbers.size() + 2;
        }
        return tempNumbers.size();
    }

    // enum 클래스로 상수로 넘겨주기
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