package lotto.random;

import java.util.List;

@FunctionalInterface
public interface LottoRandom {

    int DEFAULT_COUNT = 6;
    int LOTTO_NUMBER_START_INCLUSIVE = 1;
    int LOTTO_NUMBER_END_INCLUSIVE = 45;

    List<Integer> getLottoNumbers();
}
