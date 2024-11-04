package lotto.dto;

import java.util.List;
import lotto.domain.Lotties;
import lotto.domain.Lotto;
import lotto.domain.Ticket;

public class PublishedLottiesDTO {
    private final Lotties randomLotties;
    private final Ticket publishedTicket;

    private PublishedLottiesDTO(Lotties randomLotties, Ticket publishedTicket) {
        this.publishedTicket = publishedTicket;
        this.randomLotties = randomLotties;
    }

    public static PublishedLottiesDTO from(Lotties randomLotties, Ticket publishedTicket) {
        return new PublishedLottiesDTO(randomLotties, publishedTicket);
    }

    public int getPublishedTicket() {
        return publishedTicket.getTicket();
    }

    public List<Lotto> getRandomLotties() {
        return randomLotties.getLotties();
    }
}
