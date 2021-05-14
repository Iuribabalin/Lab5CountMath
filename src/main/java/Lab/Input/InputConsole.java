package Lab.Input;

import Lab.Func.Fun;

import java.util.Scanner;

public class InputConsole {
    Scanner in = new Scanner(System.in);

    public boolean methodInput(){
        while (true) {
            System.out.print("1.Ввести таблицу данных x/y\n" +
                    "2.Ввести данные на основе выбранной далее функции:\n");
            try {
                int answer = Integer.parseInt(in.next().trim());
                if (answer == 1)
                    return true;
                else if (answer == 2)
                    return false;
            }catch (NumberFormatException ignored) {
            }
        }
    }

    public int function_selection(){
        while (true) {
            System.out.print("Выберите функцию: \n" +
                    "1.sin(x)\n" +
                    "2.x^2+3*x-2\n" +
                    "3.3^x-x^2+2*x:\n");
            try {
                int nf = Integer.parseInt(in.next().trim());
                if(nf > 0 && nf <= 3){
                    return nf;
                }
            } catch (NumberFormatException ignored) {
            }
        }
    }

    public double[][] inputPoint_X(int nf){
        Fun f = new Fun();
        int n = inN();
        double[][] points = new double[2][n];

        for(int i = 0; i < n; i++){
            while (true) {
                points[0][i] = inPointX("Введите координату X: ");
                if(!findPoint(i,points,points[0][i])){
                    break;
                }else{
                    System.out.println("Такой X уже присутствует в выборке");
                }
            }
            points[1][i] = f.f(points[0][i],nf);
        }

        return points;
    }

    private boolean findPoint(int n,double[][] points, double point){
        for(int i = 0; i < n; i++) {
            if (points[0][i] == point)
                return true;
        }
        return false;
    }

    public double[][] inputPoints(){
        int n = inN();
        double[][] points = new double[2][n];

        for(int i = 0; i < n; i++){
            while (true) {
                points[0][i] = inPointX("Введите координату X: ");
                if(!findPoint(i,points,points[0][i])){
                    break;
                }else{
                    System.out.println("Такой X уже присутствует в выборке");
                }
            }
            points[1][i] = inPointY();
        }

        return points;
    }

    private int inN(){
        while (true) {
            System.out.print("Введите колиичество точек: ");
            try {
                return Integer.parseInt(in.next().trim());
            } catch (NumberFormatException ignored) {
            }
        }
    }

    public double inPointX(String msg){
        while (true) {
            System.out.print(msg);
            try {
                return Double.parseDouble(in.next().trim().replaceAll(",", "\\."));
            } catch (NumberFormatException ignored) {
            }
        }
    }

    private double inPointY(){
        while (true) {
            System.out.print("Введите координату Y: ");
            try {
                return Double.parseDouble(in.next().trim().replaceAll(",", "\\."));
            } catch (NumberFormatException ignored) {
            }
        }
    }
}
