private String id;
private String description;
private List<String> possibleOutcomes;
private Map<String, Integer> consequences;
    
    public StoryEvent() {}
    
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    
    public List<String> getPossibleOutcomes() { return possibleOutcomes; }
    public void setPossibleOutcomes(List<String> possibleOutcomes) { this.possibleOutcomes = possibleOutcomes; }
    
    public Map<String, Integer> getConsequences() { return consequences; }
    public void setConsequences(Map<String, Integer> consequences) { this.consequences = consequences; }
