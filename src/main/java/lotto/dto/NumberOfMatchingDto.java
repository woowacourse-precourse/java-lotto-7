package lotto.dto;

import java.util.List;

public record NumberOfMatchingDto(List<Integer> numberOfMatching) {
    private static NumberOfMatchingDto numberOfMatchingDto;

    public NumberOfMatchingDto {
        numberOfMatchingDto = new NumberOfMatchingDto(numberOfMatching);
    }

    public static NumberOfMatchingDto getNumberOfMatchingDto() {
        return numberOfMatchingDto;
    }
}
