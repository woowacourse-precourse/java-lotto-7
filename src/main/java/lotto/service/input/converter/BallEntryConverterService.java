package lotto.service.input.converter;

import java.util.List;
import java.util.stream.Stream;

public class BallEntryConverterService implements InputConverterService<List<Integer>> {

    private final BallInputConverterService ballInputConverterService = new BallInputConverterService();

    @Override
    public List<Integer> convert(String input) {
        return Stream.of(input.split(","))
                .map(ballInputConverterService::convert)
                .toList();
    }
}