package lotto;

import lotto.domain.LottoTicket;
import lotto.external.RandomNumbersGenerator;

public class Application {

    public static void main(String[] args) {

        LottoTicket lottoTicket = new LottoTicket(3, new RandomNumbersGenerator());
        
    }

}
