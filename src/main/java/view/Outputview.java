package view;

import java.util.List;
import java.util.stream.Collectors;
import model.Lotto;

public class Outputview {

    // TODO: 계산할 때도 가격이 쓰일 것이라 출력 좀 더 신경쓰기
    //  가격을 따로 저장 한다던가... enum?
    private final List<String> statisticsMessages = List.of(
            "3개 일치 (5,000원) - ",
            "4개 일치 (50,000원) - ",
            "5개 일치 (1,500,000원) - ",
            "5개 일치, 보너스 볼 일치 (30,000,000원) - ",
            "6개 일치 (2,000,000,000원) - "
    );

    public void showLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");

        for (Lotto lotto : lottos) {
            System.out.print('[');

            String numbers = lotto.getNumbers().stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(", "));

            System.out.println(numbers + ']');
        }
    }

    public void showStatistics(List<Integer> matchNumberCount) {
        for (int i = 3; i < matchNumberCount.size(); i++) {
            System.out.println(statisticsMessages.get(i - 3) + matchNumberCount.get(i) + "개");
        }
    }
}
