package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

class LottoGenerator {
    public static Lotto generate(String input, String regex) {
        List<Integer> list = new ArrayList<>();
        for (String number : input.split(regex)) {
            list.add(Integer.parseInt(number));
        }
        return new Lotto(list);
    }

    public static Lotto generateRandom() {
        List<Integer> list = new ArrayList<>();
        while (list.size() < 6) {
            int number = Randoms.pickNumberInRange(Lotto.LOW_NUMBER, Lotto.HIGH_NUMBER);
            if (!list.contains(number)) {
                list.add(number);
            }
        }
        return new Lotto(list);
    }

    public static void addNumber(Lotto lotto, int number){
        lotto.setBonus(number);
    }
}
