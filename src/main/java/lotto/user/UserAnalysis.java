package lotto.user;

import java.util.List;
import lotto.MessageCenter;
import lotto.committee.PrizeMoney;

public class UserAnalysis {

    private final Integer FIRST_WON = PrizeMoney.FIRST_PRIZE.getWon();
    private final Integer SECOND_WON = PrizeMoney.SECOND_PRIZE.getWon();
    private final Integer THIRD_WON = PrizeMoney.THIRD_PRIZE.getWon();
    private final Integer FOURTH_WON = PrizeMoney.FOURTH_PRIZE.getWon();
    private final Integer FIFTH_WON = PrizeMoney.FIFTH_PRIZE.getWon();


    public void getAnalysis(PrizeHistory prizeHistory) {
        Double rateResult = calculate(prizeHistory);
        MessageCenter.printRate(rateResult);
    }

    private Double calculate(PrizeHistory prizeHistory) {

        List<Integer> totalWon = sumEach(prizeHistory);
        Integer sumResult = sum(totalWon);

        return getRate(sumResult);
    }

    private List<Integer> sumEach(PrizeHistory prizeHistory) {

        Integer firstCount = prizeHistory.getFirst();
        Integer secondCount = prizeHistory.getSecond();
        Integer thirdCount = prizeHistory.getThird();
        Integer fourthCount = prizeHistory.getFourth();
        Integer fifthCount = prizeHistory.getFifth();

        Integer first = multiply(firstCount, FIRST_WON);
        Integer second = multiply(secondCount, SECOND_WON);
        Integer third = multiply(thirdCount, THIRD_WON);
        Integer fourth = multiply(fourthCount, FOURTH_WON);
        Integer fifth = multiply(fifthCount, FIFTH_WON);

        return List.of(first, second, third, fourth, fifth);
    }

    private Double getRate(Integer sumResult) {
        Double rawPercent = divide(sumResult, UserStorage.getTotalPaid());
        return Math.round(rawPercent * 10000) / 100.0;
    }

    private Double divide(Integer sumResult, Integer totalPaid) {
        Double sum = sumResult.doubleValue();
        Double paid = totalPaid.doubleValue();

        return (sum / paid);
    }

    private Integer sum(List<Integer> totalWon) {
        return totalWon.stream().mapToInt(Integer::intValue).sum();
    }

    public Integer multiply(Integer count, Integer won) {
        return (count * won);
    };



}
