package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class InputView {

    public static final String COMMON_NUMBER_FORMAT_ERROR_MESSAGE = "[ERROR] 숫자 형식이 아닙니다";
    public Long readPayment() {
        System.out.println("로또를 구매할 금액을 1,000원 단위로 입력해주세요");

        String readLine = Console.readLine();
        try {
            return Long.parseLong(readLine);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(COMMON_NUMBER_FORMAT_ERROR_MESSAGE);
        }
    }

    public List<Integer> readTargetNumber() {
        System.out.println("당첨 번호 1 ~ 45 범위의 중복되지 않는 숫자 6개를 당첨번호로 입력해주세요");

        String readLine = Console.readLine();
        String[] split = readLine.split(",");

        try {
            return Arrays.stream(split)
                    .map(Integer::parseInt)
                    .toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(COMMON_NUMBER_FORMAT_ERROR_MESSAGE + " ,를 구분자로 하여 숫자를 입력해주세요");
        }
    }

    public int readBonusNumber() {
        System.out.println("1 ~ 45 범위의 당첨번호와 중복되지 않는 보너스 번호를 입력해주세요");

        String readLine = Console.readLine();
        try {
            return Integer.parseInt(readLine);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(COMMON_NUMBER_FORMAT_ERROR_MESSAGE);
        }
    }
}
