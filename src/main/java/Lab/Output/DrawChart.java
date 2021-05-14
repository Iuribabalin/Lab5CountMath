package Lab.Output;

import Lab.Func.Fun;
import Lab.Metods.Lagrange;
import Lab.Metods.Newton;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;

public class DrawChart {

    public void drawLagrange(double[][] points, int nf){
        Fun f = new Fun();
        Lagrange lagrange = new Lagrange();

        XYSeries series_points = new XYSeries("Points");
        XYSeries series_real = new XYSeries("Real");
        XYSeries series_lagrange = new XYSeries("Lagrange");

        XYSeriesCollection dataset = new XYSeriesCollection();

        for(int i = 0; i < points[0].length; i++){
            series_points.add(points[0][i], points[1][i]);
        }
        for(double i = points[0][0]; i <= points[0][points[0].length-1]; i+=0.1){
            series_real.add(i, f.f(i,nf));
        }

        for(double i = points[0][0]; i <= points[0][points[0].length-1]; i+=0.1){
            series_lagrange.add(i,lagrange.getCountValue(points,i));
        }

        dataset.addSeries(series_points);
        dataset.addSeries(series_real);
        dataset.addSeries(series_lagrange);

        JFreeChart chart = ChartFactory.createXYLineChart("Лагранж","x",
                "y", dataset, PlotOrientation.VERTICAL,
                true, true, false);

        JFrame frame =
                new JFrame("MinimalStaticChart");
        // Помещаем график на фрейм
        frame.getContentPane()
                .add(new ChartPanel(chart));
        frame.setSize(500,400);
        frame.show();
    }

    public void drawLagrange(double[][] points){
        Lagrange lagrange = new Lagrange();

        XYSeries series_points = new XYSeries("Points");
        XYSeries series_lagrange = new XYSeries("Lagrange");

        XYSeriesCollection dataset = new XYSeriesCollection();

        for(int i = 0; i < points[0].length; i++){
            series_points.add(points[0][i], points[1][i]);
        }

        for(double i = points[0][0]; i <= points[0][points[0].length-1]; i+=0.1){
            series_lagrange.add(i,lagrange.getCountValue(points,i));
        }

        dataset.addSeries(series_points);
        dataset.addSeries(series_lagrange);

        JFreeChart chart = ChartFactory.createXYLineChart("Лагранж","x",
                "y", dataset, PlotOrientation.VERTICAL,
                true, true, false);

        JFrame frame =
                new JFrame("MinimalStaticChart");
        // Помещаем график на фрейм
        frame.getContentPane()
                .add(new ChartPanel(chart));
        frame.setSize(500,400);
        frame.show();
    }

    public void drawNewton(double[][] points, int nf){
        Fun f = new Fun();
        Newton newton = new Newton();

        XYSeries series_points = new XYSeries("Points");
        XYSeries series_real = new XYSeries("Real");
        XYSeries series_newton = new XYSeries("Newton");

        XYSeriesCollection dataset = new XYSeriesCollection();

        for(int i = 0; i < points[0].length; i++){
            series_points.add(points[0][i], points[1][i]);
        }
        for(double i = points[0][0]; i <= points[0][points[0].length-1]; i+=0.1){
            series_real.add(i, f.f(i,nf));
        }

        for(double i = points[0][0]; i <= points[0][points[0].length-1]; i+=0.1){
            series_newton.add(i,newton.getCountValue(points,i));
        }

        dataset.addSeries(series_points);
        dataset.addSeries(series_real);
        dataset.addSeries(series_newton);

        JFreeChart chart = ChartFactory.createXYLineChart("Ньютон","x",
                "y", dataset, PlotOrientation.VERTICAL,
                true, true, false);

        JFrame frame =
                new JFrame("MinimalStaticChart");
        // Помещаем график на фрейм
        frame.getContentPane()
                .add(new ChartPanel(chart));
        frame.setSize(500,400);
        frame.show();
    }

    public void drawNewton(double[][] points){
        Newton newton = new Newton();

        XYSeries series_points = new XYSeries("Points");
        XYSeries series_newton = new XYSeries("Newton");

        XYSeriesCollection dataset = new XYSeriesCollection();

        for(int i = 0; i < points[0].length; i++){
            series_points.add(points[0][i], points[1][i]);
        }

        for(double i = points[0][0]; i <= points[0][points[0].length-1]; i+=0.1){
            series_newton.add(i,newton.getCountValue(points,i));
        }

        dataset.addSeries(series_points);
        dataset.addSeries(series_newton);

        JFreeChart chart = ChartFactory.createXYLineChart("Ньютон","x",
                "y", dataset, PlotOrientation.VERTICAL,
                true, true, false);

        JFrame frame =
                new JFrame("MinimalStaticChart");
        // Помещаем график на фрейм
        frame.getContentPane()
                .add(new ChartPanel(chart));
        frame.setSize(500,400);
        frame.show();
    }
}
