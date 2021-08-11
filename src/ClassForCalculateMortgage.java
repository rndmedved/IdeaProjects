import Tests.Mortgage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ClassForCalculateMortgage {

    public static void main(String[] args) throws IOException {
        int timeCredit =216;
        double credit =3035000;
        double insurance ;
        double percent = 6.4;
        int day = 21;
        int month = 9;
        int year = 2020;

        /*
        ------------------------------------------------------------------
        Раскоментируй код, если хочешь вручную вводить год, месяц, день, сумму, процент и время выплати кредита.
        __________________________________________________________________
         */
/*
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите год взятия кредита");
        year = Integer.parseInt((bufferedReader.readLine()));
        System.out.println("Введите месяц взятия кредита");
        month = Integer.parseInt((bufferedReader.readLine()));
        System.out.println("Введите день взятия кредита");
        day = Integer.parseInt((bufferedReader.readLine()));
        System.out.println("Введите сумму кредита");
        credit = Double.parseDouble((bufferedReader.readLine()));
        System.out.println("Введите время выплаты кредита в месяцах");
        timeCredit = Integer.parseInt((bufferedReader.readLine()));
        System.out.println("Введите процент, под который вам выдают кредит");
        percent = Double.parseDouble((bufferedReader.readLine()));
*/




        Mortgage mortgage = new Mortgage(credit, percent, timeCredit);
        System.out.printf("Ежемесячный платеж по кредиту составит %.2f\n", mortgage.calculateMortgage());
        System.out.printf("Переплата по кредиту на сумму %.2f составит %.2f",credit, mortgage.overPay(mortgage.calculateMortgage()));
        System.out.println();
//        System.out.println("Расчет со страховкой");
 //       mortgage.setInsurance(insurance);
//        System.out.printf("Ежемесячный платеж со страховкой %.2f\n", mortgage.calculateMortgageUseInsurance());
//        System.out.printf("Переплата по кредиту с учетом страховки %.2f\n", mortgage.overPay(mortgage.calculateMortgageUseInsurance()));
        mortgage.calculateMortgagePerPercent(year, month, day); //Расчет ежемесячных выплат при оплате только ежмесячного платежа
        //mortgage.setPayMonth(mortgage.calculateMortgage()); // Установление ежемесячного платежа (он не может быть меньше mortgage.calculateMortgage())
        //mortgage.calculateMortgagePerPayMonth(year, month, day);//Расчет ежемесячных выплат с учетом увеличения ежемесячного платежа.



    }
}
