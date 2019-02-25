//This code has potential performance issue when used by multi-threaded application
//See Singleton4 that solves this performance issue
public class ChocolateBoilerSingleton3 {
    private boolean empty;
    private boolean boiled;

    private static ChocolateBoilerSingleton3 uniqueInstance;

    private ChocolateBoilerSingleton3() {
        empty = true;
        boiled = false;
    }

    //synchronized is expensive esp doing over the entire method
    //this may be the potential bottleneck in performance
    public static synchronized ChocolateBoilerSingleton3 getInstance() {
        if (uniqueInstance == null) {
            System.out.println("Creating unique instance of Chocolate Boiler");
            uniqueInstance = new ChocolateBoilerSingleton3();
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
