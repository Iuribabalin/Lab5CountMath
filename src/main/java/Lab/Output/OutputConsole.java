package Lab.Output;

public class OutputConsole {
    DrawChart drawChart = new DrawChart();

    public void real(double x, int nf){
        System.out.print("Реальный Y полученый при подстановке в функцию ");
        if(nf==1)
            System.out.print("sin(x) = ");
        else if(nf==2){
            System.out.print("x^2+3*x-2 = ");
        }else{
            System.out.print("3^x-x^2+2*x = ");
        }
        System.out.println(x);
    }

    public void count(double x){
        System.out.println("Вычесленный Y методом Лагранжа " + x);
    }

    public void countNewton(double x){
        System.out.println("Вычесленный Y Ньютона с конечными разностями " + x);
    }

    public void countError(double error){
        System.out.println("Погрешность вычислений R(x) ~ " + error);
    }

    public void outSection(double[][] points){
        System.out.println("Отрезок ["+points[0][0]+";"+points[0][points[0].length-1]+"]");
    }

    public void outNameMethod(String msg){
        System.out.println("---------------------------------"+msg+
                "---------------------------------");
    }
    public void outEndMethod(){
        System.out.println("---------------------------------" +
                "--------------------------------------------" +
                "----------------------");
    }

    public void drawChart(double[][] points, int nf){
        drawChart.drawLagrange(points,nf);
    }

    public void drawChart(double[][] points){
        drawChart.drawLagrange(points);
    }

    public void drawChartNewton(double[][] points, int nf){
        drawChart.drawNewton(points,nf);
    }

    public void drawChartNewton(double[][] points){
        drawChart.drawNewton(points);
    }
}
