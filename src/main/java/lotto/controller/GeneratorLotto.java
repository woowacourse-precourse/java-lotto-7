package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import lotto.model.Lotto;

public class GeneratorLotto {
    private static final int MINIMUM_AMOUNT = 1000;
    static void createLotto(int purchaseAmount) {
        int createLotto = purchaseAmount / MINIMUM_AMOUNT;
        System.out.println(createLotto + "개를 구매했습니다.");
        ArrayList<Lotto> lotto = new ArrayList<>();
        for (int i = 0; i < createLotto; i++) {
            lotto.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }
        for (Lotto lotto1 : lotto) {
            System.out.println(lotto1);
        }
    }
}