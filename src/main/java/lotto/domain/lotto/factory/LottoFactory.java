package lotto.domain.lotto.factory;

import lotto.domain.lotto.Component;

import java.util.List;

public interface LottoFactory {

    List<Component> create();

    int getLottoLength();

}
