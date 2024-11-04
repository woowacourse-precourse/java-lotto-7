package lotto.view;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    public static void printInitialMessage() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void printBuyingLotto(int lottoAmount) {
        System.out.println("\n" + lottoAmount + "개를 구매했습니다.");
    }


    public static void printLottoNumbers(List<Integer> lottoNumbers) {
        System.out.println(
            lottoNumbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", ", "[", "]"))
        );
    }

    public static void printMessageDefaultLottoNumbers() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
    }

    public static void printMessageBonusNumber() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
    }

}
