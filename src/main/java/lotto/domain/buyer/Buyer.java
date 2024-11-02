package lotto.domain.buyer;

import java.util.List;
import java.util.Objects;
import lotto.domain.lotto.Lotto;

public class Buyer {
    private final LottosCount LottosCount;
    private final BuyLottos buyLottos;

    Buyer(final LottosCount LottosCount, BuyLottos buyLottos) {
        this.LottosCount = LottosCount;
        this.buyLottos = buyLottos;
    }

    public int getLottosCount() {
        return LottosCount.getLottosCount();
    }

    public List<Lotto> getbuyLottos() {
        return buyLottos.getLottos();
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
}
