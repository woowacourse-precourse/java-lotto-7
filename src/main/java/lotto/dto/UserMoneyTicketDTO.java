package lotto.dto;

import lotto.domain.Ticket;
import lotto.vo.Money;

public class UserMoneyTicketDTO {
    private final Money userMoney;
    private final Ticket publishedTicket;

    public UserMoneyTicketDTO(Money userMoney, Ticket publishedTicket) {
        this.userMoney = userMoney;
        this.publishedTicket = publishedTicket;
    }

    public Money getUserMoney() {
        return userMoney;
    }

    public Ticket getPublishedTicket() {
        return publishedTicket;
    }
}
