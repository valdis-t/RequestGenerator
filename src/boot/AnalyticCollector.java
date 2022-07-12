package boot;

import util.analytic.Analytic;

public class AnalyticCollector {
    private static AnalyticCollector instance;
    private Analytic analytic;

    private AnalyticCollector(){
        analytic = new Analytic();
    }

    public static AnalyticCollector getInstance(){
        if(instance == null) instance = new AnalyticCollector();
        return instance;
    }

    public void save(){
        analytic.saveAllAnalytic();
    }

    public Analytic getAnalytic(){
        return analytic;
    }
}
