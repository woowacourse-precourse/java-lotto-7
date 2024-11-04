package lotto.service.printer;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import lotto.message.Place;
import lotto.message.PrintMessage;

public class ResultPrinter {

    private final EnumMap<Place, Long> places;

    private ResultPrinter(EnumMap<Place, Long> places) {
        this.places = places;
    }

    public static ResultPrinter create(EnumMap<Place, Long> places) {
        return new ResultPrinter(places);
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
}
