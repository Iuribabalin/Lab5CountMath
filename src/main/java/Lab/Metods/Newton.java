package Lab.Metods;

import Lab.Func.Fun;

public class Newton{

    private double getDivider(int n, int index, double[][] points){
        double divider = 1;
        for(int i = 0; i < n; i++){
            if(i != index)
                divider *= points[0][index] - points[0][i];
        }
        return divider;
    }

    private double getF(double[][] points, int n){
        double f = 0;
        for(int i = 0; i < n; i++){
            f += points[1][i]/getDivider(n,i,points);
        }
        return f;
    }

    public double getCountValue(double[][] points, double x) {
       double y = points[1][0];
       double cf = 1;
       for(int i = 2; i <= points[0].length; i++){
            cf *= x-points[0][i-2];
            y += cf*getF(points,i);
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
