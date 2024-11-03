package lotto.view;

import lotto.view.io.Input;
import lotto.view.io.Output;

public class LottoView {
    public final Input input;
    public final Output output;

    public LottoView() {
        this.input = new Input();
        this.output = new Output();
    }
}
