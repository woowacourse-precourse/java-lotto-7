package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.controller.LottoController;

public class lottoDraw {
    public static void drawAndSetLottos(LottoController lottoController){
        List<Lotto> lottos = new ArrayList<>();
        for(int i = 0; i < lottoController.getTotalCount(); i++){
            lottos.add(drawLotto());
        }
        lottoController.setLottos(lottos);
    }

    public static Lotto drawLotto(){
        return new Lotto(pickNumbers());
    }

    public static List<Integer> pickNumbers(){
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
