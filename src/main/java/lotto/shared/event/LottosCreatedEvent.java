package lotto.shared.event;

import lotto.checker.domain.Lottos;

public class LottosCreatedEvent implements DomainEvent {

    private final Lottos lottos;

    public Lottos getLottos() {
        return lottos;
    }

    public LottosCreatedEvent(Lottos lottos) {
        this.lottos = lottos;
    }
}
