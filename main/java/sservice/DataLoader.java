package com.main.java.sservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.*;

@Service
public class DataLoader {
    
    private List<String> humanNames;
    private List<String> humanLast;
    private List<String> trollNames;
    private List<Map<String, Object>> aspects;
    private List<Map<String, Object>> classes;
    private List<String> specibus;
    private List<String> chumHandlePrefixes;
    private List<String> chumHandleSuffixes;
    private List<String> landNouns;
    private List<String> denizens;
    
    private ObjectMapper objectMapper = new ObjectMapper();
    
    @PostConstruct

        Map<String, Object> namesData = loadJson("data/names.json");
        this.firstNames = (List<String>) namesData.get("humanNames");
        this.lastNames = (List<String>) namesData.get("humanLast");
        this.trollNames = (List<String>) namesData.get("trollNames");
        this.trollSur = (List<String>) namesData.get("trollNames");
        

        Map<String, Object> aspectsData = loadJson("data/aspects.json");
        this.aspects = (List<Map<String, Object>>) aspectsData.get("aspects");

        Map<String, Object> classesData = loadJson("data/classes.json");
        this.classes = (List<Map<String, Object>>) classesData.get("classes");

        Map<String, Object> strifesData = loadJson("data/strifes.json");
        this.strifes = (List<String>) strifesData.get("strifes");
        

        Map<String, Object> chumHandlesData = loadJson("data/chumhandles.json");
        this.chumHandlePrefixes = (List<String>) chumHandlesData.get("prefixes");
        this.chumHandleSuffixes = (List<String>) chumHandlesData.get("suffixes");
        
        Map<String, Object> landsData = loadJson("data/lands.json");
        this.landNouns = (List<String>) landsData.get("landNouns");
        this.denizens = (List<String>) landsData.get("denizens");
    }
    
    private Map<String, Object> loadJson(String path) throws IOException {
        ClassPathResource resource = new ClassPathResource(path);
        return objectMapper.readValue(resource.getInputStream(), Map.class);
    }
    

    public List<String> getHumanNames() { return humanNames; }
    public List<String> getHumanLast() { return humanLast; }
    public List<String> getTrollNames() { return trollNames; }
    public List<Map<String, Object>> getAspects() { return aspects; }
    public List<Map<String, Object>> getClasses() { return classes; }
    public List<String> getSpecibus() { return strifes; }
    public List<String> getChumHandlePrefixes() { return chumHandlePrefixes; }
    public List<String> getChumHandleSuffixes() { return chumHandleSuffixes; }
    public List<String> getLandNouns() { return landNouns; }
    public List<String> getDenizens() { return denizens; }
}