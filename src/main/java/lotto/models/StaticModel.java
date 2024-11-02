package lotto.models;

import lotto.views.OutputView.Prize;
import java.util.*;

public class StaticModel {

    private final HashMap<Prize, Integer> prizeStatic = new HashMap<>();

    public StaticModel(ArrayList<ArrayList<Integer>> allIssuedLottos, List<Integer> lotto, int bonus) {
        initPrizeStatic();
        calculate(allIssuedLottos, lotto, bonus);
    }

    private void initPrizeStatic() {
        prizeStatic.put(Prize.Three, 0);
        prizeStatic.put(Prize.Four, 0);
        prizeStatic.put(Prize.Five, 0);
        prizeStatic.put(Prize.FiveAndBonus, 0);
        prizeStatic.put(Prize.Six, 0);
    }

    private HashSet<Integer> makeSet(List<Integer> numbers) {
        return new HashSet<>(numbers);
    }

    private void calculate(ArrayList<ArrayList<Integer>> allIssuedLottos, List<Integer> lotto, int bonus) {
        Set<Integer> winningSet = makeSet(lotto);

        for (List<Integer> issuedLotto : allIssuedLottos) {
            Set<Integer> issuedSet = makeSet(issuedLotto);
            int matchedCount = (int) issuedSet.stream().filter(winningSet::contains).count();
            boolean bonusMatch = issuedSet.contains(bonus);
            updatePrizeStatic(matchedCount, bonusMatch);
        }
    }

    private void updatePrizeStatic(int matchedCount, boolean bonusMatch) {
        switch (matchedCount) {
            case 3 -> prizeStatic.put(Prize.Three, prizeStatic.get(Prize.Three) + 1);
            case 4 -> prizeStatic.put(Prize.Four, prizeStatic.get(Prize.Four) + 1);
            case 5 -> {
                if (bonusMatch) {
                    prizeStatic.put(Prize.FiveAndBonus, prizeStatic.get(Prize.FiveAndBonus) + 1);
                } else {
                    prizeStatic.put(Prize.Five, prizeStatic.get(Prize.Five) + 1);
                }
            }
            case 6 -> prizeStatic.put(Prize.Six, prizeStatic.get(Prize.Six) + 1);
        }
    }

    public HashMap<Prize, Integer> getPrizeStatic() {
        return prizeStatic;
    }
}
