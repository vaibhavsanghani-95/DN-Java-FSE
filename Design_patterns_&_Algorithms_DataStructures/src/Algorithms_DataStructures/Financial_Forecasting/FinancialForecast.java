package Algorithms_DataStructures.Financial_Forecasting;

class FinancialForecast {
    public static double predictFutureValue(double currentValue, double growthRate, int years) {
        if (years == 0) {
            return currentValue;
        }
        return (1 + growthRate) * predictFutureValue(currentValue, growthRate, years - 1);
    }

    static void main(String[] args) {
        double currentValue = 10000;
        double growthRate = 0.10;
        int years = 5;
        double futureValue = predictFutureValue(currentValue, growthRate, years);

        System.out.println("Future Value after " + years + " years: ₹" + futureValue);
    }
}