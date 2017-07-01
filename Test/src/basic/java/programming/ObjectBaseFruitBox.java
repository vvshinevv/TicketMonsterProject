package basic.java.programming;

class Orange {
	int sugarContent;
	public Orange(int sugarContent) {
		this.sugarContent = sugarContent;
	}
	public void showSugarContent() {
		System.out.println("당도 " + sugarContent);
	}
}

class Apple {
	int sugarContent;
	public Apple(int sugarContent) {
		this.sugarContent = sugarContent;
	}
	public void showSugarContent() {
		System.out.println("당도 " + sugarContent);
	}
}

class FruitBox<T> {
	T item;
	public void store(T item) {
		this.item = item;
	}
	public T pullOut() {
		return item;
	}
}

public class ObjectBaseFruitBox {

	public static void main(String[] args) {
		FruitBox<Orange> fruitBox = new FruitBox<Orange>();
		fruitBox.store(new Orange(10));
		Orange orange = (Orange)fruitBox.pullOut();
		orange.showSugarContent();
	}

}
