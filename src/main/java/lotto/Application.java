package lotto;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    private static final int lottoPrice = 1000;
    private static int purchaseAmount;

    public static void main(String[] args) {
        Application app = new Application();
        app.getPurchaseAmount();
        app.print();
    }
    private void validate(String input){
        try {
            int amount = Integer.parseInt(input);
            if (amount < 1000) {
                throw new IllegalArgumentException("구입 금액은 1000원 이상이어야 합니다.");
            }
            if (amount % 1000 != 0) {
                throw new IllegalArgumentException("구입 금액은 1000원 단위여야 합니다.");
            }
        } catch(NumberFormatException e){
            throw new IllegalArgumentException("구입 금액은 정수여야 합니다.");
       }
    }


    public void getPurchaseAmount(){
       String input = Console.readLine();
       validate(input);
       this.purchaseAmount = Integer.parseInt(input);

    }

    public void print(){
        System.out.println(this.purchaseAmount);
        calculateLottoCount(this.purchaseAmount);

    }

    //금액 별 로또 매수 계산 함수
    public static int calculateLottoCount(int purchasAmount){
        return purchaseAmount / lottoPrice;
    }
    // 로또 생성하는 함수

    //로또 번호 출력함수

    //당첨 번호 입력받는 함수

    //보너스번호 입력받는 함수

    //당첨 통계 계산하는 함수

    //수익률 계산하는 함수

    //당첨 통계와 수익률 출력하는 함수



}
