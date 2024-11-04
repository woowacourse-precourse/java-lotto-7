package lotto.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class DrawingLotto {
    private List<LottoNumber> lottos;

    private DrawingLotto(List<LottoNumber> lottos) {
        this.lottos = new ArrayList<>(lottos);
    }

    public static List<LottoNumber> createDrawingLotto(Quantity quantity) {
        int repeat = quantity.getQuantity();
        List<LottoNumber> list = new ArrayList<>();

        for (int i = 1; i <= repeat; i++) {
            Lotto autoLotto = Lotto.createAutoLotto();
            LottoNumber autoBonusBall = BonusBall.createAutoBonusBall(autoLotto).getNumber();

            list.addAll(autoLotto.getNumbers());
            list.add(autoBonusBall);
        }
        return list;
    }

    public static List<String> toString(List<LottoNumber> numbers) {
        return numbers.stream()
                .map(number -> LottoNumber.toString(number))
                .collect(Collectors.toList());
    }
}
