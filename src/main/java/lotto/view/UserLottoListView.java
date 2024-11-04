package lotto.view;

import static lotto.constants.OutputMessageConstants.PURCHASE_MESSAGE;
import static lotto.constants.RegExpConstants.ESCAPE_ENTER;

import java.util.List;

public class UserLottoListView {

    private final StringBuilder stringBuilder = new StringBuilder();

    public void printUserLottoList(final List<List<Integer>> lottoNumberList) {
        printLottoCount(lottoNumberList.size());
        printLottoList(lottoNumberList);

        System.out.println(stringBuilder);
    }

    private void printLottoCount(final int number) {
        stringBuilder.append(number).append(PURCHASE_MESSAGE).append(ESCAPE_ENTER);
    }

    private void printLottoList(final List<List<Integer>> lottoNumberList) {
        for (List<Integer> lottoNumber : lottoNumberList) {
            printLotto(lottoNumber);
        }
    }

    private void printLotto(final List<Integer> lottoNumber) {
        stringBuilder.append(lottoNumber.toString()).append(ESCAPE_ENTER);
    }
}
