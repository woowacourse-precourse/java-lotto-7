package lotto.view;

import java.util.List;

public class OutputView {

    private OutputView(){
    }

    public static void inputPurchaseAmount(){
        System.out.println("구입금액을 입력해주세요.");
    }

    public static void printPurchaseLottos(Integer count){
        System.out.printf("%d개를 구매했습니다.%n", count);
    }

    public static void printIssueAllLottoNumbers(List<List<Integer>> allLottoNumbers){
        allLottoNumbers.forEach(System.out::println);
    }

    public static void inputWinLottoNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void inputBonusLottoNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }
}
