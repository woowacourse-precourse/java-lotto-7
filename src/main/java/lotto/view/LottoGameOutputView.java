package lotto.view;

import java.util.List;
import lotto.config.ConsoleMessage;
import lotto.model.Lotto;
import lotto.model.LottoGame;

public class LottoGameOutputView extends View {

    private final LottoGame game;

    public LottoGameOutputView(LottoGame game) {
        this.game = game;
    }

    @Override
    protected void printMessage() {
        List<Lotto> items = game.getItems();
        String output = String.format(ConsoleMessage.PURCHASE, items.size());
        System.out.println();
        System.out.println(output);
    }

    @Override
    protected String doRendering() {
        List<Lotto> lottos = game.getItems();
        lottos.forEach(System.out::println);
        return "";
    }
}
