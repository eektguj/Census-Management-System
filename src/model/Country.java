/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

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
}
