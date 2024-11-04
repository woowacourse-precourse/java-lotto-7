package lotto.view;

import lotto.model.Lotto;

import java.util.List;

public class Output {
    public static void requestPurchaseAmount(){
        System.out.println("구입금액을 입력해 주세요.");
    }
    public static void requestHowManyLottos(int money){
        System.out.println(" ");
        System.out.println(money/1000+"개를 구매했습니다.");
    }
    public static void requestLottoNumbers(List<Integer> numbers){
        System.out.println(numbers.toString());
    }
    public static void requestWinningNumber(){
        System.out.println(" ");
        System.out.println("당첨 번호를 입력해 주세요.");
    }





}
