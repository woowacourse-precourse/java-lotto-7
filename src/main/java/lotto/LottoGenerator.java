package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGenerator {
    private final List<Lotto> Lottos;

    public LottoGenerator(int amount) {
        validate(amount);

        int count = calculateLottoCount(amount);
        List<Lotto> tmpLottoList = new ArrayList<>(count);

        for (int i = 0; i < count; i++) {
            List<Integer> tmpList = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(tmpList);

            tmpLottoList.add(new Lotto(tmpList));
        }
        this.Lottos = tmpLottoList;
    }

    private void validate(int amount) {
        if (amount%1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구매 금액은 1,000원 단위로 입력해야 합니다.");
        }
    }

    private int calculateLottoCount(int amount) {
        return amount/1000;
    }

    public void getLottos() {
        System.out.println(Lottos.size() + "개를 구매했습니다.");

        for(Lotto lotto : Lottos) {
            System.out.println(lotto);
        }
    }

}
