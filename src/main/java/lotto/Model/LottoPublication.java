package lotto.Model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;

public class LottoPublication {
    private List<Integer> publicationNumbers;

    public void lottoNumberPublication() {
        publicationNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public void publicationNumbersArray() {
        lottoNumberPublication();
        Collections.sort(publicationNumbers);
    }

    public List<Integer> getPublicationNumbers() {
        return publicationNumbers;
    }
}
