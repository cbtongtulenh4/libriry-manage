package Controller;

public interface Ctr<T> {

	T createObject();

	void showObject(T Obj);

}