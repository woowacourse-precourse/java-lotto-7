package lotto.controller;

public class MoneyCount {
    private MoneyCount() {}

    public static Integer countTimes(Integer cost){
        return cost / 1000;
    }
}