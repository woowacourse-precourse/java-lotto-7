package lotto.view;

public class OutputMessageView {
  public void numberOfPurchases(long purchaseAmount){
    long number=purchaseAmount/1000;
    System.out.println(number+"개를 구매했습니다.");
  }

}
