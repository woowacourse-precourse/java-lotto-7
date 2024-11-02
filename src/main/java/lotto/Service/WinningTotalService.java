package lotto.Service;

import lotto.Enum.WinningPrize;
import lotto.Model.Lotto;
import lotto.Model.MyLottos;

import java.util.*;

public class WinningTotalService {
    public Map<String, Integer> calculateWinningTotal(MyLottos mylottos, Lotto winningLotto, int bonusNumber) {
        Set<Integer> comparingSet;
        Map<String, Integer> resultMap = makeResultMap();

        for (Lotto myLotto : mylottos.getLottos()) {
            comparingSet = new HashSet<>(winningLotto.getNumbers());
            comparingSet.addAll(myLotto.getNumbers());
            int matchSize = comparingSet.size() - 6;
            if (matchSize <= 3) {
                addResultMap(comparingSet, resultMap, matchSize, bonusNumber);
            }
        }

        return resultMap;
    }

    private void addResultMap(Set<Integer> comparingSet, Map<String, Integer> resultMap, int matchSize, int bonusNumber) {
        String prizeName = WinningPrize.getNameByMatchNumber(matchSize);
        if (matchSize == 1 && comparingSet.add(bonusNumber)) {
            String thirdPrize = WinningPrize.getNameByMatchNumber(13);
            resultMap.put(thirdPrize, resultMap.get(thirdPrize + 1));
        }
        resultMap.put(prizeName, resultMap.get(prizeName) + 1);
    }

    private Map<String, Integer> makeResultMap() {
        Map<String, Integer> resultMap = new HashMap<>();
        for (WinningPrize prize : WinningPrize.values()) {
            resultMap.put(prize.toString(), 0);
        }
        return resultMap;
    }
}
