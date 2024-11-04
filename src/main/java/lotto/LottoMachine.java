package lotto;

import java.util.List;

public class LottoMachine {
    IOHandler ioHandler = new IOHandler();

    public void playLotto() {
        int payment = ioHandler.getPayment();

        int numberOfTicket = payment / 1000;
        LottoTickets lottoTickets = new LottoTickets(numberOfTicket);
        ioHandler.showGeneratedTickets(lottoTickets);


        List<Integer> lottoNumber = ioHandler.getLottoNumber();
        Lotto lotto = new Lotto(lottoNumber);

        int bonusNumber = ioHandler.getBonusNumber(lottoNumber);

        lottoTickets.decideLottoPlacesBy(lotto, bonusNumber);
        ioHandler.showLottoResult(lottoTickets);

    }
}
