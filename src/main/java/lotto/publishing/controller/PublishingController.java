package lotto.publishing.controller;

import java.util.List;
import lotto.common.model.Lotto;
import lotto.dto.NumberOfTicketsDto;
import lotto.publishing.PublishingService;
import lotto.publishing.view.OutputPublishedTicketsView;

public class PublishingController {
    private final OutputPublishedTicketsView outputPublishedTicketsView;
    private final int numberOfTickets;

    public PublishingController() {
        this.outputPublishedTicketsView = new OutputPublishedTicketsView();
        NumberOfTicketsDto numberOfTicketsDto = NumberOfTicketsDto.getNumberOfTicketsDto();
        this.numberOfTickets =numberOfTicketsDto.numberOfTickets();
    }

    public List<Lotto> publishLottoTickets() {
        PublishingService publishingService = PublishingService.getPublishingService();
        List<Lotto> LottoTickets = publishingService.publishByNumberOfTickets(numberOfTickets);
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
