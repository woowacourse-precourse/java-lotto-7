package lotto.model.db;

import static lotto.constant.UserId.BUYER;

import java.util.List;
import lotto.Lotto;
import lotto.constant.UserId;

public class Buyer implements User {

    private final UserId id;
    private List<Lotto> lotties;

    private Buyer(UserId userId, List<Lotto> lotties) {
        this.id = userId;
        this.lotties = lotties;
    }

    public static Buyer from(List<Lotto> lotties) {
        return new Buyer(BUYER, lotties);
    }

    public static Buyer from(Lotto lotto) {
        return new Buyer(BUYER, List.of(lotto));
    }

    @Override
    public UserId getId() {
        return id;
    }

    public List<Lotto> getLotties() {
        return lotties;
    }

    public int getLottoCnt() {
        return lotties.size();
    }
}
