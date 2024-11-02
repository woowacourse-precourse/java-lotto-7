package lotto;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class LottoGame {

    public static void main(String[] args) {
        try {
            int lottoCount = getValidatedLottoCount();
            printPurchasedLottos(lottoCount);
        } catch (IllegalArgumentException e) {
            printErrorMessage(e);
        }
    }

    private static int getValidatedLottoCount() {
        int purchaseAmount = getPurchaseAmount();
        LottoValidator.validateAmount(purchaseAmount);
        return purchaseAmount / 1000;
    }

    private static int getPurchaseAmount() {
        System.out.println("구입 금액을 입력해 주세요.");
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 유효한 숫자를 입력해 주세요.");
        }
    }

    private static void printPurchasedLottos(int lottoCount) {
        System.out.println(lottoCount + "개를 구매했습니다.");
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> lottoNumbers = LottoNumberGenerator.generate();
            System.out.println(lottoNumbers);
        }
    }

    private static void printErrorMessage(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }
}
