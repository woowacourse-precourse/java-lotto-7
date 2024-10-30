package lotto.service;

import java.util.List;

public interface LottoNumGenerator {
    List<Integer> generateSortedNumbers(int min, int max, int cnt);
}
