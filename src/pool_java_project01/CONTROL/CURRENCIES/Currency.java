package pool_java_project01.CONTROL.CURRENCIES;
public class Currency {
    protected String name;
    protected double convertDollar;
    public Currency(String name, double rate) {
        this.name = name;
        this.convertDollar = rate;
    }
    public String getName() {
        return name;
    }
    
    public void seeMoneyName(){
        System.out.println(this.name);
    }
    public double convertToDollar(){
        return convertDollar;   
    }
}
