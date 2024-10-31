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

        return new Lotto(Randoms.pickUniqueNumbersInRange(Lotto.LOW_NUMBER, Lotto.HIGH_NUMBER, 6));

    }

    public static void addNumber(Lotto lotto, int number) {
        lotto.setBonus(number);
    }
}
