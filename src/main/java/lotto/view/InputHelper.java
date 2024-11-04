package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.ErrorMessage;
import lotto.exception.LottoException;
import lotto.validate.Validator;

import java.util.Arrays;
import java.util.List;

public class InputHelper {
    private final String PURCHASE_MESSAGE = "구입금액을 입력해 주세요.";
    private final String WINNING_MESSAGE = "당첨 번호를 입력해 주세요.";
    private final String BONUS_MESSAGE = "보너스 번호를 입력해 주세요.";
    private final String DELIMITER = ",";

    /**
     * 로또 구입 금액 입력받는 메서드
     *
     * @return 로또 구입 금액
     */
    public int getPurchase() {
        System.out.println(PURCHASE_MESSAGE);

        String input = getInput();
        validateNumber(input);

        int money = Integer.parseInt(input);
        validateNatural(money);

        return money;
    }

    /**
     * 로또 당첨 번호 입력받는 메서드
     *
     * @return 당첨 번호 리스트
     */
    public List<Integer> getWinner() {
        System.out.println(WINNING_MESSAGE);

        String input = getInput();
        validateFormat(input);

        return Arrays.stream(input.split(DELIMITER)).mapToInt(Integer::parseInt).boxed().toList();
    }

    /**
     * 보너스 번호 입력받는 메서드
     *
     * @return 보너스 번호
     */
    public int getBonus() {
        System.out.println(BONUS_MESSAGE);

        String input = getInput();
        validateNumber(input);

        int bonus = Integer.parseInt(input);
        validateNatural(bonus);

        return bonus;
    }

    /**
     * 숫자인지 검사(음수 안됨)
     *
     * @param s 검사할 문자열
     */
    private void validateNumber(String s) {
        if (!Validator.isNum(s)) {
            throw new LottoException(ErrorMessage.NOT_NUM);
        }
    }

    /**
     * 숫자가 자연수 즉 1이상인 숫자인지 검사
     *
     * @param n 검사할 정수
     */
    private void validateNatural(int n) {
        if (!Validator.isNaturalNum(n)) {
            throw new LottoException(ErrorMessage.NOT_NATURAL_NUM);
        }
    }

    /**
     * 리스트 입력 방식에 맞는지 검사
     *
     * @param s 검사할 문자열
     */
    private void validateFormat(String s) {
        if (!Validator.isList(s)) {
            throw new LottoException(ErrorMessage.NOT_INPUT_FORMAT);
        }
    }

    /**
     * 입력을 받은 후 줄바꿈 처리를 위한 메서드
     * @return 입력받은 문자열
     */
    private String getInput() {
        String input = Console.readLine();
        System.out.println();
        return input;
    }
}
