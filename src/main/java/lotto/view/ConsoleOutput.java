package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Lottos;

import java.util.ArrayList;
import java.util.List;

public class ConsoleOutput implements Output {

    private static final String ERROR_PREFIX = "[ERROR]";

    @Override
    public void outputError(Exception exception) {
        System.out.printf("%s %s", ERROR_PREFIX, exception.getMessage());
        System.out.println();
        goToNext();
    }

    @Override
    public void showLottos(Lottos lottos) {
        List<Lotto> lottoList = lottos.getLottos();
        System.out.println(lottoList.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottoList) {
            printLotto(lotto);
        }
    }

    private void printLotto(Lotto lotto) {
        List<Integer> numbers = new ArrayList<>(lotto.getNumbers());
        numbers.sort(Integer::compareTo);
        System.out.println(numbers);
    }

    @Override
    public void goToNext() {
        System.out.println();
    }

}
