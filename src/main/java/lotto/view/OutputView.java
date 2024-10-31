package lotto.view;

import java.util.ArrayList;
import java.util.List;
import lotto.model.Lotto;

public class OutputView {
    public void printLottos(List<Lotto> lottos) {
        System.out.printf("%d개를 구매했습니다.%n", lottos.size());
        for (Lotto lotto : lottos) {
            List<Integer> numbers = new ArrayList<>(lotto.getNumbers()); // 수정 가능한 리스트로 변환
            numbers.sort(Integer::compareTo); // 오름차순 정렬
            System.out.println(numbers);
        }
    }

    public void printYield(double yield) {
        System.out.printf("총 수익률은 %.1f%%입니다.%n", yield);
    }

    public void printErrorMessage(String message) {
        System.out.println(message);
    }
}
