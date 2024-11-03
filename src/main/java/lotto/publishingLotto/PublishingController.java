package lotto.publishingLotto;

import java.util.List;
import lotto.publishingLotto.model.Lotto;
import lotto.view.OutputPublishedTicketsView;

public class PublishingController {
    private final OutputPublishedTicketsView outputPublishedTicketsView;
    private final int numberOfTickets;

    public PublishingController(OutputPublishedTicketsView outputPublishedTicketsView, int numberOfTickets) {
        this.outputPublishedTicketsView = outputPublishedTicketsView;
        this.numberOfTickets = numberOfTickets;
    }

    public List<Lotto> publishLottoTickets() {
        PublishingService publishingService = PublishingService.getPublishingService();
        List<Lotto> LottoTickets = publishingService.publishByNumberOfTickets(numberOfTickets);
        printLottoTickets(LottoTickets);
        return LottoTickets;
    }

    private void printLottoTickets(List<Lotto> LottoTickets) {
        for (Lotto LottoTicket : LottoTickets) {
            List<Integer> lottoNumbers = LottoTicket.getNumbers();
            outputPublishedTicketsView.printLottoNumbers(lottoNumbers);
        }
    }
}
