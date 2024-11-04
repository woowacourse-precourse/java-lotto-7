package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {
    Integer cost;
    List<Lotto> lottos = new ArrayList<>();

    LottoGenerator(int cost) {
        this.cost = cost;
        generate(cost);
        printGeneratedLottos();
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    private void printGeneratedLottos() {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    private void generate(Integer cost) {
        int attempt = cost / 1000;
        System.out.printf("%d개를 구매했습니다.%n", attempt);

        for (int i = 0; i < attempt; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottos.add(new Lotto(numbers));
        }
    }

    public float getCost() {
        return this.cost;
    }
}
