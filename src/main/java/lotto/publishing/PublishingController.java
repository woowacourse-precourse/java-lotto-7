package lotto.publishing;

import java.util.List;
import lotto.common.model.Lotto;

public class PublishingController {
    private final Publishing_OutputTicketsView outputPublishedTicketsView;
    private final int numberOfTickets;

    public PublishingController(Publishing_OutputTicketsView outputPublishedTicketsView, int numberOfTickets) {
        this.outputPublishedTicketsView = outputPublishedTicketsView;
        this.numberOfTickets = numberOfTickets;
    }

    public List<Lotto> publishLottoTickets() {
        PublishingService publishing = PublishingService.getPublishingService();
        List<Lotto> LottoTickets = publishing.publishByNumberOfTickets(numberOfTickets);
        printLottoTickets(LottoTickets);
        return LottoTickets;
    }

    private void printLottoTickets(List<Lotto> LottoTickets) {
        for (Lotto LottoTicket : LottoTickets) {
            List<Integer> numbers = LottoTicket.getNumbers();
            outputPublishedTicketsView.printLottoNumbers(numbers);
        }
    }
}
