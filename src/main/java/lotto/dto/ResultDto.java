package lotto.dto;

import java.util.ArrayList;
import java.util.List;
import lotto.rank.Rank;

public class ResultDto {
    List<Result> results;
    double yield;

    public ResultDto() {
        this.yield = 0;
        this.results = new ArrayList<>();
        for (var rank : Rank.getOrderedRanks()) {
            this.results.add(new Result(rank));
        }
    }


    public void addRank(Rank rank) {
        results.stream()
                .filter(result -> result.isSame(rank))
                .forEach(Result::countUp);
    }

    public double getYield() {
        return yield;
    }

    public void setYield(double yield) {
        this.yield = yield;
    }

    public List<Result> getResults() {
        return results;
    }
}
