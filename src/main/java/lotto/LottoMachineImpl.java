package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoMachineImpl implements LottoMachine {
    private static final List<Lotto> lottoTickets = new ArrayList<>();

    @Override
    public List<Lotto> createLottoTickets(int count) {
        for (int i = 0; i < count; i++) {
            Lotto newLottoTicket = new Lotto(pickLottoNumbers());
            lottoTickets.add(newLottoTicket);
        }
        showCreateLottoTickets(count);

        return lottoTickets;
    }

    private List<Integer> pickLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    private void showCreateLottoTickets(int count) {
        System.out.println(count + "개를 구매했습니다.");

        for (Lotto lotto : lottoTickets) {
            System.out.println(lotto);
        }
    }
}
