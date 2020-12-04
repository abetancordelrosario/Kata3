package kata3;

import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

public class HistogramDisplay extends ApplicationFrame{
    
    private final Histogram<String> histogram;
    
    public HistogramDisplay(String title, Histogram<String> histogram) {
        super(title);
        this.histogram = histogram;
        this.setContentPane(createPanel());
        this.pack();
    }
    

    private JPanel createPanel(){
        ChartPanel charPanel = new ChartPanel(createChart(createDataSet()));
        return charPanel;
    }
    
    
     private JFreeChart createChart(DefaultCategoryDataset dataSet){
         JFreeChart chart = ChartFactory.createBarChart("JFree Chart Histogram",
                                                        "email domains",
                                                        "nº emails",
                                                        dataSet,
                                                        PlotOrientation.VERTICAL,
                                                        false,
                                                        false,
                                                        rootPaneCheckingEnabled);
         
         return chart;
     }
     
     private DefaultCategoryDataset createDataSet(){
         DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
         
        for (String key : histogram.keySet()){
            dataSet.addValue(histogram.get(key),"",key);
        }
         
 //        dataSet.addValue(23, "", "ulpgc.es");
 //        dataSet.addValue(31, "", "dis.ulpgc.es");
 //        dataSet.addValue(16, "", "hotamil.com");
 //        dataSet.addValue(7, "", "ull.es");
  //       dataSet.addValue(39, "", "gmail.com");
         return dataSet;
     }
     
     public void execute(){
         this.setVisible(true);
     }
}
