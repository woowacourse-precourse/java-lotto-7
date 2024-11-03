package lotto;

import java.util.ArrayList;
import java.util.List;
import validator.BonusValidator;
import validator.PaymentValidator;
import validator.PrizeNumberValidator;

public class Lotto {
    private final PrizeNumber prizeNumber;
    private final List<LottoTicket> lottoTicketBundle;
    private final Integer bonusNumber;

    public Lotto(
            List<Integer> prizeNumber,
            List<LottoTicket> lottoTicketBundle,
            Integer bonusNumber
    ) {
        PrizeNumberValidator.validate(prizeNumber);
        BonusValidator.validate(bonusNumber, prizeNumber);

        this.prizeNumber = new PrizeNumber(prizeNumber);
        this.lottoTicketBundle = lottoTicketBundle;
        this.bonusNumber = bonusNumber;
    }

    public void play() {

        TicketPrizeMatcher ticketPrizeMatcher = new TicketPrizeMatcher(
                prizeNumber,
                lottoTicketBundle,
                bonusNumber
        );
        MatchResult matchResult = ticketPrizeMatcher.matchAll();
        Output output = new Output();
        output.printMatchResult(matchResult);
    }
}
