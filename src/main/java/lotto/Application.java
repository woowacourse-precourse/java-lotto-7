package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    static int amountForLottery;
    public static void main(String[] args) {
        readAmount();
    }
    public static void validateAmount(int input) {
        if(input <= 0 || input % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1,000원 단위여야 합니다.");
        }
    }
    public static void readAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        int input;
        try {
            input = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 올바른 정수여야 합니다.");
        }
        validateAmount(input);
        amountForLottery = input;
    }
}
