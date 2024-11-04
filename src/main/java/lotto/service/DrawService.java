package lotto.service;

import lotto.Lotto;

import java.util.ArrayList;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.DrawModel;

public class DrawService {
    public Lotto createRandomNumbers() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }

    public void createLotto(int ticketCount) {
        ArrayList<Lotto> lottos = new ArrayList();
        for (int i = 0; i < ticketCount; i++) {
            lottos.add(createRandomNumbers());
        }
        DrawModel.setLottos(lottos);
    }

    public void printLotto(int ticketCount) {
        System.out.println();
        System.out.println(ticketCount + "개를 구매했습니다.");
        for (Lotto lotto : DrawModel.getLottos()) {
            System.out.println(lotto.getNumbers());
        }
    }
}
