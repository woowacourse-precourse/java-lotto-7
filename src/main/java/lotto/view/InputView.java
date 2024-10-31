package lotto.view;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static long money() {
        try {
            return Long.parseLong(input());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("구입금액은 숫자여야 합니다\n");
        }
    }

    public static List<Integer> winningNumbers() {
        try {
            return Arrays.stream(input().split(","))
                .mapToInt(Integer::parseInt)
                .boxed()
                .toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("당첨 번호는 숫자여야 합니다.");
        } catch (RuntimeException e) { // TODO:: split에서 발생하는 에러 캐치. 수정 필요
            throw new IllegalArgumentException("당첨 번호는 ,로 구분해야 합니다.");
        }
    }

    public static int bonusNumber() {
        try {
            return Integer.parseInt(input());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("보너스 번호는 숫자여야 합니다\n");
        }
    }

    private static String input() {
        return Console.readLine();
    }
}
