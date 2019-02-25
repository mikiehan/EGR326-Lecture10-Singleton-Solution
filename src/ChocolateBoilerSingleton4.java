//This code works well even when used by multi-threaded application
public class ChocolateBoilerSingleton4 {
    private boolean empty;
    private boolean boiled;

    private static volatile ChocolateBoilerSingleton4 uniqueInstance;

    private ChocolateBoilerSingleton4() {
        empty = true;
        boiled = false;
    }

    public static ChocolateBoilerSingleton4 getInstance() {
        if (uniqueInstance == null) {
            synchronized (ChocolateBoilerSingleton4.class) {
                if(uniqueInstance == null) {
                    System.out.println("Creating unique instance of Chocolate Boiler");
                    uniqueInstance = new ChocolateBoilerSingleton4();
                }
            }
        }
        System.out.println("Returning instance of Chocolate Boiler");
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
