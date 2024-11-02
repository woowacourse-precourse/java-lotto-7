package lotto.constant;

import static java.lang.String.format;
import static java.lang.String.join;
import static java.lang.System.lineSeparator;

public enum DefaultPrompt {
    ENTER_PURCHASE_AMOUNT_TEXT("구입금액을 입력해 주세요.") {
        @Override
        public void display(Object... args) {
            System.out.println(this);
        }
    },
    RESULT_PURCHASE_AMOUNT_AND_AUTOMATIC_LOTTO_TEMPLATE(join(lineSeparator(), "%d개를 구매했습니다.", "%s")) {
        @Override
        public void display(Object... args) {
            if (args.length != 2) {
                throw new IllegalArgumentException("[ERROR] 필요한 매개변수가 없습니다.");
            }

            System.out.println(format(this.toString(), args));
        }
    };

    private final String text;

    DefaultPrompt(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return this.text;
    }

    public static void display(String errorMessage) {
        System.out.println(errorMessage);
    }

    public abstract void display(Object... args);

}
