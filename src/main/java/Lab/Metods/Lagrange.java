package Lab.Metods;

import Lab.Func.Fun;

public class Lagrange {
    private double l(int index, double[] points_x, double x) {
        double l = 1;
        for (int i = 0; i < points_x.length; i++) {
            if (i != index) {
                l *= (x - points_x[i]) / (points_x[index] - points_x[i]);
            }
        }
        return l;
    }

    public double getCountValue(double[][] points, double x) {
        double y = 0;
        for (int i = 0; i < points[0].length; i++) {
            y += points[1][i] * l(i, points[0], x);
        }
        return y;
    }

    public double calculationError(double[][] points, int nf, double x){
        double fuc = 1;

        for(int i = 2; i <= points[0].length; i++)
            fuc*=i;

        return getMaxF(points,nf,points[0].length)*getCf(points,x)/fuc;
    }

    private double getMaxF(double[][] points, int nf, int n){
        double max = 0;
        Fun f = new Fun();
       if(n == 1){
            for (int i = 0; i < points[0].length; i++)
                if (max < f.f__(points[0][i],nf))
                    max = f.f__(points[0][i],nf);
        }else{
            for (int i = 0; i < points[0].length; i++)
                if (max < f.f_n(points[0][i],nf,n))
                    max = f.f_n(points[0][i],nf,n);
        }
        return max;
    }

    private double getCf(double[][] points, double x){
        double out = 1;
        for(int i = 0; i < points[0].length;i++){
            out*=x-points[0][i];
        }
        return Math.abs(out);
    }
}
