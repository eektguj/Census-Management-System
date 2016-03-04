/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import com.google.gson.Gson;
import forms.CountriesTable;
import forms.EtelaateTafkiki;
import forms.ExportData;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author amir
 */

public class ModelMgr {
	public static int ACC_COUNTRY_CODE_START = 900;
	private static String dataFileAddress = "data.json";
	private static ModelMgr _instance;
        public static String ESTIMATES = "Estimates";
	private Model model = new Model();
        public CountriesTable countriesTable;
        public ExportData exportData;
        public EtelaateTafkiki etelaateTafkiki;

	public static ModelMgr getInstance(){
		if(_instance == null)
                    _instance = new ModelMgr();
		return _instance;
	}
	private ModelMgr(){
		File x = new File(dataFileAddress);
		if(new File(dataFileAddress).exists())
			loadDataFile();
		else
			createDataFile();
	}
	
	private String normal (String s){
		boolean allDigit = true;
		for (int i=0; i<s.length(); i++)
			if (Character.isWhitespace(s.charAt(i))==false && Character.isDigit(s.charAt(i))==false)
				allDigit = false;
		if (allDigit){
			String res = "";
			for (int i=0; i<s.length(); i++)
				if (Character.isDigit(s.charAt(i)))
					res+= s.charAt(i);
			return res;
		}
		int prefix = 0;
		int suffix = s.length()-1;
		while (prefix<s.length() && Character.isWhitespace(s.charAt(prefix)))
			++prefix;
		while (suffix>=0 && Character.isWhitespace(s.charAt(suffix)))
			--suffix;
		if (prefix==s.length())
			return "";
		return s.substring(prefix, suffix+1);
	}
	
	private void readPopulationsData(String directory, int type){
		final int COUNTRY_NAME_COL = 2;
		final int COUNTRY_CODE_COL = 4;
		final int YEAR_START_COL = 5;
		final int YEAR_START_VAL = 1950;
		final int YEAR_START_VAL_PREDICT = 2015;
		
		File dir = new File(directory);
		for (File file: dir.listFiles()){
			System.err.println(file.getAbsolutePath());
			if (file.isDirectory() == true)
				continue;
			try{
				Scanner sc = new Scanner(file);
				while (sc.hasNext()){
					String line = sc.nextLine();
					String[] columns = line.split(",");
					for (int i=0; i<columns.length; i++)
						columns[i] = normal(columns[i]);
					Country country = getCountry(columns[COUNTRY_NAME_COL]);
					if (country == null){
						country = new Country();
						country.countryName = columns[COUNTRY_NAME_COL];
						country.code = Integer.parseInt(columns[COUNTRY_CODE_COL]);
						if (country.code >= ACC_COUNTRY_CODE_START)
							continue;
						model.countryList.add(country);
					}
					for (int i=YEAR_START_COL; i<columns.length; i++){
						int currentYear = i-YEAR_START_COL;
						if (columns[1].equals(ESTIMATES))
							currentYear+= YEAR_START_VAL;
						else
							currentYear+= YEAR_START_VAL_PREDICT;
						PredictPopulation predict = new PredictPopulation();
						predict.methodName = columns[1];
						predict.populationNumber = Integer.parseInt(columns[i]);
						predict.predictYear = currentYear;
						country.predicts.get(type).add(predict);
					}
				}
				sc.close();
			}catch (Exception e){
				e.printStackTrace();
			}
		}
	}
	
	private void readGrowthRateData(String filename){
		final int COUNTRY_NAME_COL = 2;
		final int COUNTRY_CODE_COL = 4;
		final int YEAR_START_COL = 5;
		final int YEAR_START_VAL = 1950;
		final int YEAR_PERIOD = 5;
		try{
			Scanner sc = new Scanner(new File(filename));
			while (sc.hasNext()){
				String line = sc.nextLine();
				String[] columns = line.split(",");
				for (int i=0; i<columns.length; i++)
					columns[i] = normal(columns[i]);
				Country country = getCountry(columns[COUNTRY_NAME_COL]);
				if (country == null){
					country = new Country();
					country.countryName = columns[COUNTRY_NAME_COL];
					country.code = Integer.parseInt(columns[COUNTRY_CODE_COL]);
					if (country.code >= ACC_COUNTRY_CODE_START)
						continue;
					model.countryList.add(country);
				}
				for (int i=YEAR_START_COL; i<columns.length; i++){
					GrowthRate gr = new GrowthRate();
					gr.growth = Double.parseDouble(columns[i]);
					gr.startYear = YEAR_START_VAL + (i-YEAR_START_COL) * YEAR_PERIOD;
					gr.endYear = gr.startYear + YEAR_PERIOD;
					country.growths.add(gr);
				}
			}
			sc.close();
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public void createDataFile() {
		readPopulationsData("Data/male/", 0);
		readPopulationsData("Data/female/", 1);
		readGrowthRateData("Data/growth_estimates.csv");
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
        
        public List<Country> getCountryListSortedByName(){
            Collections.sort(model.countryList, new Comparator<Country>() {
                @Override
                public int compare(Country o1, Country o2) {
                    return o1.countryName.compareTo(o2.countryName);
                }
            });
            return model.countryList;
        }
        
        public DefaultComboBoxModel getCuntriesComboModel(){
            List<Country> countryList= ModelMgr.getInstance().getCountryListSortedByName();
            List<String> cuntryNameList = new ArrayList<>();
            for(Country country: countryList){
                cuntryNameList.add(country.countryName);
            }
            DefaultComboBoxModel dcm = new DefaultComboBoxModel(cuntryNameList.toArray());
            return dcm;
        }
        public DefaultComboBoxModel getYearsComboModelForGrowth() {
            List<Country> countryList= ModelMgr.getInstance().getCountryList();
            ArrayList<String> comboModel = new ArrayList<>();
            for(int i=0;i<countryList.get(0).growths.size();i++){
                comboModel.add(String.valueOf(countryList.get(0).growths.get(i).startYear));
            }
            DefaultComboBoxModel dcm = new DefaultComboBoxModel(comboModel.toArray());
            return dcm;
        }
        
        public DefaultComboBoxModel getYearsComboModelForPupulation() {
            List<Country> countryList= ModelMgr.getInstance().getCountryList();
            ArrayList<String> comboModel = new ArrayList<>();
            for(int i=1950;i<=2015;i++){
                comboModel.add(i + "");
            }
            DefaultComboBoxModel dcm = new DefaultComboBoxModel(comboModel.toArray());
            return dcm;
        }

	public Country getCountry(String countryName){
		for (Country country : model.countryList) {
			if(country.countryName.equals(countryName))
				return country;
		}
		return null;
	}
        
        public List<String> getMethodList (){
            if (model.countryList.isEmpty())
                return null;
            Country country = model.countryList.get(0);
            Set<String> temp = new TreeSet<>();
            for (PredictPopulation predict: country.predicts.get(0))
                temp.add(predict.methodName);
            List<String> ret = new ArrayList<>(temp);
            return ret;
        }

}
