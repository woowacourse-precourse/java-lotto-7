package lotto.Model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.Lotto;

public class LottoNumbers {

    public LottoNumbers() {
    }

    private static final int CNT_LOTTO_NUMBER = 6;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    private static List<Integer> lottoNumberList;

    public static ArrayList<Integer> setLottoNumbers() {
        lottoNumberList = Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, CNT_LOTTO_NUMBER);
        ArrayList<Integer> lottoTicketNumberList = new ArrayList<>(lottoNumberList);
        Collections.sort(lottoTicketNumberList);
        return lottoTicketNumberList;
    }

    public static Lotto makeLotto(){
        ArrayList<Integer> lotto = new ArrayList<>();
        lotto = LottoNumbers.setLottoNumbers();
        System.out.println(lotto);
        return new Lotto(lotto);
    }

    public static List<Lotto> makeLottoList(int gameNumber){
        ArrayList<Lotto> lottoList = new ArrayList<>();
        for(int i=1; i<=gameNumber; i++){
            lottoList.add(makeLotto());
        }
        return lottoList;
    }

}
