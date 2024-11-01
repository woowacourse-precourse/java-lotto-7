package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class LottoController {
    private static final DecimalFormat formatter = new DecimalFormat("###,###");


    public static Lotto getRandom() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(numbers);
    }

    public static List<Lotto> getRandoms(int n) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            lottos.add(getRandom());
        }
        return lottos;
    }

    public static void printLotto(Lotto lotto) {
        System.out.println(lotto.numbersToString());
    }

    public static void printLottos(List<Lotto> lottos) {
        lottos.forEach(LottoController::printLotto);
    }

    public static void printPurchase(int n) {
        List<Lotto> lottos = getRandoms(n);

        System.out.println(n + "개를 구매했습니다.");
        printLottos(lottos);
    }

    public static void printStatistics(List<Lotto> lottos, Lotto winner, Integer bonusBall) {
        List<LottoRank> ranks = LottoRank.getRanks(lottos, winner, bonusBall);

        System.out.println("당첨통계");
        System.out.println("---");

        for (LottoRank rank : LottoRank.values()) {
            System.out.println(rank.getCondition() + " (" + formatter.format(rank.getPrice()) + "원) - " + getRankCount(ranks, rank) + "개");
        }
    }

    private static int getRankCount(List<LottoRank> ranks, LottoRank rank) {
        int count = 0;
        for (LottoRank r : ranks) {
            if (rank.equals(r)) {
                count++;
            }
        }
        return count;
    }
}


