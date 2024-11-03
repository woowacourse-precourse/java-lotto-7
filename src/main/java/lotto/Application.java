package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    private static final String ERROR_MESSAGE = "[ERROR]";

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int purchaseAmount = inputPurchaseAmount();
        int lottoCount = getLottoCount(purchaseAmount);
        Lotto[] lottos = new Lotto[lottoCount];

    }


    private static int inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        int purchaseAmount = parsePurchaseAmount(input);
        validatePurchaseAmount(purchaseAmount);
        return purchaseAmount;
    }

    private static int parsePurchaseAmount(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println(ERROR_MESSAGE + " 구입금액은 정수형이어야 합니다 : " + input);
            return -1;
        }
    }

    private static void validatePurchaseAmount(int input) {
        if (input == -1) {
            throw new IllegalArgumentException();
        }
        if (input < 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 구입금액은 양수이어야 합니다 : " + input);
        }
        if (input % 1000 != 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 구입금액은 1000단위이어야 합니다 : " + input);
        }
    }

    private static int getLottoCount(int input) {
        return input / 1000;
    }
}
