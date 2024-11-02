package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {

    private static final String LOTTO_PURCHASE_PRICE_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String LOTTO_WINNING_NUMBER_INPUT_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String LOTTO_BONUS_NUMBER_INPUT_MESSAGE = "보너스 번호를 입력해 주세요.";

    public static void main(String[] args) {

    }

    public int getLottoPurchaseAmount() {
        System.out.println(LOTTO_PURCHASE_PRICE_INPUT_MESSAGE);
        int lottoPurchaseAmount = Integer.parseInt(Console.readLine());

        if (lottoPurchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1000원 단위로만 입력이 가능합니다.");
        }

        return lottoPurchaseAmount;
    }

    public List<Integer> getWinningNumber() {
        System.out.println(LOTTO_WINNING_NUMBER_INPUT_MESSAGE);
        List<String> winningNumbers = new ArrayList<>(List.of(Console.readLine().split(",")));

        List<Integer> integerList = new ArrayList<>();

        for (int i = 0; i < winningNumbers.size(); i++) {
            integerList.add(i, Integer.parseInt(winningNumbers.get(i)));
        }

        return integerList;
    }

    public int getBonusNumber() {
        System.out.println(LOTTO_BONUS_NUMBER_INPUT_MESSAGE);
        return Integer.parseInt(Console.readLine());
    }

    public int getLottoCount() {
        return getLottoPurchaseAmount() / 1000;
    }
}