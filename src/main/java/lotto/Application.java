package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static int lottoPrice = 1000;

    public static void main(String[] args) {
        String inputMoney = Console.readLine();
        int lottoPieces = buyLotto(inputMoney);
    }

    public static int buyLotto(final String input) {
        int payment = Integer.parseInt(input);
        if (payment % lottoPrice != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
        }
        return payment / lottoPrice;
    }
}
