package lotto;

public class Pair {
    private boolean validated;
    private Object value;

    public Pair() {}

    public Pair(boolean validated, Object value) {
        this.validated = validated;
        this.value = value;
    }

    public void set(boolean validated, Object value) {
        this.validated = validated;
        this.value = value;
    }

    public boolean isValidated() { return validated; }
    public Object getValue() { return value; }
}
