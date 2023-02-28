package entities;

public class IndividualTaxPayer extends Contributor{
    private Double healthExpenses;
    public IndividualTaxPayer()
    {}

    public IndividualTaxPayer(String name, Double annualIncome, Double healthExpenses) {
        super(name, annualIncome);
        this.healthExpenses = healthExpenses;
    }

    @Override
    public double showTaxes() {

        if(getAnnualIncome() < 20000.0)
        {
            double taxes = getAnnualIncome() * 0.15;
            if(healthExpenses > 0)
            {
                double temp = healthExpenses * 0.5;
                taxes += temp;
            }
            return taxes;

        } else {
            double taxes = getAnnualIncome() * 0.25;
            if(healthExpenses > 0)
            {
                double temp = healthExpenses * 0.5;
                taxes += temp;
            }
            return taxes;
        }
    }

    public Double getHealthExpenses() {
        return healthExpenses;
    }

    public void setHealthExpenses(Double healthExpenses) {
        this.healthExpenses = healthExpenses;
    }
}
