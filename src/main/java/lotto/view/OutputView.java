package lotto.view;

import java.util.List;

public class OutputView {
    public static final String LINE_SEPARATOR = System.lineSeparator();

    public void printLottoList(List<LottoDto> lottos) {
        int count = lottos.size();
        System.out.printf("%,d개를 구매했습니다." + LINE_SEPARATOR, count);
        for (LottoDto lotto : lottos) {
            System.out.print(lotto + LINE_SEPARATOR);
        }
    }
}
