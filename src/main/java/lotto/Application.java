package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    private static final String ERROR_MESSAGE = "[ERROR]";

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int purchaseAmount = inputPurchaseAmount();
        int lottoCount = getLottoCount(purchaseAmount);

        Lotto[] lottos = Lotto.generateLottos(lottoCount);
        Lotto.printLottos(lottos);

        Lotto winningNumbers = inputWinningNumbers();
    }


    private static int inputPurchaseAmount() {
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                String input = Console.readLine();

                int purchaseAmount = parsePurchaseAmount(input);
                validatePurchaseAmount(purchaseAmount);
                System.out.println();
                return purchaseAmount;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.out.println();
            }
        }
    }

    private static int parsePurchaseAmount(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 구입금액은 정수형이어야 합니다 : " + input);
        }
    }

    private static void validatePurchaseAmount(int input) {
        if (input < 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 구입금액은 양수이어야 합니다 : " + input);
        }
        if (input % 1000 != 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 구입금액은 1000단위이어야 합니다 : " + input);
        }
    }

    private static int getLottoCount(int input) {
        int lottoCount = input / 1000;
        System.out.println(lottoCount + "개를 구매했습니다.");
        return lottoCount;
    }

    private static Lotto inputWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        Lotto winningNumbers = parseWinningNumbers(input);
        return winningNumbers;
    }
}
