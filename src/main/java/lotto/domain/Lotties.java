package lotto.domain;

import java.util.List;
import java.util.stream.Stream;

public class Lotties {

    private static final int LOTTO_PRICE = 1_000;
    private static final RandomLottoSupplier LOTTO_SUPPLIER = new RandomLottoSupplier();

    private final List<Lotto> values;

    public Lotties(List<Lotto> values) {
        this.values = values;
    }

    public static Lotties from(int totalPrice) {
        int countOfLotto = findCountOfLotto(totalPrice);
        List<Lotto> values = Stream.generate(LOTTO_SUPPLIER::supply)
                .limit(countOfLotto)
                .toList();

        return new Lotties(values);
    }

    private static int findCountOfLotto(int totalPrice) {
        if (totalPrice % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("로또의 가격은 %d 단위여야 합니다".formatted(LOTTO_PRICE));
        }

        return totalPrice / LOTTO_PRICE;
    }

    public List<Numbers> getLottoNumbers() {
        return values.stream()
                .map(Lotto::getNumbers)
                .toList();
    }

    public long getTotalLottoPrice() {
        return (long) values.size() * LOTTO_PRICE;
    }

    public List<List<Integer>> getLottiesNumbers() {
        return values.stream()
                .map(Lotto::getLottoNumbers)
                .toList();
    }
}
