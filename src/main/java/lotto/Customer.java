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

    public void buyLotto(String money) {
        int count = LottoTicketFactory.getLottoTicketCount(money);

        while(count > 0) {
            List<Integer> lottoNums = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(lottoNums);
            lottos.add(lotto);
            count--;
        }

        printLottoInfo(lottos.size());
    }

    public void printLottoInfo(int count) {
        System.out.println(count + "를 구매했습니다.");

        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
        System.out.println();
    }
}
