package lotto.view;

public class OutputView {

    public void printPurchaseCount(int lottoCount) {
        printEmptyLine();
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    private void printEmptyLine() {
        System.out.println();
    }


}
