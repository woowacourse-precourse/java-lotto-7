package lotto.view;


public class OutputView {
    private static final String OUTPUT_NUM_OF_LOTTO = "개를 구매했습니다.";

    public void printNumberOfLotto(long size) {
        System.out.println(size + OUTPUT_NUM_OF_LOTTO);
    }

}
