package lotto.view;

import lotto.domain.Lotto;

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
}
