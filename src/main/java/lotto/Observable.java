package lotto;

public interface Observable {
    void registerObserver(Observer observer);

    void notifyObserver();
}