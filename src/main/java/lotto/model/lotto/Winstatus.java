package lotto.model.lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.common.WinMoney;

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

            String key = mappingCountToKey(correctCount, bonusCount);

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

    private static String mappingCountToKey(int count, int bonusCount) {
        if (count == 3) {
            return WinMoney.THREECOUNTKEY.getWinMoneyStr();
        } else if (count == 4) {
            return WinMoney.FOURCOUNTKEY.getWinMoneyStr();
        } else if (count == 5) {
            return WinMoney.FIVECOUNTKEY.getWinMoneyStr();
        } else if (count == 5 && bonusCount == 1) {
            return WinMoney.FIVEANDBONUSKEY.getWinMoneyStr();
        } else if (count == 6) {
            return WinMoney.SIXCOUNTKEY.getWinMoneyStr();
        }

        return "";

    }

    public static String mappingKeyToMoneyString(String key) {
        if (key.equals(WinMoney.THREECOUNTKEY.getWinMoneyStr())) {
            return WinMoney.THREERIGHT.getWinMoneyStr();
        } else if (key.equals(WinMoney.FOURCOUNTKEY.getWinMoneyStr())) {
            return WinMoney.FOURGRIGHT.getWinMoneyStr();
        } else if (key.equals(WinMoney.FIVECOUNTKEY.getWinMoneyStr())) {
            return WinMoney.FIVERIGHT.getWinMoneyStr();
        } else if (key.equals(WinMoney.FIVEANDBONUSKEY.getWinMoneyStr())) {
            return WinMoney.FIVEWRIGHTANDBONUS.getWinMoneyStr();
        } else if (key.equals(WinMoney.SIXCOUNTKEY.getWinMoneyStr())) {
            return WinMoney.SIXRIGHT.getWinMoneyStr();
        }

        return "";
    }

    public Map<String, Integer> getStatus() {
        return status;
    }
}
