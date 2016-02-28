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
	
	public static final String MY_FORECAST = "MY_FORECAST";
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
    		if (methodName.equals(MY_FORECAST)){
    			List<PredictPopulation> est = getPredictForMenWomenOrAll(ModelMgr.ESTIMATES, type);
    			final int startYear = 1950;
    			final int endYear = 2015;
    			double[][] f = new double[endYear-startYear+1][endYear-startYear+1];
    			for (PredictPopulation e: est)
    				f[e.predictYear-startYear][0] = e.populationNumber;
    			for (int j=1; j<=endYear-startYear; j++)
    				for (int i=0; i<=endYear-startYear-j; i++)
    					f[i][j] = f[i+1][j-1]-f[i][j-1];
    			
    			for (int i=0; i<10; i++){
    				for (int j=0; j<10; j++)
    					System.err.print(f[i][j] + " ");
    				System.err.println();
    			}
    			final int predictStartYear = 2015;
    			final int predictEndYear = 2100;
    			for (int i=predictStartYear; i<=predictEndYear; i++){
    				double r = i-endYear;
    				PredictPopulation pp = new PredictPopulation();
    				pp.methodName = methodName;
    				pp.predictYear = i;
    				double fx = 0.0;
    				double rcoeff = 1.0;
    				for (int j=0; j<=Math.min(4, endYear-startYear); j++){
    					if (j>0){
    						rcoeff*= r+j-1;
    						rcoeff/=j;
    					}
    					fx+= rcoeff * f[endYear-startYear-j][j];
    				}
    				pp.populationNumber = (int)Math.round(fx);
    				ret.add(pp);
    				System.err.println(i + " " + fx);
    			}
    		}else{
	    		for (PredictPopulation predict: predicts.get(type))
	    			if (predict.methodName.equals(methodName))
	    				ret.add(predict);
    		}
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
