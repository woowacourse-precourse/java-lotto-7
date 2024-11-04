package lotto.repository;

public interface Repository<T> {
	void save(T item);
		
	T find();
}
