package lotto.service;

import java.util.List;

public interface LottoNumGenerator {
    List<Integer> generateNumbers(int min, int max, int cnt);
}
