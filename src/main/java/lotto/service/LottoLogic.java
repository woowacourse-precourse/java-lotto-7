package lotto.service;

import java.util.List;
public class LottoLogic {
    public int[] winning(List<List<Integer>> lottoNumbers, int bonus, List<Integer> numbers) {
        int[] result = new int[Prize.values().length];
        for (List<Integer> lotto : lottoNumbers) {
            int cnt = 0;
            for (Integer number : lotto) {
                if (numbers.contains(number)) {
                    cnt += 1;
                }
            }
            boolean isBonus = lotto.contains(bonus);

            for (Prize prize : Prize.values()) {
                if (prize.getCnt() == cnt && prize.isBonus() == isBonus) {
                    result[prize.ordinal()] += 1;
                    break;
                }
            }
        }
        return result;
    }
}
