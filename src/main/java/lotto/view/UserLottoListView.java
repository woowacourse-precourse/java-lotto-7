package lotto.view;

import java.util.List;

public class UserLottoListView {

    private static final String PURCHASE_MESSAGE = "개를 구매했습니다.";
    public static final String ENTER = "\n";

    private final StringBuilder stringBuilder = new StringBuilder();

    public void printUserLottoList(final List<List<Integer>> lottoNumberList) {
        printLottoCount(lottoNumberList.size());
        printLottoList(lottoNumberList);

        System.out.println(stringBuilder);
    }

    private void printLottoCount(final int number) {
        stringBuilder.append(number).append(PURCHASE_MESSAGE).append(ENTER);
    }

    private void printLottoList(final List<List<Integer>> lottoNumberList) {
        for (List<Integer> lottoNumber : lottoNumberList) {
            printLotto(lottoNumber);
        }
    }

    private void printLotto(final List<Integer> lottoNumber) {
        stringBuilder.append(lottoNumber.toString()).append(ENTER);
    }
}
