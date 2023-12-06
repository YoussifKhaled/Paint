package com.example.paint.service;

import com.example.paint.model.Shape;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
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
    public void setFilePath(String filePath) {
        filePath = filePath.replaceAll("\\\\","\\\\\\\\");
        filePath=filePath.replaceAll("\"","");
        this.filePath = filePath;
    }
    public void JsonSave() throws IOException {
        json.writeValue(new File(filePath), shapeService.getShapes());
    }
    public void xmlSave() throws IOException {
        xml.writeValue(new File(filePath), shapeService.getShapes());
    }
    private ArrayList<Shape> loadXml()throws IOException{
        return xml.readValue(new File(filePath), ArrayList.class);
    }
    private ArrayList<Shape> loadJson()throws IOException{
        return json.readValue(new File(filePath), ArrayList.class);
    }
    public void SaveDataBase(String type) throws IOException {
        switch (type){
            case "json":
                JsonSave();
                 break;
            case "xml": xmlSave();
                 break;
        }
    }
    public  ArrayList<Shape> loadDataBase(String type) throws IOException {
        return switch (type) {
            case "json" -> loadJson();
            case "xml" -> loadXml();
            default -> shapeService.getShapes();
        };

    }
}
