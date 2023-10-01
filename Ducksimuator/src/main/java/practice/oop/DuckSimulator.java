package practice.oop;

public class DuckSimulator {
    public static void main(String[] args) {
        MallardDuck mallard = new MallardDuck();
        FlyBehavior cantFly = new CantFly(); // Assume there is a CantFly class implementing FlyBehavior
        QuackBehavior squeak = () -> System.out.println("Squeak");

        RubberDuck rubberDuck = new RubberDuck(cantFly, squeak);
        DecoyDuck decoy = new DecoyDuck();
        ModelDuck model = new ModelDuck();

        mallard.performQuack();
        rubberDuck.performQuack();
        decoy.performQuack();
        model.performFly();

        model.setFlyBehavior(new FlyRocketPowered()); // Assume there is a FlyRocketPowered class implementing FlyBehavior
        model.performFly();
    }
}

interface FlyBehavior {
    void fly();
}

interface QuackBehavior {
    void quack();
}

class MallardDuck extends Duck {
    private final FlyBehavior flyBehavior;
    private final QuackBehavior quackBehavior;

    public MallardDuck() {
        this.flyBehavior = (FlyBehavior) new FlyWithWings(); // Assume there is a FlyWithWings class implementing FlyBehavior
        this.quackBehavior = new Quack(); // Assume there is a Quack class implementing QuackBehavior
    }

    public void performQuack() {
        quackBehavior.quack();
    }

    public void performFly() {
        flyBehavior.fly();
    }
}

class RubberDuck extends Duck {
    private final FlyBehavior flyBehavior;
    private final QuackBehavior quackBehavior;

    public RubberDuck(FlyBehavior flyBehavior, QuackBehavior quackBehavior) {
        this.flyBehavior = flyBehavior;
        this.quackBehavior = quackBehavior;
    }

    public void performQuack() {
        quackBehavior.quack();
    }

    public void performFly() {
        flyBehavior.fly();
    }
}

class DecoyDuck extends Duck {
    public void performQuack() {
        System.out.println("<< Silence >>");
    }

    public void performFly() {
        System.out.println("I can't fly");
    }
}

class ModelDuck extends Duck {
    private FlyBehavior flyBehavior;

    public ModelDuck() {
        this.flyBehavior = new CantFly();
    }

    public void performQuack() {
        System.out.println("Quack");
    }

    public void performFly() {
        flyBehavior.fly();
    }

    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }
}

class FlyRocketPowered implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("I'm flying with a rocket!");
    }
}

class CantFly implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("I can't fly");
    }
}

class Quack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("Quack");
    }
}
