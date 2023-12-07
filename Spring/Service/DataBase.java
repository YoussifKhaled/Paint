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
    public DataBase(){
        xml = new XmlMapper();
        json = new ObjectMapper();
    }
    public static DataBase getInstance() {
        if(dataBase == null)
            dataBase = new DataBase();
        return dataBase;
    }
    public void setFilePath(String filePath) {
        filePath = filePath.replaceAll("\\\\","\\\\\\\\");
        filePath=filePath.replaceAll("\"","");
        this.filePath = filePath;
    }
    private void JsonSave() throws IOException {
        json.writeValue(new File(filePath), shapeService.getShapes());
    }
    public void xmlSave() throws IOException {
        xml.writeValue(new File(filePath), shapeService.getShapes());
    }
    private ArrayList<ShapeRequest> loadXml()throws IOException{
        return xml.readValue(new File(filePath), new TypeReference<>(){});
    }
    private ArrayList<ShapeRequest> loadJson()throws IOException{
        return json.readValue(new File(filePath), new TypeReference<>(){});
    }
    public void SaveDataBase(String type) throws IOException {
        switch (type){
            case "json":
                JsonSave();
                 break;
            case "xml":
                xmlSave();
                 break;
        }
    }
    public  ArrayList<ShapeRequest> loadDataBase(String type) throws IOException {
        return switch (type) {
            case "json" -> loadJson();
            case "xml" -> loadXml();
            default -> null;
        };
    }
}