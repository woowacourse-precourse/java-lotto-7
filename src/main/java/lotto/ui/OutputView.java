package lotto.ui;

import lotto.Observer;

import java.util.List;

public class OutputView implements Observer {
    @Override
    public void update(int lottoCount) {
        System.out.println(lottoCount + ResultText.PURCHASED.getText());
    }

    @Override
    public void update(List<Integer> numbers) {
        System.out.println(numbers);
    }
}
