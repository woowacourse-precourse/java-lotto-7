package lotto.util.function;

import java.util.List;

@FunctionalInterface
public interface LottoNumberSupplier {

    int LOTTO_SIZE = 6;
    int MIN_NUMBER = 1;
    int MAX_NUMBER = 45;

    List<Integer> getLottoNumbers();
}
