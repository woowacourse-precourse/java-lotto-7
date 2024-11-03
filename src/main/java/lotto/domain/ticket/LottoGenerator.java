package lotto.domain.ticket;

@FunctionalInterface
public interface LottoGenerator {
    Lotto generate();
}
