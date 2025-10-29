private String name;
private String theme;
private String denizens;
private List<String> features;
    
    public Planet() {}
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public String getTheme() { return theme; }
    public void setTheme(String theme) { this.theme = theme; }
    
    public String getRuler() { return denizens; }
    public void setRuler(String denizens) { this.denizens = denizens; }
    
    public List<String> getFeatures() { return features; }
    public void setFeatures(List<String> features) { this.features = features; }
}