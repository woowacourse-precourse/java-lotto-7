package lotto;

import camp.nextstep.edu.missionutils.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Application {
    private static final String ERROR_MESSAGE = "[ERROR]";
    private static final int PURCHASE_UNIT = 1000;

    public static void main(String[] args) {
        int purchaseAmount = getValidPurchaseAmount();
        List<Lotto> lottoTickets = createLottoTickets(purchaseAmount);
        printLottoTickets(lottoTickets);
    }

    public static int getValidPurchaseAmount() {
        while (true) {
            try {
                System.out.println("구입 금액을 입력해주세요.");
                String input = Console.readLine();

                validateInput(input);
                int purchaseCost = validatePurchaseCostInput(input);
                validatePurchaseCost(purchaseCost);

                return purchaseCost / PURCHASE_UNIT; // 입력이 유효하면 변환 후 반환
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage()); // 에러 메시지 출력 후 루프 반복하여 재입력 요청
            }
        }
    }

    public static void validateInput(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 입력값이 비어 있습니다. 다시 입력해 주세요.");
        }

        if (input.contains(" ")) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 입력에 공백이 포함되어 있습니다. 다시 입력해 주세요.");
        }
    }

    public static int validatePurchaseCostInput(String input) {
        if (!input.matches("[0-9]+")) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 입력값이 숫자가 아닙니다. 다시 입력해 주세요.");
        }

        return Integer.parseInt(input);
    }

    public static void validatePurchaseCost(int purchaseCost) {
        if (purchaseCost < PURCHASE_UNIT) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 로또 구입 금액은 최소 1000원 이상이어야 합니다.");
        }

        if (purchaseCost % PURCHASE_UNIT != 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 로또 구입 금액은 1000원 단위로 입력해야 합니다.");
        }
    }

    public static List<Lotto> createLottoTickets(int purchaseAmount) {
        List<Lotto> lottoTickets = new ArrayList<>();
        for (int i = 0; i < purchaseAmount; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottoTickets.add(new Lotto(numbers));
            Collections.sort(numbers); // 오름차순 정렬
        }
        return lottoTickets;
    }

    public static void printLottoTickets(List<Lotto> lottoTickets) {
        System.out.println(lottoTickets.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottoTickets) {
            System.out.println(lotto.getNumbers());
        }
    }
}
