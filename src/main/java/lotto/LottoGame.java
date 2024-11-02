package lotto;
import camp.nextstep.edu.missionutils.Console;

public class LottoGame {

    public static void main(String[] args) {
        try {
            int purchaseAmount = getPurchaseAmount();
            LottoValidator.validateAmount(purchaseAmount);
            int lottoCount = purchaseAmount / 1000;
            System.out.println(lottoCount + "개를 구매했습니다.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static int getPurchaseAmount() {
        System.out.println("구입 금액을 입력해 주세요.");
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 유효한 숫자를 입력해 주세요.");
        }
    }
}
