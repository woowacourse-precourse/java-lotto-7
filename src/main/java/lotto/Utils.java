package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.stream.Collectors;
import lotto.Model.Lotto;
import lotto.Model.Rank;
import java.text.NumberFormat;

public class Utils {
    public static List<Integer> setLottoNums() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public static void printLottos(List<Lotto> lottos) {
        System.out.println();
        System.out.println(lottos.size() + Constants.LOTTO_AMOUNT_OUTPUT);
        lottos.stream().forEach(lotto -> lotto.printLotto());
    }

    public static ArrayList<Integer> toArrayList(String nums) {
        return Arrays.stream(nums.split(Constants.DELIMITER)).map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayList::new));
    }


    public static String printRanktoString(Rank rank, EnumMap<Rank, Integer> enumMap) {
        String prizeFormatted = NumberFormat.getInstance().format(rank.getPrize());
        StringBuilder result = new StringBuilder();
        result.append(rank.getMatchCount()).append("개 일치");
        if (rank == Rank.SECOND) {
            result.append(", 보너스 볼 일치");
        }
        result.append(" (").append(prizeFormatted).append("원) - ").append(enumMap.getOrDefault(rank, 0)).append("개");

        return result.toString();
    }

    public static void printRevenue(Long revenue, int lottoAmount) {
        double rate = (double) revenue / lottoAmount * 100;
        System.out.printf("총 수익률은 %.1f%%입니다.%n", Math.round(rate) / 1000.0);
    }
}
