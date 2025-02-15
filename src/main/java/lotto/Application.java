package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.List;

public class Application {
    public static void checkInputEmptyException(String lottoAmountInput) {
        if (lottoAmountInput.isEmpty()) {
            throw new IllegalArgumentException("로또 구매금액을 입력하세요.");
        }
    }
    public static int checkNumberTypeException(String lottoAmountInput) {
        try {
            return Integer.parseInt(lottoAmountInput);
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
        return checkNumberTypeException(lottoAmountInput);
    }

    public static String getLottoAmount() {
        return Console.readLine().trim();
    }

    public static int processLottoPurchase() {
        String lottoAmountInput;
        int lottoAmount;
        do {
            printInstructionAboutLottoAmount();
            lottoAmountInput = getLottoAmount();
            try {
                checkInputEmptyException(lottoAmountInput);
                lottoAmount = parseLottoAmount(lottoAmountInput);
                checkThousandUnitException(lottoAmount);
                return lottoAmount / 1000; // 로또 구입 개수
            }
            catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        } while (true);
    }

    public static void printPurchaseLottoInformation(int lottoTicketNumber) {
        printLottoTicketNumber(lottoTicketNumber);
        printLottoNumbers(lottoTicketNumber);
    }
    public static void printLottoTicketNumber(int lottoTicketNumber) {
        System.out.println(lottoTicketNumber + "개를 구매했습니다.");
    }
    public static void printLottoNumbers(int lottoTicketNumber) {
        for (int index = 0; index < lottoTicketNumber; index++) {
            List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(lottoNumbers); // 오름차순 정렬
            System.out.println(lottoNumbers);
        }

    }
    public static void main(String[] args) {
        int lottoTicketNumber = processLottoPurchase();
        printPurchaseLottoInformation(lottoTicketNumber);
    }
}
