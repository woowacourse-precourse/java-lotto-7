package lotto.view;

import java.util.List;
import java.util.function.Supplier;

public abstract class AbstractInputView {

    public final Integer inputSingleInteger(Supplier<Integer> input) {
        while (true) {
            try {
                return input.get();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public final List<Integer> inputMultipleInteger(Supplier<List<Integer>> input) {
        while (true) {
            try {
                return input.get();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
