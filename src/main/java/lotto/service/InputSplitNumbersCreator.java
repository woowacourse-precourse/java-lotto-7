package lotto.service;

import java.util.Arrays;
import java.util.List;

import lotto.domain.lotto.LottoBall;

public class InputSplitNumbersCreator implements NumbersCreator {

    private final String input;

    public InputSplitNumbersCreator(final String input) {
        this.input = input;
    }

    @Override
    public List<Integer> create() {
        return Arrays.stream(input.split(","))
                .map(String::strip)
                .map(this::parseInt)
                .toList();
    }

    private int parseInt(final String splitInput) {
        try {
            return Integer.parseInt(splitInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(
                    String.format("입력하신 %s는 범위를 초과했습니다. %d 이하의 값을 입력하세요.",
                            splitInput, LottoBall.NUMBER_END_INCLUSIVE));
        }
    }

}
