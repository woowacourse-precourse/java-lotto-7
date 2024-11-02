package view;

import java.util.List;
import java.util.stream.Collectors;
import model.Lotto;

public class Outputview {

    public void showLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개의 로또를 구매했습니다.");

        for (Lotto lotto : lottos) {
            System.out.print('[');

            String numbers = lotto.getNumbers().stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(", "));

            System.out.println(numbers + ']');
        }

    }
}
