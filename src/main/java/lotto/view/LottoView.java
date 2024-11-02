package lotto.view;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;
import lotto.model.lotto.Lotto;

public class LottoView {
    private Supplier<String> inputSupplier;
    private Consumer<String> outputConsumer;

    public LottoView(Supplier<String> inputSupplier, Consumer<String> outputConsumer) {
        this.inputSupplier = inputSupplier;
        this.outputConsumer = outputConsumer;
    }

    public String inputPurchaseAmount() {
        outputConsumer.accept("구입금액을 입력해 주세요.");
        return inputSupplier.get();
    }

    public String inputLottos() {
        outputConsumer.accept("당첨 번호를 입력해 주세요.");
        return inputSupplier.get();
    }

    public String inputBonus() {
        outputConsumer.accept("보너스 번호를 입력해 주세요.");
        return inputSupplier.get();
    }
}
