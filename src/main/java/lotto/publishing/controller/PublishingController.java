package lotto.publishing.controller;

import java.util.List;
import lotto.common.model.Lotto;
import lotto.dto.LottoTicketsDto;
import lotto.dto.NumberOfTicketsDto;
import lotto.publishing.model.Publishing;
import lotto.publishing.view.OutputPublishedTicketsView;

public class PublishingController {
    private final OutputPublishedTicketsView outputPublishedTicketsView;
    private final int numberOfTickets;

    public PublishingController() {
        this.outputPublishedTicketsView = new OutputPublishedTicketsView();
        this.numberOfTickets = NumberOfTicketsDto.getNumberOfTickets();
    }

    public void publishLottoTickets() {
        Publishing publishing = new Publishing(numberOfTickets);
        List<Lotto> LottoTickets = publishing.getLottoTickets();
        printLottoTickets(LottoTickets);
        LottoTicketsDto.set(LottoTickets);
    }

    private void printLottoTickets(List<Lotto> LottoTickets) {
        for (Lotto LottoTicket : LottoTickets) {
            List<Integer> numbers = LottoTicket.getNumbers();
            outputPublishedTicketsView.printLottoNumbers(numbers);
        }
    }
}
