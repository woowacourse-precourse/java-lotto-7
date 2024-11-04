package lotto.model;

import java.util.*;

public class LottoChecker {

    public void lottoCheckingProcess(List<Lotto> allLottos, List<Integer> winningNumbers, Integer bonusNumber, LottoResult lottoResult) {
        if (allLottos.isEmpty()) {
            throw new IllegalStateException("[ERROR] 로또 목록이 비어 있어 당첨 결과를 처리할 수 없습니다.");
        }
        for (Lotto lotto : allLottos) {
            Map<String, Object> result = analyzeLottoResult(lotto, winningNumbers, bonusNumber);
            lottoResult.recordResult((Integer) result.get("matchCount"), (Boolean) result.get("isBonusMatched"));
        }
    }

    public Map<String, Object> analyzeLottoResult(Lotto lotto, List<Integer> winningNumbers, Integer bonusNumber) {
        Integer matchCount = checkMatchCount(lotto, winningNumbers);
        Boolean isBonusMatched = checkBonusMatch(lotto, bonusNumber);

        // 결과를 Map에 저장
        Map<String, Object> result = new HashMap<>();
        result.put("matchCount", matchCount);
        result.put("isBonusMatched", isBonusMatched);
        return result;
    }

    public boolean checkBonusMatch(Lotto lotto, Integer bonusNumber) {
        return lotto.getNumbers().contains(bonusNumber);
    }

    public Integer checkMatchCount(Lotto lottoInput, List<Integer> winningNumbersInput) {
        List<Integer> lottoNumbers = lottoInput.getNumbers();
        int matchCount = 0;

        for (Integer number : lottoNumbers) {
            if (winningNumbersInput.contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }
}