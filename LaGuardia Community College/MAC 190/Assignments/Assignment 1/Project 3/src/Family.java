public class Family {
    private double income;
    private int size;

    //constructor, no default constructor because not mentioned
    public Family(double income, int size) {
        this.income = income;
        this.size = size;
    }

    //if family is poor return true
    public Boolean isPoor(double housingCost, double foodCost) {
        if ((housingCost + (foodCost * size)) > (income / 2)) {
            return true;
        } else {
            return false;
        }
    }

    public String toString() {
        return "Family income: $" + income + "\n" +
                "Family size: " + size + "\n";
    }
}