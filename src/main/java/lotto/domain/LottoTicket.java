package lotto.domain;

import java.util.Collections;
import java.util.List;

public class LottoTicket {

  private final List<Lotto> tickets;

  public LottoTicket(List<Lotto> tickets) {
    this.tickets = List.copyOf(tickets);
  }

  public List<Lotto> getTickets() {
    return Collections.unmodifiableList(tickets);
  }
}
