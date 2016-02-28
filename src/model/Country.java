/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author amir
 */
public class Country {
	public int code;
    public String countryName;
    public ArrayList<GrowthRate> growths = new ArrayList<GrowthRate>();
    public ArrayList<ArrayList<PredictPopulation>> predicts = 
    		new ArrayList<ArrayList<PredictPopulation>>();
    
    public Country(){
    	predicts.add(new ArrayList<PredictPopulation>());
    	predicts.add(new ArrayList<PredictPopulation>());
    }
    
    public PredictPopulation getPredictByYear(String methodName, int year, int type){
        for (PredictPopulation predict: predicts.get(type)){
            if (predict.methodName.equals(methodName) && predict.predictYear == year)
                return predict;
        }
        return null;
    }

    public List<PredictPopulation> getPredictByName(String methodName, int type) {
        List<PredictPopulation> result = new ArrayList<>();
        for (PredictPopulation predict: predicts.get(type)){
            if (predict.methodName.equals(methodName))
                result.add(predict);
        }
        return result;
    }
    
    public List<PredictPopulation> getPredictForAllMenAndWomen(String methodName, int type){
        return new ArrayList<>();
    }
}
