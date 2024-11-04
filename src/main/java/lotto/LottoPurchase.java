package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoPurchase {

    private static final int LOTTO_PRICE = 1000;
    private final int amount;
    private final List<Lotto> lottos;

    private LottoPurchase(int amount) {
        this.amount = amount;
        this.lottos = createLottos(amount / LOTTO_PRICE);
    }

    public static int calculateLottoQuantity(int purchasePrice) {
        return purchasePrice / LOTTO_PRICE;
    }

    public static LottoPurchase of(int amount) {
        validateAmount(amount);
        return new LottoPurchase(amount);
    }

    private static void validateAmount(int amount) {
        if (amount < LOTTO_PRICE || amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위여야 합니다.");
        }
    }

    private List<Lotto> createLottos(int quantity) {
        return IntStream.range(0, quantity)
                .mapToObj(i -> new Lotto(generateNumbers()))
                .collect(Collectors.toList());
    }

    private List<Integer> generateNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6).stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int getAmount() {
        return amount;
    }
}
