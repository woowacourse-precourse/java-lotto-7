package lotto.common;

public class RepeatInputUntilSuccess {
    public static <T> T repeatInputUntilSuccess(InputSupplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
