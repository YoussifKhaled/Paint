package dev.PainterApplication.Painter.Service;


import com.fasterxml.jackson.core.type.TypeReference;
import dev.PainterApplication.Painter.Model.Shape;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import dev.PainterApplication.Painter.Model.ShapeRequest;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
@Component
public class DataBase {
    private String filePath;
    private ObjectMapper json;
    private XmlMapper xml;
    private ShapeService shapeService=new ShapeService();
    private static DataBase dataBase;
    private DataBase(){
        xml = new XmlMapper();
        json = new ObjectMapper();
    }
    public static DataBase getInstance() {
        if(dataBase == null)
            dataBase = new DataBase();
        return dataBase;
    }
    public void setFilePath(String filePath) {                                      //Setting the path of the file to which design is either saved or loaded
        filePath = filePath.replaceAll("\\\\","\\\\\\\\");          //Modifying the path to be accessible
        filePath=filePath.replaceAll("\"","");
        this.filePath = filePath;
    }
    private void JsonSave() throws IOException {                            //(utility function) Saving in JSON file
        json.writeValue(new File(filePath), shapeService.getShapes());
    }
    private void xmlSave() throws IOException {                              //(utility function) Saving in XML file
        xml.writeValue(new File(filePath), shapeService.getShapes());
    }
    private ArrayList<ShapeRequest> loadXml()throws IOException{            //(utility function) Loading XML file
        return xml.readValue(new File(filePath), new TypeReference<>(){});
    }
    private ArrayList<ShapeRequest> loadJson()throws IOException{           //(utility function) Loading JSON file
        return json.readValue(new File(filePath), new TypeReference<>(){});
    }
    public void SaveDataBase(String type) throws IOException {              //Function checks type of the file to be saved and save using the matched utility function
        switch (type){
            case "json":
                JsonSave();
                 break;
            case "xml":
                xmlSave();
                 break;
        }
    }
    public  ArrayList<ShapeRequest> loadDataBase(String type) throws IOException {//Function checks type of the file to be loaded and load using the matched utility function
        return switch (type) {
            case "json" -> loadJson();
            case "xml" -> loadXml();
            default -> null;
        };
    }
}