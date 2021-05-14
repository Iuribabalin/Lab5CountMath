package Lab.Func;

public class Fun {
    public double f(double x, int nf){
        if(nf==1)
            return Math.sin(x);
        else if(nf==2)
            return Math.pow(x,2)+3*x-2;
        else
            return Math.pow(3,x)-Math.pow(x,2)+2*x;
    }
    public double f_(double x, int nf){
        if(nf==1)
            return Math.cos(x);
        else if(nf==2)
            return 2*x+3;
        else
            return Math.pow(3,x)*Math.log(3)-2*x+2;
    }

    public double f__(double x, int nf){
        if(nf==1)
            return -1*Math.sin(x);
        else if(nf==2)
            return 2;
        else
            return -2+3*Math.log(3);
    }

    public double f_n(double x, int nf, int n){
        if(nf==1)
            if(n%2==0)
                return -1*Math.sin(x);
            else
                return Math.cos(x);
        else if(nf==2)
            return 0;
        else{
            return 0;
        }
    }




}
