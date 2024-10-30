package lotto.Controller;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Model.Lotto;
import lotto.Model.MyLottos;
import lotto.View.OutputLottoView;

import java.util.List;

public class IssueTicketController {
    MyLottos myLottos = new MyLottos();
    OutputLottoView outputLottoView = new OutputLottoView();

    public MyLottos issueTickets(int numberOfTicket) {
        myLottos = new MyLottos();
        for (int i = 0; i < numberOfTicket; i++) {
            myLottos.addLotto(new Lotto(makeRandomNumbers()));
        }
        outputLottoView.printMylottos(myLottos);
        return myLottos;
    }


    private List<Integer> makeRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

}
