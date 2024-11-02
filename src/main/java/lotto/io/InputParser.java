package lotto.io;

import java.util.Arrays;
import java.util.List;

public class InputParser {

    private static final String SPLIT_REG = ",";

    public long convertStringToLong(String input) {
        try {
            return Long.parseLong(input.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("금액은 정수 형태로 입력해야 합니다.");
        }
    }

    public List<Integer> splitToInteger(String input) {
        String[] segments = input.split(SPLIT_REG);
        return Arrays.stream(segments).map(this::convertStringToInt).toList();
    }

    public int convertStringToInt(String input) {
        try {
            return Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }
}
