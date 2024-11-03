import java.util.List;
import lotto.Lotto;

public class User {

    private final List<Lotto> lottos;

    private final Integer purchaseCost;

    public User(List<Lotto> lottos, Integer purchaseCost) {
        this.lottos = lottos;
        this.purchaseCost = purchaseCost;
    }
}
