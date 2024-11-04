package lotto.view;

import java.util.List;
import lotto.model.Lotto;

public class OutputView {

    public void printPriceInputPrompt() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void printErrorMessage(String message) {
        System.out.println("[ERROR] " + message);
    }

    public void printPurchasePrompt(int number) {
        System.out.println(number + "개를 구입했습니다.");
    }

    public void printLottoes(List<Lotto> lottoes) {
        for (Lotto lotto : lottoes) {
            List<Integer> numbers = lotto.getNumbers();
            numbers.sort(Integer::compareTo); // 오름차순 정렬
            System.out.println(numbers); // [ ] 안에 출력되도록 toString 형태로 출력
        }
    }

    public void promptWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void promptBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }
}
