package lotto.controller;

import java.util.List;
import lotto.service.PublishingService;
import lotto.model.Lotto;
import lotto.view.Publishing_OutputTicketsView;

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
