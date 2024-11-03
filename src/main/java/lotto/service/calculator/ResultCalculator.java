package lotto.service.calculator;

import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.message.Place;
import lotto.strategy.FifthPlace;
import lotto.strategy.FirstPlace;
import lotto.strategy.FourthPlace;
import lotto.strategy.PlaceAuction;
import lotto.strategy.SecondPlace;

public class ResultCalculator {

    private final EnumMap<Place, Long> places = new EnumMap<>(Place.class);
    private final Map<Integer, PlaceAuction> placeAuctions = new HashMap<>();

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

    public EnumMap<Place, Long> getPlaces() {
        return places;
    }
}
