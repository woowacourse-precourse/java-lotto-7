package lotto.dto;

import java.util.List;

public class NumberOfMatchingDto {
    private static List<Integer> numberOfMatching;

    public static void set(List<Integer> numberOfMatching) {
        NumberOfMatchingDto.numberOfMatching = numberOfMatching;
    }

    public static List<Integer> getNumberOfMatching() {
        return numberOfMatching;
    }
}
