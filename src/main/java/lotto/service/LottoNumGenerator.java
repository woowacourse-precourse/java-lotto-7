package lotto.service;

import java.util.List;

public interface LottoNumGenerator {
    List<Integer> generateNumbers(final int min, final int max, final int cnt);
}
