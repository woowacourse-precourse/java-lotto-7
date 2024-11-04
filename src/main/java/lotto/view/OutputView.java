package lotto.view;
//lottoQuantity
public class OutputView {
    private final String PURCHASE_OUTPUT = "구입금액을 입력해 주세요.";
    private final String QUANTITY_OUTPUT="개를 구매했습니다.";
    public void purchase(){
        System.out.println(PURCHASE_OUTPUT);
    }

    public void quantity(int lottoQuantity){
        System.out.println("\n"+lottoQuantity+QUANTITY_OUTPUT);
    }


}
