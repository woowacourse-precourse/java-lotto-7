package lotto;
import camp.nextstep.edu.missionutils.Console;
public class Application {
    public static final String CREDIT_MESSAGE = "구입금액을 입력해 주세요.";
    public static final String NOT_MULTIPLE_1000 = "[ERROR] 구입 금액은 1,000의 배수여야 합니다.";
    public static int pieces;
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println(CREDIT_MESSAGE);
        int credit = Integer.parseInt(Console.readLine());
        try {
            pieces = checkCredit(credit);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.out.println(CREDIT_MESSAGE);
            int newCredit = Integer.parseInt(Console.readLine());
            pieces = checkCredit(newCredit);
        }
    }

    public static int checkCredit(int credit) throws IllegalArgumentException {
        if (credit % 1000 != 0) {
            throw new IllegalArgumentException(NOT_MULTIPLE_1000);
        }
        return credit / 1000;
    }
}
