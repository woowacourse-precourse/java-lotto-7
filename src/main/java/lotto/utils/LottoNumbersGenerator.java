package lotto.utils;

import lotto.domain.LottoNumber;

import java.util.Set;

@FunctionalInterface
public interface LottoNumbersGenerator {
    Set<LottoNumber> generate(int size);
}
