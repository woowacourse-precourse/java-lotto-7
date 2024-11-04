package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoTicketBundle {
    public static List<LottoTicket> getLottoTicketBundle(Integer ticket) {
        LottoTicketGenerator lottoTicketGenerator = new LottoTicketGenerator();
        List<LottoTicket> lottoTicketBundle = new ArrayList<>();

        for (int i = 0; i < ticket; i += 1) {
            lottoTicketBundle.add(lottoTicketGenerator.generate());
        }
        Output.outputTicketNumbers(lottoTicketBundle);
        return lottoTicketBundle;
    }
}
