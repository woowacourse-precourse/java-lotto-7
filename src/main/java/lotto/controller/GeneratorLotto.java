package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.model.Lotto;
import lotto.view.OutputView;

public class GeneratorLotto {
    private static final int MINIMUM_AMOUNT = 1000;
    public static List<Lotto> createLotto(int purchaseAmount) {
        int createLotto = purchaseAmount / MINIMUM_AMOUNT;
        OutputView.getBuyCountMessage(createLotto);
        ArrayList<Lotto> lotto = new ArrayList<>();
        for (int i = 0; i < createLotto; i++) {
            lotto.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }
        for (Lotto Lotto : lotto) {
            System.out.println(Lotto);
        }
        return lotto;
    }
}