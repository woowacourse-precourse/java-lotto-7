package lotto.service.input.validator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class BallEntryValidator extends CommonValidator implements InputValidatorService{

    private final String separator = ",";
    private static List<String> ballInputEntry;

    @Override
    public void validate(String input) {
        ballInputEntry = new ArrayList<>();

        super.validate(input);

        wrongNumberCount(input);
        overcomeSeparatorCount(input);
        ballInputEntry = verifiedEntry(input);
    }

    private void wrongNumberCount(String input) {
        List<String> ballEntries = List.of(input.split(separator));
        if(ballEntries.size() != ValidateStatus.TOTAL_BALL_COUNT.get()) {
            throw new IllegalArgumentException("[ERROR] 공의 갯수가 잘못 입력되었습니다.");
        }
    }

    private void overcomeSeparatorCount(String input) {
        if(Arrays.stream(input.split("")).filter(s -> s.equals(separator)).count() != ValidateStatus.TOTAL_SEPARATOR_COUNT.get()) {
            throw new IllegalArgumentException("[ERROR] 구분자 갯수가 일치하지 않습니다.");
        }
    }

    private List<String> verifiedEntry(String input) {
        List<String> inputNumbers = List.of(input.split(separator));

        sameNumberExistInEntry(inputNumbers);
        rangeCheck(inputNumbers);
        return inputNumbers;
    }

    private void rangeCheck(List<String> inputNumbers) {
        for (String ball: inputNumbers) {
            isHigherThanBoundary(ball);
            isLowerThanBoundary(ball);
        }
    }

    private void isHigherThanBoundary(String input) {
        if (Integer.parseInt(input) > ValidateStatus.MAXIMUM_NUMBER.get()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1 ~ 45 사이의 숫자를 입력해주십시오.");
        }
    }

    private void isLowerThanBoundary(String input) {
        if (Integer.parseInt(input) < ValidateStatus.MINIMAL_NUMBER.get()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1 ~ 45 사이의 숫자를 입력해주십시오.");
        }
    }

    private void sameNumberExistInEntry(List<String> inputNumbers) {
        if(new HashSet<>(inputNumbers).size() != inputNumbers.size()) {
            throw new IllegalArgumentException("[ERROR] 한 게임에서 동일한 번호는 입력할 수 없습니다. ");
        }
    }

    public static List<String> getBallInputEntry() {
        return ballInputEntry;
    }
}
