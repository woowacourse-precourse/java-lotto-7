package lotto.service.calculator;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.message.Place;
import lotto.message.PrintMessage;
import lotto.message.Prize;
import lotto.strategy.FifthPlace;
import lotto.strategy.FirstPlace;
import lotto.strategy.FourthPlace;
import lotto.strategy.PlaceAuction;
import lotto.strategy.SecondPlace;

public class ResultCalculator {

    private final EnumMap<Place, Long> places = new EnumMap<>(Place.class);
    private final Map<Integer, PlaceAuction> placeAuctions = new HashMap<>();
    private final EnumMap<Place, Long> prize = Prize.getPrize();

    private ResultCalculator(List<Integer> winningResult, List<Integer> bonusResult) {
        init(bonusResult);
        calculate(winningResult, bonusResult);
    }

    public static ResultCalculator create(List<Integer> winningResult, List<Integer> bonusResult) {
        return new ResultCalculator(winningResult, bonusResult);
    }

    private void init(List<Integer> bonusResult) {
        for (Place place : Place.values()) {
            places.put(place, 0L);
        }
        placeAuctions.put(6, new FirstPlace(places));
        placeAuctions.put(5, new SecondPlace(places, bonusResult));
        placeAuctions.put(4, new FourthPlace(places));
        placeAuctions.put(3, new FifthPlace(places));
    }

    private void calculate(List<Integer> winningResult, List<Integer> bonusResult) {
        int totalCount = winningResult.size();
        for (int count = 0; count < totalCount; count++) {
            int winning = winningResult.get(count);
            update(winning, count);
        }
    }

    private void update(Integer winning, Integer count) {
        if (placeAuctions.containsKey(winning)) {
            PlaceAuction placeAuction = placeAuctions.get(winning);
            placeAuction.add(count);
        }
    }

    private String setDetail(PrintMessage printMessage, Place place) {
        return String.format(printMessage.getMessage(), places.get(place));
    }

    public List<String> getDetail() {
        List<String> printResult = new ArrayList<>();
        printResult.add(setDetail(PrintMessage.LOTTO_FIFTH_PLACE_WINNING, Place.FIFTH_PLACE));
        printResult.add(setDetail(PrintMessage.LOTTO_FOURTH_PLACE_WINNING, Place.FOURTH_PLACE));
        printResult.add(setDetail(PrintMessage.LOTTO_THIRD_PLACE_WINNING, Place.THIRD_PLACE));
        printResult.add(setDetail(PrintMessage.LOTTO_SECOND_PLACE_WINNING, Place.SECOND_PLACE));
        printResult.add(setDetail(PrintMessage.LOTTO_FIRST_PLACE_WINNING, Place.FIRST_PLACE));
        return printResult;
    }

    public Long getPrizeMoney() {
        long prizeMoney = 0;
        for (Place place : Place.values()) {
            prizeMoney += places.get(place) * prize.get(place);
        }
        return prizeMoney;
    }
}
