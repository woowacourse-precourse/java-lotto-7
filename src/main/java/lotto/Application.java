package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {

    private static final String LOTTO_PURCHASE_PRICE_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String LOTTO_WINNING_NUMBER_INPUT_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String LOTTO_BONUS_NUMBER_INPUT_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final String LOTTO_QUANTITY_MESSAGE = "개를 구매했습니다.";

    public static void main(String[] args) {
        try {
            System.out.println(LOTTO_PURCHASE_PRICE_INPUT_MESSAGE);
            List<Integer> lottoPurchaseAmount = getLottoPurchaseAmount(Console.readLine());

            getWinningNumber();
            getBonusNumber();

            System.out.println(getLottoCount(lottoPurchaseAmount) + LOTTO_QUANTITY_MESSAGE);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static List<Integer> getLottoPurchaseAmount(String lottoPurchaseAmount) {
        List<Integer> purchaseAmount = new ArrayList<>();

        for (String amount : lottoPurchaseAmount.split(",")) {
            int parsedAmount = Integer.parseInt(amount.trim());

            if (parsedAmount % 1000 != 0) {
                throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1000원 단위로만 입력이 가능합니다.");
            }

            purchaseAmount.add(parsedAmount);
        }

        return purchaseAmount;
    }


    public static List<Integer> getWinningNumber() {
        System.out.println(LOTTO_WINNING_NUMBER_INPUT_MESSAGE);
        List<String> winningNumbers = new ArrayList<>(List.of(Console.readLine().split(",")));

        List<Integer> integerList = new ArrayList<>();

        for (int i = 0; i < winningNumbers.size(); i++) {
            integerList.add(i, Integer.parseInt(winningNumbers.get(i)));
        }

        return integerList;
    }

    public static int getBonusNumber() {
        System.out.println(LOTTO_BONUS_NUMBER_INPUT_MESSAGE);
        return Integer.parseInt(Console.readLine());
    }

    public static int getLottoCount(List<Integer> purchaseAmounts) {
        int totalAmount = 0;

        for (int amount : purchaseAmounts) {
            totalAmount += amount;
        }

        return totalAmount / 1000;
    }
}