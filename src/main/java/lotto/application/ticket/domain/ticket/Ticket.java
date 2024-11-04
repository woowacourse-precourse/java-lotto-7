package lotto.application.ticket.domain.ticket;

import static lotto.application.ticket.constants.Constants.BASIC_PRICE;
import static lotto.application.ticket.message.Message.CANT_NULL_ID;
import static lotto.application.ticket.message.Message.CANT_NULL_LOTTO;

import java.util.List;

public class Ticket {
    private final Long id;
    private final Lottos lottos;

    private Ticket(Long id, Lottos lottos) {
        this.id = id;
        this.lottos = lottos;
    }

    public static Ticket issue(Long id, Lottos lottos) {
        validate(id, lottos);
        return new Ticket(id, lottos);
    }

    public Long getId() {
        return id;
    }

    public List<Lotto> getLottosValue() {
        return lottos.getLottos();
    }


    public int getLottosSize() {
        return lottos.getLottosSize();
    }

    private static void validate(Long id, Lottos lottos) {
        validateId(id);
        validateLottos(lottos);
    }

    private static void validateId(Long id) {
        if (id == null) {
            throw new IllegalArgumentException(CANT_NULL_ID);
        }
    }

    private static void validateLottos(Lottos lottos) {
        if (lottos == null) {
            throw new IllegalArgumentException(CANT_NULL_LOTTO);
        }
    }

    public Lottos getLottos() {
        return lottos;
    }

    public int getTotalPrice() {
        return BASIC_PRICE * getLottosSize();
    }
}
