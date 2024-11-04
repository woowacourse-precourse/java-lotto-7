package lotto;

import lotto.domain.LottoGame;

public class Application {
    public static void main(String[] args) {

        LottoGame lottoGame = LottoGameSetter.set();

        LottoNumberMatcher lottoMatcher = LottoNumberMatcher.from(lottoGame);

        lottoMatcher.match();
    }
}
