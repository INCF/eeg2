package cz.zcu.kiv.eegdatabase.data.pojo;
// Generated 19.1.2010 23:18:53 by Hibernate Tools 3.2.1.GA

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * ResearchGroup generated by hbm2java
 */
@Entity
@javax.persistence.Table(name="RESEARCH_GROUP")
public class ResearchGroup implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "RESEARCH_GROUP_ID")
    private int researchGroupId;
    @ManyToOne
    @JoinColumn(name = "OWNER_ID")
    private Person person;
    @Column(name = "TITLE")
    private String title;
    @Column(name = "DESCRIPTION")
    private String description;
    @OneToMany(mappedBy = "researchGroup")
    private Set<ResearchGroupMembership> researchGroupMemberships = new HashSet<ResearchGroupMembership>(0);
    @OneToMany(mappedBy = "researchGroup")
    private Set<Scenario> scenarios = new HashSet<Scenario>(0);
    @OneToMany(mappedBy = "researchGroup")
    private Set<Experiment> experiments = new HashSet<Experiment>(0);
    @OneToMany(mappedBy = "defaultGroup")
    private Set<Person> usersWithThisAsDefault = new HashSet<Person>(0);
    @OneToMany(mappedBy = "researchGroup")
    private Set<GroupPermissionRequest> requests = new HashSet<GroupPermissionRequest>(0);
    @ManyToMany(mappedBy = "articlesGroupSubscribtions")
    private Set<Person> articlesSubscribers = new HashSet<Person>(0);
    @OneToMany(mappedBy = "researchGroup")
    private Set<HardwareGroupRel> hardwareGroupRels = new HashSet<HardwareGroupRel>(0);
    @OneToMany(mappedBy = "researchGroup")
    private Set<WeatherGroupRel> weatherGroupRels = new HashSet<WeatherGroupRel>(0);
    @ManyToMany(mappedBy = "researchGroups")
    private Set<Hardware> hardwares = new HashSet<Hardware>(0);
    @ManyToMany(mappedBy = "researchGroups")
    private Set<Weather> weathers = new HashSet<Weather>(0);
    @ManyToMany(mappedBy = "researchGroups")
    private Set<FileMetadataParamDef> fileMetadataParamDefs = new HashSet<FileMetadataParamDef>(0);
    @OneToMany(mappedBy = "researchGroup")
    private Set<FileMetadataParamDefGroupRel> fileMetadataParamDefGroupRels = new HashSet<FileMetadataParamDefGroupRel>(0);
    @ManyToMany(mappedBy = "researchGroups")
    private Set<PersonOptParamDef> personOptParamDefs = new HashSet<PersonOptParamDef>(0);
    @OneToMany(mappedBy = "researchGroup")
    private Set<PersonOptParamDefGroupRel> personOptParamDefGroupRels = new HashSet<PersonOptParamDefGroupRel>(0);
    @ManyToMany(mappedBy = "researchGroups")
    private Set<ExperimentOptParamDef> experimentOptParamDefs = new HashSet<ExperimentOptParamDef>(0);
    @OneToMany(mappedBy = "researchGroup")
    private Set<ExperimentOptParamDefGroupRel> experimentOptParamDefGroupRels = new HashSet<ExperimentOptParamDefGroupRel>(0);
    private Set<Analysis> analysises = new HashSet<Analysis>(0);
    private Set<Artifact> artifacts = new HashSet<Artifact>(0);
    private Set<ArtifactRemoveMethod> artifactRemoveMethods = new HashSet<ArtifactRemoveMethod>(0);
    private Set<Digitization> digitizations = new HashSet<Digitization>(0);
    private Set<Disease> diseases = new HashSet<Disease>(0);
    private Set<EducationLevel> educationLevels = new HashSet<EducationLevel>(0);
    private Set<ElectrodeFix> electrodeFixes = new HashSet<ElectrodeFix>(0);
    private Set<ElectrodeLocation> electrodeLocations = new HashSet<ElectrodeLocation>(0);
    private Set<ElectrodeSystem> electrodeSystems = new HashSet<ElectrodeSystem>(0);
    private Set<ElectrodeType> electrodeTypes = new HashSet<ElectrodeType>(0);
    private Set<Pharmaceutical> pharmaceuticals = new HashSet<Pharmaceutical>(0);
    private Set<ProjectType> projectTypes = new HashSet<ProjectType>(0);
    private Set<Software> softwares = new HashSet<Software>(0);
    private Set<StimulusType> stimulusTypes = new HashSet<StimulusType>(0);
    @Column(name = "ORA_ROWSCN", insertable = false, updatable = false)
    private long scn;

    public ResearchGroup() {
    }

    public ResearchGroup(int researchGroupId, Person person, String title, String description) {
        this.researchGroupId = researchGroupId;
        this.person = person;
        this.title = title;
        this.description = description;
    }

    public ResearchGroup(int researchGroupId, Person person, String title, String description, Set<ResearchGroupMembership> researchGroupMemberships, Set<Scenario> scenarios, Set<Experiment> experiments, Set<Hardware> hardwares) {
        this.researchGroupId = researchGroupId;
        this.person = person;
        this.title = title;
        this.description = description;
        this.researchGroupMemberships = researchGroupMemberships;
        this.scenarios = scenarios;
        this.experiments = experiments;
        this.hardwares = hardwares;
    }

    public int getResearchGroupId() {
        return this.researchGroupId;
    }

    public void setResearchGroupId(int researchGroupId) {
        this.researchGroupId = researchGroupId;
    }

    public Person getPerson() {
        return this.person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return this.description;
    }

    public long getScn() {
        return scn;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<ResearchGroupMembership> getResearchGroupMemberships() {
        return this.researchGroupMemberships;
    }

    public void setResearchGroupMemberships(Set<ResearchGroupMembership> researchGroupMemberships) {
        this.researchGroupMemberships = researchGroupMemberships;
    }

    public Set<Scenario> getScenarios() {
        return this.scenarios;
    }

    public void setScenarios(Set<Scenario> scenarios) {
        this.scenarios = scenarios;
    }

    public Set<Experiment> getExperiments() {
        return this.experiments;
    }

    public void setExperiments(Set<Experiment> experiments) {
        this.experiments = experiments;
    }

    public Set<Person> getUsersWithThisAsDefault() {
        return usersWithThisAsDefault;
    }

    public void setUsersWithThisAsDefault(Set<Person> usersWithThisAsDefault) {
        this.usersWithThisAsDefault = usersWithThisAsDefault;
    }

    public Set<GroupPermissionRequest> getRequests() {
        return requests;
    }

    public void setRequests(Set<GroupPermissionRequest> requests) {
        this.requests = requests;
    }

    public Set<Person> getArticlesSubscribers() {
        return articlesSubscribers;
    }

    public Set<HardwareGroupRel> getHardwareGroupRels() {
        return hardwareGroupRels;
    }

    public void setHardwareGroupRels(Set<HardwareGroupRel> hardwareGroupRels) {
        this.hardwareGroupRels = hardwareGroupRels;
    }

    public Set<WeatherGroupRel> getWeatherGroupRels() {
        return weatherGroupRels;
    }

    public void setWeatherGroupRels(Set<WeatherGroupRel> weatherGroupRels) {
        this.weatherGroupRels = weatherGroupRels;
    }

    public void setArticlesSubscribers(Set<Person> articlesSubscribers) {
        this.articlesSubscribers = articlesSubscribers;
    }

    public Set<Hardware> getHardwares() {
        return this.hardwares;
    }

    public void setHardwares(Set<Hardware> hardwares) {
        this.hardwares = hardwares;
    }

    public Set<Weather> getWeathers() {
        return weathers;
    }

    public void setWeathers(Set<Weather> weathers) {
        this.weathers = weathers;
    }


    public Set<FileMetadataParamDef> getFileMetadataParamDefs() {
        return fileMetadataParamDefs;
    }

    public void setFileMetadataParamDefs(Set<FileMetadataParamDef> fileMetadataParamDefs) {
        this.fileMetadataParamDefs = fileMetadataParamDefs;
    }

    public Set<FileMetadataParamDefGroupRel> getFileMetadataParamDefGroupRels() {
        return fileMetadataParamDefGroupRels;
    }

    public void setFileMetadataParamDefGroupRels(Set<FileMetadataParamDefGroupRel> fileMetadataParamDefGroupRels) {
        this.fileMetadataParamDefGroupRels = fileMetadataParamDefGroupRels;
    }

    public Set<PersonOptParamDef> getPersonOptParamDefs() {
        return personOptParamDefs;
    }

    public void setPersonOptParamDefs(Set<PersonOptParamDef> personOptParamDefs) {
        this.personOptParamDefs = personOptParamDefs;
    }

    public Set<PersonOptParamDefGroupRel> getPersonOptParamDefGroupRels() {
        return personOptParamDefGroupRels;
    }

    public void setPersonOptParamDefGroupRels(Set<PersonOptParamDefGroupRel> personOptParamDefGroupRels) {
        this.personOptParamDefGroupRels = personOptParamDefGroupRels;
    }

    public Set<ExperimentOptParamDef> getExperimentOptParamDefs() {
        return experimentOptParamDefs;
    }

    public void setExperimentOptParamDefs(Set<ExperimentOptParamDef> experimentOptParamDefs) {
        this.experimentOptParamDefs = experimentOptParamDefs;
    }

    public Set<ExperimentOptParamDefGroupRel> getExperimentOptParamDefGroupRels() {
        return experimentOptParamDefGroupRels;
    }

    public void setExperimentOptParamDefGroupRels(Set<ExperimentOptParamDefGroupRel> experimentOptParamDefGroupRels) {
        this.experimentOptParamDefGroupRels = experimentOptParamDefGroupRels;
    }

    public Set<Analysis> getAnalysises() {
        return analysises;
    }

    public void setAnalysises(Set<Analysis> analysises) {
        this.analysises = analysises;
    }

    public Set<Artifact> getArtifacts() {
        return artifacts;
    }

    public void setArtifacts(Set<Artifact> artifacts) {
        this.artifacts = artifacts;
    }

    public Set<ArtifactRemoveMethod> getArtifactRemoveMethods() {
        return artifactRemoveMethods;
    }

    public void setArtifactRemoveMethods(Set<ArtifactRemoveMethod> artifactRemoveMethods) {
        this.artifactRemoveMethods = artifactRemoveMethods;
    }

    public Set<Digitization> getDigitizations() {
        return digitizations;
    }

    public void setDigitizations(Set<Digitization> digitizations) {
        this.digitizations = digitizations;
    }

    public Set<Disease> getDiseases() {
        return diseases;
    }

    public void setDiseases(Set<Disease> diseases) {
        this.diseases = diseases;
    }

    public Set<EducationLevel> getEducationLevels() {
        return educationLevels;
    }

    public void setEducationLevels(Set<EducationLevel> educationLevels) {
        this.educationLevels = educationLevels;
    }

    public Set<ElectrodeFix> getElectrodeFixes() {
        return electrodeFixes;
    }

    public void setElectrodeFixes(Set<ElectrodeFix> electrodeFixes) {
        this.electrodeFixes = electrodeFixes;
    }

    public Set<ElectrodeLocation> getElectrodeLocations() {
        return electrodeLocations;
    }

    public void setElectrodeLocations(Set<ElectrodeLocation> electrodeLocations) {
        this.electrodeLocations = electrodeLocations;
    }

    public Set<ElectrodeSystem> getElectrodeSystems() {
        return electrodeSystems;
    }

    public void setElectrodeSystems(Set<ElectrodeSystem> electrodeSystems) {
        this.electrodeSystems = electrodeSystems;
    }

    public Set<ElectrodeType> getElectrodeTypes() {
        return electrodeTypes;
    }

    public void setElectrodeTypes(Set<ElectrodeType> electrodeTypes) {
        this.electrodeTypes = electrodeTypes;
    }

    public Set<Pharmaceutical> getPharmaceuticals() {
        return pharmaceuticals;
    }

    public void setPharmaceuticals(Set<Pharmaceutical> pharmaceuticals) {
        this.pharmaceuticals = pharmaceuticals;
    }

    public Set<ProjectType> getProjectTypes() {
        return projectTypes;
    }

    public void setProjectTypes(Set<ProjectType> projectTypes) {
        this.projectTypes = projectTypes;
    }

    public Set<Software> getSoftwares() {
        return softwares;
    }

    public void setSoftwares(Set<Software> softwares) {
        this.softwares = softwares;
    }

    public Set<StimulusType> getStimulusTypes() {
        return stimulusTypes;
    }

    public void setStimulusTypes(Set<StimulusType> stimulusTypes) {
        this.stimulusTypes = stimulusTypes;
    }
}


