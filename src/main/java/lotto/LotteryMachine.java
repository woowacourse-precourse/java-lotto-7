package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LotteryMachine {

    private final List<Lotto> lottos;

    public LotteryMachine() {
        this.lottos = new ArrayList<>();
    }


    private int drawCount(int purchaseAmount) {
        return purchaseAmount / 1000;
        // 추후 1,000원 단위 조건 체크 필요.
    }

    public void drawLottos(int purchaseAmount) {
        int count = drawCount(purchaseAmount);

        for (int i = 0; i < count; i++) {
            Lotto lotto = new Lotto(pickRandomNumbers());
            lottos.add(lotto);
        }
    }

    public void printLottos() {

    }

    private List<Integer> pickRandomNumbers() {
        List<Integer> lotto = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(lotto);

        return lotto;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

}
