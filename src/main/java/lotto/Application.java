package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int lottoPurchasePrice = Integer.parseInt(validate(Console.readLine()));
        int lottoPurchaseQuantity = calculateLottoQuantity(lottoPurchasePrice);
    }

    public static int calculateLottoQuantity(int lottoPurchasePrice) {
        return lottoPurchasePrice / 1000;
    }

    public static String validate(String enterPrice) {
        return enterPrice;
    }
}
