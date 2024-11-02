package lotto.model.lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.model.util.Mapping;

public class Winstatus {

    private Map<String, Integer> status;


    public Winstatus() {
        status = new HashMap<>();
    }

    public void checkWin(Lottos lottos) {
        List<Integer> winNumbers = lottos.getWinNumbers();

        for (Lotto lotto : lottos.getLottos()) {

            int correctCount = 0;
            int bonusCount = 0;

            for (int lottoNum : lotto.getNumbers()) {
                if (winNumbers.contains(lottoNum)) {
                    correctCount++;
                }
            }

            if (checkBonusNum(lottos.getBonusNumber(), lotto.getNumbers())) {
                bonusCount++;
            }

            String key = Mapping.mappingCountToKey(correctCount, bonusCount);

            if (key.isEmpty()) {
                continue;
            } else if (status.containsKey(key)) {
                status.put(key, status.get(key) + 1);
            } else if (!status.containsKey(key)) {
                status.put(key, 1);
            }


        }

    }

    private boolean checkBonusNum(int bonusNum, List<Integer> lottoNumbers) {
        for (int lottoNum : lottoNumbers) {
            if (lottoNum == bonusNum) {
                return true;
            }
        }
        return false;
    }





    public Map<String, Integer> getStatus() {
        return status;
    }
}
