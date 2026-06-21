package design_patterns.FactoryMethodPatternExample;

public class ExcelDocument implements Document{

    @Override
    public void open() {
        System.out.println("Opening Excel document...");
    }
}
