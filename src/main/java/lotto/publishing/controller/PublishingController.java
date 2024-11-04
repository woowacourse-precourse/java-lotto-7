package lotto.publishing.controller;

import java.util.List;
import lotto.common.model.Lotto;
import lotto.publishing.PublishingService;
import lotto.publishing.view.PublishingOutputTicketsView;

public class PublishingController {
    private final PublishingOutputTicketsView outputPublishedTicketsView;
    private final int numberOfTickets;

    public PublishingController(PublishingOutputTicketsView outputPublishedTicketsView, int numberOfTickets) {
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
