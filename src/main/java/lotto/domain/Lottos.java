package lotto.domain;

import global.errorMessage.CommonErrorMessage;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        // 방어적 copy
        this.lottos = new ArrayList<>(lottos);
    }

    public static Lottos create(List<Lotto> lottos) {
        return new Lottos(lottos);
    }

    public Lotto getElement(int index) {
        if(index < 0 || index >= lottos.size()) {
            throw new IndexOutOfBoundsException(CommonErrorMessage.INVALID_INDEX.getMessage());
        }
        return lottos.get(index);
    }

    public long getSize() {
        return lottos.size();
    }

    public String result() {
        StringJoiner stringJoiner = new StringJoiner("\n");
        for (Lotto lotto : lottos) {
            stringJoiner.add(lotto.result());
        }
        return stringJoiner.toString();
    }
}
