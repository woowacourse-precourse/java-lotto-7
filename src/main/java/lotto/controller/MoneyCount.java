package lotto.controller;

public class MoneyCount {
    private MoneyCount() {}

    public Integer countTimes(Integer cost){
        return cost / 1000;
    }
}