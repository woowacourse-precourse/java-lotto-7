package lotto.domain.buyer;

import java.util.Objects;

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

    public BuyLottos getbuyLottos() {
        return buyLottos;
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
