package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private static List<Lotto> lottoList;
    private static int lottoCount;
    private static List<Integer> lotto = new ArrayList<>();

    public void start(){
        lottoCount = InputView.inputPrice();
        OutputView.printLottoCount(lottoCount);

        lottoList = makeLottoList(lottoCount);
    }

    public static List<Lotto> makeLottoList(int lottoCount){
        lottoList = new ArrayList<>();
        for(int i=0;i<lottoCount/1000;i++){
            lottoList.add(makeLotto());
        }
        return lottoList;
    }

    public static Lotto makeLotto(){
        lotto = new ArrayList<>();
        lotto = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        System.out.println(lotto);
        return new Lotto(lotto);
    }


}
