package lotto.domain.lotto;

public interface LottoFactory {

    Lotto create(int startInclusive, int endInclusive, int count);

}
