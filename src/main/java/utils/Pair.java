package utils;

//C++ 등지의 언어에 있는 pair 클래스 구현
public class Pair<T1, T2> {
    
    public T1 first;
    public T2 second;

    public Pair(T1 first, T2 second) {
        this.first = first;
        this.second = second;
    }
}
