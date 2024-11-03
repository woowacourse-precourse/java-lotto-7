package lotto;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoTicket;
import lotto.domain.WinningLotto;
import lotto.external.RandomNumbersGenerator;

public class Application {

    public static void main(String[] args) {

        LottoTicket lottoTicket = new LottoTicket(3, new RandomNumbersGenerator());

        WinningLotto winningLotto = new WinningLotto(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7
        );
        
    }

}
