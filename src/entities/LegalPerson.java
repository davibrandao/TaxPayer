package entities;

public class LegalPerson extends Contributor{
    private Integer employeeQuantity;

    public LegalPerson(String name, Double annualIncome, Integer employeeQuantity) {
        super(name, annualIncome);
        this.employeeQuantity = employeeQuantity;
    }

    @Override
    public double showTaxes() {
        double taxes;
        if(employeeQuantity < 10)
        {
            taxes = getAnnualIncome() * 0.16;
        } else {
            taxes = getAnnualIncome() * 0.14;
        }
        return taxes;
    }
}
