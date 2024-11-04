package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    // 값이 있는지, 값이 숫자만 있는지, 숫자가 천원단위인지,
    public static void checkInputEmptyException(String lottoAmountInput) {
        if (lottoAmountInput.isEmpty()) {
            throw new IllegalArgumentException("로또 구매금액을 입력하세요.");
        }
    }
    public static void checkNumberTypeException(String lottoAmountInput) {
        try {
            parseLottoAmount(lottoAmountInput);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("구매 금액은 숫자만 입력 가능합니다.");
        }
    }
    public static void checkThousandUnitException(int lottoAmount) {
        if (lottoAmount % 1000 != 0) {
            throw new IllegalArgumentException("구매 금액은 1,000원 단위만 가능합니다.");
        }
    }

    public static void printInstructionAboutLottoAmount() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static int parseLottoAmount(String lottoAmountInput) {
        return Integer.parseInt(lottoAmountInput);
    }

    public static String getLottoAmount() {
        return Console.readLine().trim();
    }

    public static int processLottoPurchase() {
        String lottoAmountInput;
        do {
            printInstructionAboutLottoAmount();
            lottoAmountInput = getLottoAmount();
            try {
                checkInputEmptyException(lottoAmountInput);
                checkNumberTypeException(lottoAmountInput);
                checkThousandUnitException(parseLottoAmount(lottoAmountInput));
                return parseLottoAmount(lottoAmountInput);
            }
            catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        } while (true);
    }

    public static void main(String[] args) {
        processLottoPurchase();
    }
}
