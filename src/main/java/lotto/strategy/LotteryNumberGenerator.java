package lotto.strategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class LotteryNumberGenerator {

    public static List<List<Integer>> generateNumbers(int amount) {
        List<List<Integer>> numbersGroup = new ArrayList<>();

        for (int i = 0 ; i < amount ; i++) {
            List<Integer> lotteryNumbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1,45,6));
            Collections.sort(lotteryNumbers);
            numbersGroup.add(lotteryNumbers); // 이중 리스트 형식으로 생성된 로또 번호 저장
        }
        return numbersGroup;
    }
}
