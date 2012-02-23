package cz.zcu.kiv.eegdatabase.data.pojo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: stebjan
 * Date: 8.2.12
 * Time: 13:36
 * To change this template use File | Settings | File Templates.
 */
public class Disease implements Serializable{

    private int diseaseId;
    private String name;
    private String description;
    private Set<Experiment> experiments = new HashSet<Experiment>(0);

    public Disease() {
    }

    public Disease(int diseaseId, String name, String description) {
        this.diseaseId = diseaseId;
        this.name = name;
        this.description = description;
    }

    public int getDiseaseId() {
        return diseaseId;
    }

    public void setDiseaseId(int diseaseId) {
        this.diseaseId = diseaseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Experiment> getExperiments() {
        return experiments;
    }

    public void setExperiments(Set<Experiment> experiments) {
        this.experiments = experiments;
    }
}
