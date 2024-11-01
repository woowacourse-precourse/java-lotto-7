package lotto.domain.factory;

import lotto.domain.Component;

import java.util.List;

public interface LottoFactory {

    List<Component> randomCreate();

}
