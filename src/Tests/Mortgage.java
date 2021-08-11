package Tests;

public class Mortgage {
    private double percent;
    private double bodyOfCredit;
    private int timeCredit;
    private double insurance;
    private double payMonth;

    public void setPayMonth(double payMonth) {
        this.payMonth = payMonth;
    }

    public void setInsurance(double insurance) {
        this.insurance = insurance;
    }

    public void setPercent(double percent) {
        this.percent = percent;
    }

    public void setBodyOfCredit(double bodyOfCredit) {
        this.bodyOfCredit = bodyOfCredit;
    }

    public void setTimeCredit(int timeCredit) {
        this.timeCredit = timeCredit;
    }

    public double calculateMortgage(){
        double payPerMonth;
        double r= percent/1200;
        double calc = Math.pow(1+r,-timeCredit);
            payPerMonth = bodyOfCredit*r/(1-calc);
        return payPerMonth;
    }
    public double overPay(double payPerMonth){

        return payPerMonth*timeCredit - bodyOfCredit;
    }
    public double calculateMortgageUseInsurance(){
        if (!(insurance == 0)){
            return calculateMortgage() + insurance/12;
        } else  return calculateMortgage();
    }

    public void calculateMortgagePerPercent(int year, int month, int day){
        double body = bodyOfCredit;
        double payPercent;

        while (body > 0 ){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            payPercent = body * percent/100 / daysInYear(year)*(daysInMonth(year, month) - day);

            month ++;
            if (month == 13){
                month = 1;
                year++;
            }
            payPercent += body * percent/100 / daysInYear(year)*day;
            body = body - (calculateMortgage() - payPercent);
            System.out.printf("%d.%d.%d выплаты по процентам составили %.2f , Выплаты основного долга %.2f , Остаток по основному долгу %.2f\n", day, month, year, payPercent, calculateMortgage() - payPercent, body);

        }
    }
    public void calculateMortgagePerPayMonth(int year, int month, int day){
        double body = bodyOfCredit;
        double payPercent;
        double overpay=0;

        while (body > 0 ){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            payPercent = body * percent/100 / daysInYear(year)*(daysInMonth(year, month)-day);

            month ++;
            if (month == 13){
                month = 1;
                year++;
            }
            payPercent += body * percent/100 / daysInYear(year)*day;
            body = body - (payMonth - payPercent);
            overpay += payPercent;
            System.out.printf("%d.%d.%d выплаты по процентам составили %.2f , Выплаты основного долга %.2f , Остаток по основному долгу %.2f\n", day, month, year, payPercent, calculateMortgage() - payPercent, body);

        }
        System.out.printf("Переплата банку составила %.2f\n", overpay);
    }

    public Mortgage(double bodyOfCredit, double percent, int timeCredit){
        this.bodyOfCredit = bodyOfCredit;
        this.percent = percent;
        this.timeCredit = timeCredit;
    }

    private int daysInYear(int year){
        if (year % 4 == 0)
                return 366;
        else return 365;
    }
    private int daysInMonth(int year, int month){
        int numberOfDays = 0;
        switch (month){
            case 1:
            case 3: case 5: case 7: case 8: case 10: case 12:
                numberOfDays = 31;
                break;
            case 4: case 6: case 9: case 11:
                numberOfDays = 30;
                break;
            case 2:
                {
                    if (year % 4 == 0){
                        numberOfDays = 29;
                    }
                    else numberOfDays = 28;
                }
                break;
        }
        return numberOfDays;
    }
}
