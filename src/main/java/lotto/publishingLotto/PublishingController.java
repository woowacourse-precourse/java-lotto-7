package lotto.publishingLotto;

import java.util.List;
import lotto.publishingLotto.model.Lotto;
import lotto.view.Publishing_OutputTicketsView;

public class PublishingController {
    private final Publishing_OutputTicketsView outputPublishedTicketsView;
    private final int numberOfTickets;

    public PublishingController(Publishing_OutputTicketsView outputPublishedTicketsView, int numberOfTickets) {
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
