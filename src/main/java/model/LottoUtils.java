package model;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class LottoUtils {

    public List<Integer> compareLists(List<List<Integer>> userNumbersList, List<Integer> winningNumbers, int bonusNumber) {
        List<Integer> result = new ArrayList<>(List.of(0, 0, 0, 0, 0)); // 5개의 원소가 모두 0으로 초기화된 리스트

        for (List<Integer> userNumbers : userNumbersList) {
            Set<Integer> userSet = Set.copyOf(userNumbers);


            long matchCount = userSet.stream()
                    .filter(winningNumbers::contains)
                    .count();

            if (matchCount == 3) {
                result.set(0, result.get(0) + 1); // 3개 일치
            }
            if (matchCount == 4) {
                result.set(1, result.get(1) + 1); // 4개 일치
            }
            if (matchCount == 5 && !userSet.contains(bonusNumber)) {
                result.set(2, result.get(2) + 1); // 5개 일치 (보너스 번호 불일치)
            }
            if (matchCount == 5 && userSet.contains(bonusNumber)) {
                result.set(3, result.get(3) + 1); // 5개 + 보너스 일치
            }
            if (matchCount == 6) {
                result.set(4, result.get(4) + 1); // 6개 일치
            }
        }

        return result;
    }
}