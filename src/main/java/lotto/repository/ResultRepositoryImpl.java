package lotto.repository;

import lotto.domain.Money;
import lotto.domain.Rank;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

public class ResultRepositoryImpl implements ResultRepository{
    private final Map<Rank, Integer> result;

    public ResultRepositoryImpl() {
        result = new EnumMap<>(Rank.class);
        for (Rank rank : Rank.values()){
            result.put(rank, 0);
        }
    }

    @Override
    public void addResult(Rank rank) {
        result.put(rank, result.get(rank) + 1);
    }

    @Override
    public Map<Rank, Integer> getResult() {
        return result;
    }


    @Override
    public double calculate(Money money) {
        double sum = 0;

        for (Rank rank : Rank.values()){
            sum += rank.getPrice() * result.get(rank);
        }

        return (sum / (double) money.getPrice()) * 100;
    }
}
