package lotto.domain.ticket;

public class Ticket {
    private final Long id;
    private final Lottos lottos;

    private Ticket(Long id, Lottos lottos) {
        this.id = id;
        this.lottos = lottos;
    }

    public static Ticket issue(Long id, Lottos lottos) {
        return new Ticket(id, lottos);
    }

    public Long getId() {
        return id;
    }

    public Lottos getLottos() {
        return lottos;
    }
    
}
