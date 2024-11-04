package lotto;

import camp.nextstep.edu.missionutils.Console;

public class InputMoney {
    public static String inputMoney;
    public static int paidPrice;
    public static int purchaseNumber;

    public static int inputMoneyToBuyLotto() {
        boolean continueLoop = true;

        while (continueLoop) {      // 예외 발생 시 재입력 반복
            System.out.println("구입금액을 입력해 주세요.");
            inputMoney = Console.readLine();

            validateInputMoney(inputMoney);         // 입력 금액 검증
            continueLoop = false;
        }

        purchaseNumber = paidPrice / 1000;      // 구매 수량 저장
        return purchaseNumber;
    }

    // 입력 금액 검증
    public static int validateInputMoney(String inputMoney) {
        paidPrice = checkForNonNumericCharacters(inputMoney);       // 문자나 기호 체크 후 정수 변환
        checkNegative(paidPrice);           // 음수 체크
        checkIfThousandUnit(paidPrice);     // 1000의 배수 체크
        return paidPrice;
    }

    // 문자나 기호 체크 후 정수 변환
    public static int checkForNonNumericCharacters(String inputMoney) {
        try {
            return Integer.parseInt(inputMoney);    // 정수 변환
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 문자, 기호 없이 정수만 입력 가능합니다.\n다시 입력해 주세요.");
        }
    }

    // 음수 체크
    public static void checkNegative(int paidPrice) {
        if (paidPrice < 0) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 음수가 될 수 없습니다.\n다시 입력해 주세요.");
        }
    }

    // 1000 의 배수 체크
    public static void checkIfThousandUnit(int paidPrice) {
        if (paidPrice % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 1,000원 단위로만 입력 가능합니다.\n다시 입력해 주세요.");
        }
    }
}