package Lab;

import Lab.Func.Fun;
import Lab.Input.InputConsole;
import Lab.Metods.Lagrange;
import Lab.Metods.Newton;
import Lab.Metods.Sort;
import Lab.Output.OutputConsole;

public class main {
    public static void main(String args[]){
        InputConsole in = new InputConsole();
        OutputConsole out = new OutputConsole();
        Lagrange lagrange = new Lagrange();
        Newton newton = new Newton();
        Sort sort = new Sort();
        Fun f = new Fun();

        while (true) {
            boolean flag = !in.methodInput();
            if(flag){
                int nf = in.function_selection();
                double[][] points = in.inputPoint_X(nf);
                points = sort.sortPoints(points);
                double x = in.inPointX("Введите координату X для поиска приближённого значения: ");
                out.outNameMethod("Многочлен Лагранжа");
                out.outSection(points);
                out.real(f.f(x,nf),nf);
                out.count(lagrange.getCountValue(points,x));
                out.countError(lagrange.calculationError(points,nf,x));
                out.drawChart(points,nf);
                out.outEndMethod();
                out.outNameMethod("Многочлен Ньютона с конечными разностями");
                out.outSection(points);
                out.real(f.f(x,nf),nf);
                out.countNewton(newton.getCountValue(points,x));
                out.countError(newton.calculationError(points,nf,x));
                out.drawChartNewton(points,nf);
                out.outEndMethod();
            }else{
                double[][] points = in.inputPoints();
                points = sort.sortPoints(points);
                double x = in.inPointX("Введите координату X для поиска приближённого значения: ");
                out.outNameMethod("Многочлен Лагранжа");
                out.outSection(points);
                out.count(lagrange.getCountValue(points,x));
                out.drawChart(points);
                out.outEndMethod();
                out.outNameMethod("Многочлен Ньютона с конечными разностями");
                out.outSection(points);
                out.count(newton.getCountValue(points,x));
                out.drawChartNewton(points);
                out.outEndMethod();

            }
        }
    }
}
