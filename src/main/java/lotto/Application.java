package lotto;

import lotto.domain.Lottos;
import lotto.external.RandomNumbersGenerator;

public class Application {

    public static void main(String[] args) {

        Lottos lottos = new Lottos(3, new RandomNumbersGenerator());


    }
}
