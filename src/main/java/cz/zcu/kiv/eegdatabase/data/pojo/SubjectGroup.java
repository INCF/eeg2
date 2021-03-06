package cz.zcu.kiv.eegdatabase.data.pojo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: stebjan
 * Date: 8.2.12
 * Time: 13:30
 * To change this template use File | Settings | File Templates.
 */
@Entity
@javax.persistence.Table(name="SUBJECT_GROUP")
public class SubjectGroup implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "SUBJECT_GROUP_ID")
    private int subjectGroupId;
    @Column(name = "TITLE")
    private String title;
    @Column(name = "DESCRIPTION")
    private String description;
    @OneToMany(mappedBy = "subjectGroup")
    private Set<Experiment> experiments = new HashSet<Experiment>(0);

    public SubjectGroup() {
    }

    public SubjectGroup(int subjectGroupId, String description, String name) {
        this.subjectGroupId = subjectGroupId;
        this.description = description;
        this.title = name;
    }

    public int getSubjectGroupId() {
        return subjectGroupId;
    }

    public void setSubjectGroupId(int subjectGroupId) {
        this.subjectGroupId = subjectGroupId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
