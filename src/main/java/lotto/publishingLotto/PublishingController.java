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

    }
}
