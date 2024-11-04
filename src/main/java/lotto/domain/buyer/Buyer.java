package lotto.domain.buyer;

import java.util.Objects;
import lotto.domain.lotto.Lottos;

public class Buyer {
    private final LottosCount LottosCount;
    private final Lottos buyLottos;

    Buyer(final LottosCount LottosCount, Lottos buyLottos) {
        this.LottosCount = LottosCount;
        this.buyLottos = buyLottos;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final Buyer otherBuyer = (Buyer) obj;
        return Objects.equals(LottosCount, otherBuyer.LottosCount) &&
                Objects.equals(buyLottos, otherBuyer.buyLottos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(LottosCount, buyLottos);
    }

    public int getLottosCount() {
        return LottosCount.getLottosCount();
    }

    public Lottos getbuyLottos() {
        return buyLottos;
    }
}
