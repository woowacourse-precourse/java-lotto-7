package lotto.view;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static final String ASK_MONEY_INPUT = "구입금액을 입력해 주세요.";
    public static final String ASK_LOTTO_NUM_INPUT = "당첨 번호를 입력해 주세요.";
    public static final String INPUT_MONEY_NOT_NUMBER = "[ERROR] 입력하신 금액이 양의 정수가 아닙니다.";



    public int lottoMoneyInput() {
        System.out.printf(ASK_MONEY_INPUT);
        String rawMoney = Console.readLine();
        validateIsNumber(rawMoney);
        return Integer.parseInt(rawMoney);
    }

    public String[] lottoNumberInput() {
        System.out.printf(ASK_LOTTO_NUM_INPUT);
        String rawNumbers = Console.readLine();
        return rawNumbers.split(",");
    }


    private void validateIsNumber(String rawValue) {
        try {
            Integer.parseInt(rawValue);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_MONEY_NOT_NUMBER);
        }
    }

}
