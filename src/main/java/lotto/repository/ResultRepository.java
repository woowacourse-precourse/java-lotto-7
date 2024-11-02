package lotto.repository;

import lotto.domain.Money;
import lotto.domain.Rank;

import java.util.Map;
import java.util.Optional;

public interface ResultRepository {

    void addResult(Rank rank);

    Map<Rank, Integer> getResult();

    double calculate(Money money);
}
