package lotto.controller;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;
import static lotto.Application.bonusNumber;
import static lotto.Application.lottos;
import static lotto.Application.rankCounter;
import static lotto.Application.winningLotto;

import java.util.ArrayList;
import java.util.List;

import lotto.model.Lotto;
import lotto.model.Rank;
import static lotto.controller.Validater.stringToNum;

public class LogicControl {

    public static void makeLotto(int lotto_cost) {
        for (int i = lotto_cost; i - 1000 >= 0; i -= 1000) {
            Lotto element = new Lotto(pickUniqueNumbersInRange(1, 45, 6));
            lottos.add(element);
        }
    }

    public static List<Integer> stringToNumbers(List<String> numbers_string) {
        List<Integer> numbers = new ArrayList<Integer>();
        for (String e : numbers_string) {
            int element = stringToNum(e);
            numbers.add(element);
        }
        return numbers;
    }

    public static void initializeMap() {
        for (Rank rank : Rank.values()) {
            rankCounter.put(rank, 0);
        }
    }

    public static void checkWinning() {
        initializeMap();

        int winningCount = 0;
        for (Lotto lotto : lottos) {
            winningCount = 0;
            winningCount += winningLotto.checkLotto(lotto);

            Rank rank = Rank.checkRank(winningCount, lotto.checkNumber(bonusNumber));
            rankCounter.put(rank, rankCounter.get(rank) + 1);
        }
    }

    public static double calculateBenfit() {
        double benefit = 0;
        for (Rank rank : rankCounter.keySet()) {
            if (rank != Rank.MISS)
                benefit += Rank.calculatePrize(rank, rankCounter.get(rank));
        }
        return benefit;
    }
}
