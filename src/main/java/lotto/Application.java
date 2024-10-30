package lotto;

import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoMachine;
import lotto.domain.lotto.NumberGenerator;
import lotto.domain.lotto.Ticket;

public class Application {

    public static void main(String[] args) {
        int count = new Ticket(5_000).getCount();
        LottoMachine lottoMachine = new LottoMachine(new NumberGenerator());
        List<Lotto> lottos = lottoMachine.issueLottos(count);

        System.out.println(lottos);
    }

}
