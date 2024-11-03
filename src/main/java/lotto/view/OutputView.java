package lotto.view;

import java.math.BigInteger;
import java.util.List;

public class OutputView {

    private static final String DELIMITER = ", ";

    public void printErrorMessage(Exception e) {
        System.out.println(e.getMessage());
    }

    public void printNumberOfLotto(BigInteger numberOfLotto) {
        PromptMessage.printLottoCount(numberOfLotto);
    }

    public void printNumbersCollections(List<List<Integer>> numberCollections) {
        StringBuilder builder = new StringBuilder();
        for(List<Integer> numbers: numberCollections) {
            builder.append("[");
            for (Integer number: numbers) {
                builder.append(number).append(DELIMITER);
            }
            builder.append("]\n");
        }
        System.out.println(builder.append("\n"));
    }
}
