package lotto;

import java.util.List;

public class OutputView implements Observer {
    private static final String PURCHASED_MESSAGE = "개를 구매했습니다.";

    @Override
    public void update(int lottoCount) {
        System.out.println(lottoCount + PURCHASED_MESSAGE);
    }

    @Override
    public void update(List<Integer> numbers) {
        System.out.println(numbers);
    }
}
