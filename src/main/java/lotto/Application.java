package lotto;

import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.domain.machine.LottoMachine;
import lotto.domain.machine.impl.RandomNumberGenerator;
import lotto.domain.machine.Ticket;
import lotto.domain.machine.impl.SimpleNumberGenerator;
import lotto.domain.winning.WinningNumber;

public class Application {

    public static void main(String[] args) {
        int count = new Ticket(5_000).getCount();
        LottoMachine lottoMachine = new LottoMachine(new RandomNumberGenerator());
        List<Lotto> lottos = lottoMachine.issueLottos(count);
        System.out.println(lottos);

        // 당첨 번호
        SimpleNumberGenerator simpleNumberGenerator = new SimpleNumberGenerator();
        simpleNumberGenerator.setNumbers(List.of(1, 2, 3, 4, 5, 6));

        LottoMachine winningLottoMachine = new LottoMachine(simpleNumberGenerator);
        Lotto winningLotto = winningLottoMachine.issueLotto();
        int bonusNumber = 7;
        WinningNumber winningNumber = new WinningNumber(winningLotto, bonusNumber);
    }

}
