package lotto.domain;

@FunctionalInterface
public interface LottoGenerator {

    Lotto generate(final int min, final int max, final int count);
}
