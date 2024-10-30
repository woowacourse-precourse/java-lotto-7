package lotto.view;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;

public class OutputView {

    public void printPurchaseCount(int lottoCount) {
        printEmptyLine();
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    public void printPurchaseLottos(List<Lotto> lottos) {
        lottos.forEach(this::printLotto);
        printEmptyLine();
    }

    private void printLotto(Lotto lotto) {
        List<Integer> numbers = lotto.getNumbers();
        Collections.sort(numbers);

        String outputNumbers = numbers.stream()
                .map(String::valueOf) // 각 숫자를 문자열로 변환
                .collect(Collectors.joining(", "));
        System.out.printf("[%s]\n", outputNumbers);
    }

    public void printEmptyLine() {
        System.out.println();
    }


}
