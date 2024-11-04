package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoBundle {

    private final List<Lotto> bundle;

    public LottoBundle(int ticket) {
        this.bundle = issueAll(ticket);
    }

    private List<Lotto> issueAll(int ticket) {
        List<Lotto> lottoBunch = new ArrayList<Lotto>();
        for (int i = 0; i < ticket; i++) {
            lottoBunch.add(Lotto.issue());
        }
        return Collections.unmodifiableList(lottoBunch);
    }

    public List<String> retrieveLottoNumbers() {
        List<String> lottoNumbers = new ArrayList<>();
        for (Lotto lotto : bundle) {
            lottoNumbers.add(lotto.retrieveLottoNumber());
        }
        return lottoNumbers;
    }

    /*
     * Getter
     * */
    public List<Lotto> getBundle() {
        return bundle;
    }
}
