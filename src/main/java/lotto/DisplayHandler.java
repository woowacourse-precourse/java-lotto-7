package lotto;

public class OutputHandler {

    private void display(PurchasedLotto purchasedLotto) {
        System.out.println(purchasedLotto.getCount() + "개를 구매했습니다.");
        System.out.println(purchasedLotto.getFormatted());
    }

    private void display(Result result, Payment payment) {
        System.out.println("당첨 통계\n---");
        System.out.print(result.getFormattedWinningDetails());

        ReturnRate returnRate = new ReturnRate();
        String formattedReturnRate = returnRate.calculate(result, payment);
        System.out.print("총 수익률은 " + formattedReturnRate + "입니다.");
    }
}
