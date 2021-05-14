package Lab.Metods;

public class Sort {
    public double[][] sortPoints(double[][] points){
        for(int i = 0; i < points[0].length-1;i++){
            for(int j = 0; j < points[0].length-i-1;j++)
                if(points[0][j] > points[0][j+1]){
                    double temp = points[0][j];
                    points[0][j] = points[0][j+1];
                    points[0][j+1] = temp;
                    temp = points[1][j];
                    points[1][j] = points[1][j+1];
                    points[1][j+1] = temp;
                }
        }
        return points;
    }
}
