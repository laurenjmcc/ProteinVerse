package data_access;

import API.Protein_API;
import use_case.analyze.AnalyzeProteinDataAccessInterface;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;


public class ProteinDataAccessObject implements AnalyzeProteinDataAccessInterface {

    private final Protein_API protein_api;
    private final String description;
    public String getProtein_id;
    private ArrayList<String> acronym;
    private ArrayList<String> disease;
    private String proteinname;
    private Map<String, Set<String>> location;
    private final String accession;

    public static void main(String[] args) throws Exception {
        ProteinDataAccessObject protein = new ProteinDataAccessObject("p53");
        System.out.println(protein.description);
    }
    public ProteinDataAccessObject(String proteinID) throws Exception {
        this.protein_api = new Protein_API(proteinID);
        this.proteinname = protein_api.getProtein_name();
        this.accession = protein_api.getProtein_id();
        this.disease = protein_api.extractDisease();
        this.acronym = protein_api.acronyms();
        this.location = protein_api.location();
        this.description = protein_api.get_description();
    }

    @Override
    public String getProteinname() {return proteinname;}

    @Override
    public ArrayList<String> getDisease() {
        return disease;
    }

    @Override
    public ArrayList<String> getAcronym() {return acronym;
    }

    @Override
    public Map<String, Set<String>> getlocation() {return location;}

    @Override
    public String getProteinDescription() {return description;}


    @Override
    public boolean successCall(String proteinname) {
        return true;
    }

    public String getAccession() {
        return accession;
    }
}