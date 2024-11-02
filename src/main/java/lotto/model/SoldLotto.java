package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class SoldLotto {
    private static final String LINE_SEPARATOR = "\n";
    private final List<Lotto> soldLotto;

    public SoldLotto(){
        this.soldLotto = new ArrayList<>();
    }

    public void addLottoSold(Lotto lotto){
        soldLotto.add(lotto);
    }

    public StringBuilder getLottoDetails(){
        StringBuilder lottoDetails = new StringBuilder();
        for (Lotto lotto : soldLotto){
            lottoDetails.append(lotto.getLottoDetails()).append(LINE_SEPARATOR);
        }
        return lottoDetails;
    }

}
