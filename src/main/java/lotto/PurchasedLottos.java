package lotto;

import java.util.List;
import java.util.stream.Collectors;

public class PurchasedLottos {
    private final List<Lotto> purchasedLottos;

    public PurchasedLottos(List<Lotto> lotto){
        this.purchasedLottos = lotto;
    }

    public List<Lotto> getPurchasedLottos() {
        return purchasedLottos;
    }
}
