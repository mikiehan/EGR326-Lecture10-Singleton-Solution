//This code works well even when used by multi-threaded application
public class ChocolateBoilerSingleton2 {
    private boolean empty;
    private boolean boiled;

    private static final ChocolateBoilerSingleton2 uniqueInstance = new ChocolateBoilerSingleton2();

    private ChocolateBoilerSingleton2() {
        empty = true;
        boiled = false;
    }

    public static ChocolateBoilerSingleton2 getInstance() {
        return uniqueInstance;
    }

    public void fill() {
        if (isEmpty()) {
            empty = false;
            boiled = false;
        }
    }

    public void drain() {
        if (!isEmpty() && isBoiled()) {
            // drain the boiled milk and chocolate
            empty = true;
        }
    }

    public void boil() {
        if (!isEmpty() && !isBoiled()) {
            // bring the contents to a boil
            boiled = true;
        }
    }

    public boolean isEmpty() {
        return empty;
    }

    public boolean isBoiled() {
        return boiled;
    }
}
