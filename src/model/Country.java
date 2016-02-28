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
    
    public List<PredictPopulation> getPredictForMenWomenOrAll(String methodName, int type){
    	if (type != 2){
    		List<PredictPopulation> ret = new ArrayList<PredictPopulation>();
    		for (PredictPopulation predict: predicts.get(type))
    			if (predict.methodName.equals(methodName))
    				ret.add(predict);
    		return ret;
    	}else{
    		List<PredictPopulation> males = getPredictForMenWomenOrAll(methodName, 0);
    		List<PredictPopulation> females = getPredictForMenWomenOrAll(methodName, 1);
    		List<PredictPopulation> ret = new ArrayList<PredictPopulation>();
    		for (PredictPopulation male: males)
    			ret.add(male);
    		for (PredictPopulation female: females){
    			for (PredictPopulation p: ret)
    				if (p.predictYear == female.predictYear){
    					p.populationNumber+= female.populationNumber;
    					break;
    				}
    		}
    		return ret;
    	}        
    }
}
