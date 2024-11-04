package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import lotto.enums.LottoResult;

/**
 * class: LottoGame.
 *
 * 로또 게임의 진행을 관리하는 클래스
 * @author JBumLee
 * @version 2024/11/04
 */
public class LottoGame {
    private static final String PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    /**
     * 로또 게임을 시작한다.
     * 구매, 당첨 번호 입력, 결과 확인의 순서로 진행된다.
     */
    public void start() {
        Person person = createPerson();
        WinningLotto winningLotto = createWinningLotto();
        LottoResult result = person.checkWinning(winningLotto);
        result.printStatistics();
    }

    /**
     * 구매자를 생성한다.
     * 금액을 입력받고 유효성을 검증한다.
     *
     * @return 생성된 구매자
     * @throws IllegalArgumentException 올바르지 않은 금액이 입력된 경우
     */
    private Person createPerson() {
        System.out.println(PURCHASE_AMOUNT_MESSAGE);
        String input = Console.readLine();
        validateNumeric(input);
        return new Person(Integer.parseInt(input));
    }

    /**
     * 당첨 번호를 생성한다.
     * 6개의 당첨 번호와 1개의 보너스 번호를 입력받는다.
     *
     * @return 생성된 당첨 번호
     * @throws IllegalArgumentException 올바르지 않은 번호가 입력된 경우
     */
    private WinningLotto createWinningLotto() {
        System.out.println(WINNING_NUMBERS_MESSAGE);
        List<Integer> numbers = parseNumbers(Console.readLine());

        System.out.println(BONUS_NUMBER_MESSAGE);
        String input = Console.readLine();
        validateNumeric(input);
        int bonusNumber = Integer.parseInt(input);

        return new WinningLotto(numbers, bonusNumber);
    }

    /**
     * 입력받은 문자열이 숫자로만 이루어져 있는지 검증한다.
     *
     * @param input 검증할 문자열
     * @throws IllegalArgumentException 숫자가 아닌 문자가 포함된 경우
     */
    private void validateNumeric(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다.");
        }
    }

    /**
     * 쉼표로 구분된 문자열을 숫자 리스트로 변환한다.
     *
     * @param input 쉼표로 구분된 숫자들
     * @return 변환된 숫자 리스트
     * @throws IllegalArgumentException 올바르지 않은 형식인 경우
     */
    private List<Integer> parseNumbers(String input) {
        try {
            return Arrays.stream(input.split(","))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 올바른 형식의 당첨 번호가 아닙니다.");
        }
    }
}