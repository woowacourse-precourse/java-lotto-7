package lotto.model;

import java.util.HashMap;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.UserLotto;

// Output에 필요한 메서드 모음
public class OutputModel {

    // 유저 로또 리스트를 출력
    public void showUserLotto(UserLotto userLotto) {
        for (Lotto lotto : userLotto.getUserLotto()) {
            System.out.println(lotto);
        }
    }

    // 유저의 결과 계산 및 출력
    public void getResult(List<Integer> winnerCount, List<Boolean> matchBonus) {
        HashMap<String, Integer> matchCounts = initMatchCounts();

        for (int i = 0; i < winnerCount.size(); i++) {
            setMatchCounts(winnerCount.get(i), matchBonus.get(i), matchCounts);
        }
        showResult(matchCounts);
        showMargin(matchCounts, winnerCount.size());
    }

    private void setMatchCounts(int count, boolean matchBonus, HashMap<String, Integer> matchCounts) {
        if (isFirst(count, matchCounts)) {
            return;
        }
        if (isSecondOrThird(count, matchCounts, matchBonus)) {
            return;
        }
        if (isFourth(count, matchCounts)) {
            return;
        }
        isFifth(count, matchCounts);
    }

    private HashMap<String, Integer> initMatchCounts() {
        HashMap<String, Integer> matchCounts = new HashMap<>();
        matchCounts.put("FIFTH", 0);
        matchCounts.put("FOURTH", 0);
        matchCounts.put("THIRD", 0);
        matchCounts.put("SECOND", 0);
        matchCounts.put("FIRST", 0);

        return matchCounts;
    }

    private boolean isFirst(int count, HashMap<String, Integer> matchCounts) {
        if (count == Prize.FIRST.getCount()) {
            matchCounts.put("FIRST", matchCounts.get("FIRST") + 1);
            return true;
        }
        return false;
    }

    private boolean isSecondOrThird(int count, HashMap<String, Integer> matchCounts, boolean bonus) {
        if (count == Prize.SECOND.getCount()) {
            return checkBonusNumber(bonus, matchCounts);
        }
        return false;
    }

    private boolean checkBonusNumber(boolean bonus, HashMap<String, Integer> matchCounts) {
        if (bonus) {
            matchCounts.put("SECOND", matchCounts.get("SECOND") + 1);
            return true;
        }
        matchCounts.put("THIRD", matchCounts.get("THIRD") + 1);
        return true;
    }

    private boolean isFourth(int count, HashMap<String, Integer> matchCounts) {
        if (count == Prize.FOURTH.getCount()) {
            matchCounts.put("FOURTH", matchCounts.get("FOURTH") + 1);
            return true;
        }
        return false;
    }

    private void isFifth(int count, HashMap<String, Integer> matchCounts) {
        if (count == Prize.FIFTH.getCount()) {
            matchCounts.put("FIFTH", matchCounts.get("FIFTH") + 1);
        }
    }

    private void showResult(HashMap<String, Integer> matchCounts) {
        System.out.println(Prize.FIFTH.toString() + matchCounts.get("FIFTH") + "개");
        System.out.println(Prize.FOURTH.toString() + matchCounts.get("FOURTH") + "개");
        System.out.println(Prize.THIRD.toString() + matchCounts.get("THIRD") + "개");
        System.out.println(Prize.SECOND.toString() + matchCounts.get("SECOND") + "개");
        System.out.println(Prize.FIRST.toString() + matchCounts.get("FIRST") + "개");
    }

    private void showMargin(HashMap<String, Integer> matchCounts, int numberOfLotto) {
        double margin = 0;

        margin = (matchCounts.get("FIRST") * Prize.FIRST.getPrizeMoney())
                + (matchCounts.get("SECOND") * Prize.SECOND.getPrizeMoney())
                + (matchCounts.get("THIRD") * Prize.THIRD.getPrizeMoney())
                + (matchCounts.get("FOURTH") * Prize.FOURTH.getPrizeMoney())
                + (matchCounts.get("FIFTH") * Prize.FIFTH.getPrizeMoney());
        margin /= (numberOfLotto * 1000);
        margin *= 100;

        System.out.println("총 수익률은 " + String.format("%.1f", margin) + "%입니다.");
    }
}
