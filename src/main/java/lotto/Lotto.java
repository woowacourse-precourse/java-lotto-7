package lotto;

import java.util.ArrayList;
import java.util.List;
import validator.BonusValidator;
import validator.PaymentValidator;
import validator.PrizeNumberValidator;

public class Lotto {
    private final PrizeNumber prizeNumber;
    private final Integer pay;
    private final Integer bonusNumber;

    public Lotto(
            List<Integer> inputPrizeNumber,
            Integer pay,
            Integer getBonus
    ) {
        PrizeNumberValidator.validate(inputPrizeNumber);
        PaymentValidator.validate(pay);
        BonusValidator.validate(getBonus, inputPrizeNumber);

        this.prizeNumber = new PrizeNumber(inputPrizeNumber);
        this.pay = pay;
        this.bonusNumber = getBonus;
    }

    public void play() {
        List<LottoTicket> lottoTicketBundle = getLottoTicketBundle();
        TicketPrizeMatcher ticketPrizeMatcher = new TicketPrizeMatcher(
                prizeNumber,
                lottoTicketBundle,
                bonusNumber
        );
        MatchResult matchResult = ticketPrizeMatcher.matchAll();
        Output output = new Output();
        output.printMatchResult(matchResult);
    }

    private List<LottoTicket> getLottoTicketBundle() {
        LottoTicketGenerator lottoTicketGenerator = new LottoTicketGenerator();
        List<LottoTicket> lottoTicketBundle = new ArrayList<>();

        for (int i = 0; i < AbsoluteValue.TICKET_COUNT(pay); i += 1) {
            lottoTicketBundle.add(lottoTicketGenerator.generate());
        }
        Output.outputTicketNumbers(lottoTicketBundle);
        return lottoTicketBundle;
    }
}
