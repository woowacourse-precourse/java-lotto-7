package lotto.Controller;

import lotto.Model.Lotto;
import lotto.Model.MyLottos;
import lotto.View.OutputWinningTotalView;

import java.util.*;

public class WinningTotalController {
    public Map<String, Integer> winningTotal(MyLottos mylottos, Lotto winningLotto, int bonusNumber) {
        Map<String, Integer> resultMap = calculateWinningTotal(mylottos, winningLotto, bonusNumber);
        OutputWinningTotalView outputWinningTotalView = new OutputWinningTotalView(resultMap);
        outputWinningTotalView.printWinningTotal();

        return resultMap;
    }

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
        List<String> prizeNames = new ArrayList<>(List.of("FIRST", "SECOND", "FOURTH", "FIFTH"));
        if (matchSize == 1 && comparingSet.add(bonusNumber)) {
            resultMap.put("THIRD", resultMap.get("THIRD") + 1);
        }
        resultMap.put(prizeNames.get(matchSize), resultMap.get(prizeNames.get(matchSize)) + 1);
    }

    private Map<String, Integer> makeResultMap() {
        Map<String, Integer> resultMap = new HashMap<>(
                Map.of(
                        "FIRST", 0,
                        "SECOND", 0,
                        "THIRD", 0,
                        "FOURTH", 0,
                        "FIFTH", 0
                )
        );
        return resultMap;
    }
}
