package lotto.io;

import java.util.List;

public class ConsoleOutputHandler implements OutputHandler {
    @Override
    public void showLottoPrice() {
        System.out.println("구입 금액을 입력해 주세요.");
    }

    @Override
    public void showLottoCount(int lottoCount) {
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    @Override
    public void showLottoList(List<Integer> numbers) {
        System.out.println(numbers);
    }
}
