package lotto.service.calculator;

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

    private static final Long INIT_PLACE_NUMBER = 0L;
    private static final Integer THREE_MATCH = 3;
    private static final Integer FOUR_MATCH = 4;
    private static final Integer FIVE_MATCH = 5;
    private static final Integer SIX_MATCH = 6;

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
            places.put(place, INIT_PLACE_NUMBER);
        }
        placeAuctions.put(SIX_MATCH, new FirstPlace(places));
        placeAuctions.put(FIVE_MATCH, new SecondPlace(places, bonusResult));
        placeAuctions.put(FOUR_MATCH, new FourthPlace(places));
        placeAuctions.put(THREE_MATCH, new FifthPlace(places));
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
