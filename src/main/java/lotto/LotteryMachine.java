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

    private int purchaseAmount(int moneyAmount) {
        return moneyAmount / 1000;
        // 추후 1,000원 단위 조건 체크 필요.
    }

    public void drawLottos(int moneyAmount) {
        int count = purchaseAmount(moneyAmount);

        for (int i = 0; i < count; i++) {
            List<Integer> lotto = pickRandomNumbers();
            lottos.add(new Lotto(lotto));
        }
    }

    public void printLottos() {
        for (int i = 0; i < lottos.size(); i++) {
            System.out.println(lottos.get(i).getNumbers());
        }
    }

    private List<Integer> pickRandomNumbers() {
        List<Integer> drawLotto = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(drawLotto);
        return drawLotto;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

}
