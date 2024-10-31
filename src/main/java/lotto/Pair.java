package lotto;

public class Pair {
    private boolean bool;
    private Object value;

    public Pair() {}

    public Pair(boolean bool, Object value) {
        this.bool = bool;
        this.value = value;
    }

    public void set(boolean bool, Object value) {
        this.bool = bool;
        this.value = value;
    }

    public boolean getBoolean() { return bool; }
    public Object getValue() { return value; }
}
