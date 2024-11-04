package lotto.view;

import java.util.Map;

public interface OutputView<O> {

    void print(O o);

    void print(Map<? extends O, ?> o);
}
