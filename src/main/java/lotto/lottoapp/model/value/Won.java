package lotto.lottoapp.model.value;

import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.Objects;

public class Won {

    private final BigInteger amount;

    private Won(BigInteger amount) {
        if (amount == null) {
            throw new IllegalArgumentException("null을 지정할 수 없습니다.");
        }
        if (isSmallerThanZero(amount)) {
            throw new IllegalArgumentException("금액은 음수일 수 없습니다.");
        }
        this.amount = amount;
    }

    private Won(Integer amount) {
        this(BigInteger.valueOf(amount));
    }

    public static Won of(Integer amount) {
        return new Won(amount);
    }

    public static Won of(Long amount) {
        return new Won(BigInteger.valueOf(amount));
    }

    public Won add(Integer amount) {
        return add(new Won(amount));
    }

    public Won add(Won won) {
        return new Won(amount.add(won.amount));
    }

    public Won divide(Won won) {
        return new Won(amount.divide(won.amount));
    }

    public Won reminder(Won won) {
        return new Won(amount.remainder(won.amount));
    }

    public int getIntValue() {
        return amount.intValue();
    }

    private static boolean isSmallerThanZero(BigInteger amount) {
        return amount.compareTo(BigInteger.ZERO) < 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Won other = (Won) o;
        return Objects.equals(amount, other.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }

    @Override
    public String toString() {
        return new DecimalFormat("#,###")
                .format(amount);
    }

}
