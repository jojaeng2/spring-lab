package decorator.pattern;

public class MilkDecorator extends Decorator{
    public MilkDecorator(Component coffeeComponent) {
        super(coffeeComponent);
    }

    public String add() {
        return super.add() + "우유";
    }
}
