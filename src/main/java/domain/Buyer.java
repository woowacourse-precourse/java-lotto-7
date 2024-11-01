package domain;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import util.LottoGenerator;
import common.validate.ErrorMessage;

public class Buyer {
    private static final int PURCHASE_UNIT = 1000;
    private static final int ZERO = 0;

    private final List<Lotto> lottos;
    private final int amount;

    private Buyer(List<Lotto> lottos, int amount) {
        this.lottos = lottos;
        this.amount = amount;
    }

    public static Buyer buyLotto(int amount) {
        validate(amount);
        return new Buyer(LottoGenerator.getLottos(amount / PURCHASE_UNIT), amount);
    }

    public List<Rank> getRanks(List<Integer> winningNumber, int bonus) {
        return lottos.stream()
                .map(lotto -> lotto.getRank(winningNumber, bonus))
                .filter(rank -> rank != Rank.NOTHING)
                .sorted(Comparator.comparingInt(Rank::getMatchedCount))
                .toList();
    }

    public int getAmount() {
        return amount;
    }

    public int getQuantity() {
        return lottos.size();
    }

    @Override
    public String toString() {
        return lottos.stream()
                .map(Lotto::toString)
                .collect(Collectors.joining("\n"));
    }

    private static void validate(int amount) {
        if (isAmountUnit(amount)) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_AMOUNT_ERROR_MESSAGE.format(PURCHASE_UNIT));
        }
    }

    private static boolean isAmountUnit(int amount) {
        return amount % PURCHASE_UNIT != ZERO || amount == ZERO;
    }
}
