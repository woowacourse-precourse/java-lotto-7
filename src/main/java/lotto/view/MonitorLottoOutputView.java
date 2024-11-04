package lotto.view;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import lotto.application.model.Model;
import lotto.application.model.WinningRanking;

public class MonitorLottoOutputView implements OutputView<Model> {

    @Override
    public void print(Model model) {
        System.out.println(model);
    }

    @Override
    public void print(Map<? extends Model, ?> map) {
        System.out.println("당첨 통계\n---");
        map.keySet().stream()
                .filter(key -> key!=WinningRanking.NON_MATCH)
                .forEach(key -> {
                    System.out.println(key +""+ map.get(key)+"개");
                });
    }

    @Override
    public void print(Number number) {
        System.out.println(String.format("총 수익률은 %.2f 입니다.", number));
    }
}
