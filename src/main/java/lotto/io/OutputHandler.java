package lotto.io;

import java.util.List;

public interface OutputHandler {
    void showLottoPrice();

    void showLottoCount(int lottoCount);

    void showLottoList(List<Integer> numbers);
}
