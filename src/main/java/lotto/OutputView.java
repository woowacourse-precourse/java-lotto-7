package lotto;

public class OutputView {
    public void displayBuyResult(Lottos lottos) {
        long lottoAmount = lottos.getSize();
        System.out.println(lottoAmount + "개를 구매했습니다.");
        String result = lottos.result();
        System.out.println(result);
    }
}
