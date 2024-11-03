package lotto.view;

public class Output {
    public static void requestPurchaseAmount(){
        System.out.println("구입금액을 입력해 주세요.");
    }
    public static void requestHowManyLottos(int money){
        System.out.println(" ");
        System.out.println(money/1000+"개를 구매했습니다.");
    }



}
