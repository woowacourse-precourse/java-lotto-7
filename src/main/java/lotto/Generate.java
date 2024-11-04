package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Generate {

    public List<Lotto> lottos(int cost) {
        List<Lotto> lottos = new ArrayList<>();
        cost = cost / 1000;
        System.out.println(cost + "개를 구매했습니다.");

        for (int i = 0; i < cost; i++) {
            List<Integer> randomNumbers = new ArrayList<>(randomNumbers());
            Collections.sort(randomNumbers);

            lottos.add(new Lotto(randomNumbers));
            System.out.println(randomNumbers);

        }

        return lottos;
    }


    private List<Integer> randomNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
