package exception;

import java.util.Collections;
import java.util.List;

/**
 * 예외 처리 로직을 담당
 */
public class Handler {
    /**
     * 구입 금액 반환 및 예외 처리
     * @param input 구입 금액을 입력받는 객체
     * @return 정수로 parse되면 해당 값을 반환
     */
    public static int getMoney(io.Input input) {
        String inputString = input.getInput();
        int money = 1;

        try {
            money = Integer.parseInt(inputString);
        } catch (IllegalArgumentException ex) {
            //get Lotto Number에서 처리
        }
        return money;
    }

    /**
     * 1000원 단위가 아니라면 예외 발생
     * @param money 구입 금액-정수
     * @return 1000원 단위이면 true
     */
    protected static boolean moneyIsValid(int money) {
        if (money % lotto.Lotto.Price.PRICE != 0) {
            Message message = new Message(Integer.toString(money));
            String exceptionMessage = message.getMessage(Message.INVALID_MONEY);
            throw new IllegalArgumentException(exceptionMessage);
        }
        return true;
    }

    /**
     * 입력 금액이 1000의 배수이면 구입 개수를 반환하고, 잘못된 입력값이면 다시 입력 받음
     * @return 로또 구입 개수
     */
    public static int getLottoQuantity() {
        int money = 0;
        boolean validity = false;

        while (!validity) {
            io.Input input = new io.Input();
            String inputString = input.getInput();
            try {
                money = exception.Handler.getMoney(input);
                validity = moneyIsValid(money);
            } catch (IllegalArgumentException ex) {
                exception.Handler.handleException(inputString, Message.INVALID_MONEY);
            }
        }
        return money / lotto.Lotto.Price.PRICE;
    }

    /**
     * 입력값과 발생 예외 메시지를 조합하여 메시지를 출력
     * 예를 들어 입력값에 번호 3이 중복되어 에러가 발생했다면, 3을 중복값으로 포함한다는 구체적인 내용을 제시하기 위함
     * @param inputString 입력값
     * @param exceptionMessage 발생 예외 메시지
     */
    public static void handleException(String inputString, String exceptionMessage) {
        exception.Message message = new exception.Message(inputString);
        String printMessage = message.getMessage(exceptionMessage);
        io.Print.print(printMessage);
    }

    /**
     * 입력값 검증
     * @param numbers 번호 리스트
     * @return 입력값에 문제가 없다면 true
     */
    public static boolean isValid(List<Integer> numbers) {
        try {
            exception.Handler.validateNumbers(numbers);
        } catch (IllegalArgumentException ex) {
            exception.Handler.handleException(numbers.toString(), Message.INVALID_CHOICE);
            return false;
        }
        try {
            int number = Handler.findDuplicateNumber(numbers);
            raiseException(number);
        } catch (IllegalArgumentException ex) {
            exception.Handler.handleException(numbers.toString(), Message.DUPLICATE_NUMBER);
            return false;
        }
        try {
            int number = Handler.findInvalidNumber(numbers);
            raiseException(number);
        } catch (IllegalArgumentException ex) {
            exception.Handler.handleException(numbers.toString(), Message.INVALID_RANGE);
            return false;
        }
        return true;
    }

    /**
     * 정수가 -1이 아니라면 예외 발생 (문제 없는 입력값이면 -1을 리턴하는 부분과 연계)
     * @param input 정수
     */

    public static void raiseException(int input) {
        if (input != -1) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * 번호가 6개인지 체크, 아니면 예외 발생
     * @param numbers 번호 리스트
     */
    private static void validateNumbers(List<Integer> numbers) { // 원본은 Lotto.validate
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * 중복된 번호가 존재하는 지 체크
     * @param numbers 번호 리스트
     * @return 중복된 번호가 없으면 -1, 있으면 중복된 번호
     */
    private static int findDuplicateNumber(List<Integer> numbers) {
        int duplicate = -1;
        for (int number : numbers) {
            if (Collections.frequency(numbers, number) != 1) {
                return number;
            }
        }
        return duplicate;
    }

    /**
     * 1 이상 45 미만이라는 제약을 어기는 번호가 있는지 체크
     * @param numbers 번호 리스트
     * @return 없으면 -1, 있으면 해당 번호를 반환
     */
    public static int findInvalidNumber(List<Integer> numbers) {
        int invalid = -1;
        for (int number : numbers) {
            if (number < 1 || number > 45) {
                return number;
            }
        }
        return invalid;
    }

}
