package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        // 1.5 형식에 맞는 구입 금액이 입력될 때까지 반복하여 입력을 받는 기능
        int purchaseAmount = getPurchaseAmount();

        // 2.4 로또 번호를 통해 구매할 로또의 개수만큼 로또 객체를 생성하는 기능
        ArrayList<Lotto> lottoTickets = generateLottoTickets(purchaseAmount);
        // 2.5 로또의 번호를 출력하는 기능
        printLottoTickets(lottoTickets);

        // 3.1 당첨 번호를 입력 받는 기능
        String winningNumbersInput = getInputString("당첨 번호를 입력해 주세요.");

        // 3.2 입력된 당첨 번호를 쉼표(,)를 기준으로 분리하는 기능
        String[] winningNumbersInputSplits = winningNumbersInput.split(",");
    }

    private static String getInputString(String message) {
        System.out.println("\n" + message);
        return Console.readLine();
    }

    private static void validateNumericString(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자로 변환할 수 없는 문자열입니다.");
        }
    }

    private static void validatePositiveNumber(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("[ERROR] 양의 정수가 아닙니다.");
        }
    }

    private static void validateThousandUnit(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1000원으로 나누어 떨어지지 않는 금액입니다.");
        }
    }

    private static int getPurchaseAmount() {
        while (true) {
            String purchaseAmountInput = getInputString("구입 금액을 입력해 주세요.");
            try {
                return convertPurchaseAmount(purchaseAmountInput);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static int convertPurchaseAmount(String purchaseAmountInput) {
        validateNumericString(purchaseAmountInput);
        int purchaseAmount = Integer.parseInt(purchaseAmountInput);
        validatePositiveNumber(purchaseAmount);
        validateThousandUnit(purchaseAmount);
        return purchaseAmount;
    }

    private static int calculateLottoCount(int purchaseAmount) {
        return purchaseAmount / 1000;
    }

    private static ArrayList<Lotto> generateLottoTickets(int purchaseAmount) {
        int lottoCount = calculateLottoCount(purchaseAmount);
        ArrayList<Lotto> lottoTickets = new ArrayList<>();

        for (int count = 0; count < lottoCount; count++) {
            List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(lottoNumbers);
            lottoTickets.add(new Lotto(lottoNumbers));
        }
        return lottoTickets;
    }

    private static void printLottoTickets(ArrayList<Lotto> lottoTickets) {
        System.out.println("\n" + lottoTickets.size() + "개를 구매했습니다.");
        for (Lotto lottoTicket : lottoTickets) {
            System.out.println(lottoTicket);
        }
    }
}
