import forms.FrmFather;
import helpers.Plotter;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        // Sample Usage of Plot

//        ArrayList<Double> xValues = new ArrayList<>();
//        xValues.add((double) 2000);
//        xValues.add((double) 2050);
//        xValues.add((double) 2100);
//
//        ArrayList<Double> yValues = new ArrayList<>();
//        yValues.add((double) 700.8);
//        yValues.add((double) 800);
//        yValues.add((double) 780);
//
//        Plotter.plot("Title", "Year", "Population", xValues, yValues, "./barchart.pdf" );

        new FrmFather().setVisible(true);
        
        Scanner sc = new Scanner(new File("input.txt"));

        ArrayList<String> countryName = new ArrayList<>();
        ArrayList<Double> growth = new ArrayList<>();


        ArrayList<Country> countries = new ArrayList<>();

        int yearsNo = 13;
        int firstYear = 1950;
        int dy = 5;

        // Read
        while( sc.hasNextLine() ){
            String line = sc.nextLine();
            String[] items = line.split("\t");
            Country country = new Country();
            country.name = items[0];
            for( int i = yearsNo-1; i >= 0; i-- ){
                country.growth.add( Double.parseDouble(items[items.length-i-1]) );
            }

            countries.add(country);
        }

        Scanner sc2 = new Scanner(System.in);

        while(true){

            for( int i = 0; i < yearsNo; i++){
                System.out.println( i + ") " + (firstYear + dy*i) + "-" +  (firstYear + dy*(i+1)) );
            }
            System.out.println("Choose year:");

            final int choose = sc2.nextInt();
            if( choose < 0 || choose >= yearsNo ){
                System.out.println("Invalid input! It should be between 0-" + (yearsNo-1) );
                continue;
            }

            Collections.sort(countries, new Comparator<Country>() {
                @Override
                public int compare(Country o1, Country o2) {
                    return o2.growth.get(choose).compareTo(o1.growth.get(choose));
                }
            });

            try {
                FileWriter fw = new FileWriter(new File("output.txt"));

                for( Country country : countries ){
                    System.out.println(country.name + " " + country.growth.get(choose) );
                    fw.write(country.name + " " + country.growth.get(choose) + "\n");

                }
                fw.flush();
                fw.close();

                writeToPDF(countries, choose);

            }catch(Exception e){

            }

            System.out.println("Press Enter...");
            sc2.nextLine();
            sc2.nextLine();
        }
    }
    public static void writeToPDF( ArrayList<Country> countries, int choose ){
        PDDocument doc = null;
        PDPage page = null;

        try{
            doc = new PDDocument();
            page = new PDPage();

            doc.addPage(page);
            doc.addPage(new PDPage());
            PDFont font = PDType1Font.HELVETICA_BOLD;

            PDPageContentStream content = new PDPageContentStream(doc, page);
            content.beginText();
            content.setFont(font, 8);
            content.moveTextPositionByAmount(100, 700);

            content.drawString("Growth rate for year " + (1950 + choose * 5) + "-" + (1955+choose*5) );
            content.moveTextPositionByAmount(0, -10);
            int i = 0;
            for( Country country: countries ) {
                content.moveTextPositionByAmount(0, -10);
                content.drawString(country.name + " " + country.growth.get(choose));
                i++;
            }

            content.endText();
            content.close();
            doc.save("PDFWithText.pdf");
            doc.close();
        } catch (Exception e){
            System.out.println(e);
        }
    }
}
