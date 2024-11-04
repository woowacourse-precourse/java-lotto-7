package lotto.Service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Model.Lotto;
import lotto.Model.MyLottos;

import java.util.List;

public class IssueMyLottoService {
    public MyLottos issueMyLottos(int numberOfTicket) {
        MyLottos myLottos = new MyLottos();
        for (int i = 0; i < numberOfTicket; i++) {
            myLottos.addLotto(new Lotto(makeRandomNumbers()));
        }
        return myLottos;
    }

    private List<Integer> makeRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public int getNumberOfTickets(int price) {
        return price / 1000;
    }

}
