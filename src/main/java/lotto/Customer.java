package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Customer {
    private List<Lotto> lottos;

    public Customer() {
        lottos = new ArrayList<>();
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public void buyLottos(String money) {
        int count = LottoTicketFactory.getLottoTicketCount(money);

        while (count > 0) {
            Lotto lotto = makeLotto();
            lottos.add(lotto);
            count--;
        }

        printLottoInfo(lottos.size());
    }

    public Lotto makeLotto() {
        List<Integer> lottoNums = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(lottoNums);
    }

    public void printLottoInfo(int count) {
        System.out.println(count + "를 구매했습니다.");

        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
        System.out.println();
    }
}
