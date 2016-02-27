/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author amir
 */

public class ModelMgr {
    private static String dataFileAddress = "data.json";
    private ModelMgr _instance;
    Model model;
    
    public ModelMgr getInstance(){
        if(_instance == null)
            _instance = new ModelMgr();
        return _instance;
    }
    private ModelMgr(){
        if(new File(dataFileAddress).exists()){
            loadDataFile();
        }
        else{
            createDataFile();
            loadDataFile();
        }
    }

    private void createDataFile() {
        //TODO Saeed
        saveDataFile();
    }

    private void loadDataFile() {
        Gson gson = new Gson();

	try {
		BufferedReader br = new BufferedReader(new FileReader(dataFileAddress));
		model = gson.fromJson(br, Model.class);
	} catch (IOException e) {
		e.printStackTrace();
	}
    }
    
    public void saveDataFile(){
        Gson gson = new Gson();
        String json = gson.toJson(model);
        try {
            FileWriter writer = new FileWriter(dataFileAddress);
            writer.write(json);
            writer.close();

	} catch (IOException e) {
            e.printStackTrace();
	}
    }
    
    public List<Country> getCountryList(){
        return model.countryList;
    }
    
    public Country getCountry(String countryName){
        for (Country country : model.countryList) {
            if(country.countryName.equals(countryName))
                return country;
        }
        return null;
    }
    
    
}
