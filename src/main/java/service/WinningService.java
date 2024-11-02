package service;


import domain.Lotto;
import domain.Lottos;
import domain.Ticket;
import utils.RandomNumber;

public class WinningService {

    private Lottos lottos = new Lottos();

    public Lottos generateLottoNumber(int purchaseAmount) {
        Ticket ticket = Ticket.from(purchaseAmount);
        for(int i=0; i<ticket.getQuantity(); i++) {
            Lotto lotto = Lotto.from(RandomNumber.create());
            lottos.addLotto(lotto);
        }
        return lottos;

    }
}
