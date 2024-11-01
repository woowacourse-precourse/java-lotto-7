package lotto.utils;

import lotto.domain.LottoNumber;

import java.util.Set;

@FunctionalInterface
public class LottoNumbersGenerator {
    Set<LottoNumber> generate(int size);
}
