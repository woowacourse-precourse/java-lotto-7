package lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.NumberGenerator;

public class Application {

    public static void main(String[] args) {
        Lotto lottoA = Lotto.from(new NumberGenerator().generate());
        Lotto lottoB = Lotto.from(new NumberGenerator().generate());
    }

}
