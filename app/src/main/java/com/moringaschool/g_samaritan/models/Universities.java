
package com.moringaschool.g_samaritan.models; ;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Universities {

    @SerializedName("domains")
    @Expose
    private List<String> domains = null;
    @SerializedName("web_pages")
    @Expose
    private List<String> webPages = null;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("alpha_two_code")
    @Expose
    private String alphaTwoCode;
    @SerializedName("state-province")
    @Expose
    private Object stateProvince;
    @SerializedName("country")
    @Expose
    private String country;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Universities() {
    }

    /**
     * 
     * @param webPages
     * @param country
     * @param name
     * @param domains
     * @param stateProvince
     * @param alphaTwoCode
     */
    public Universities(List<String> domains, List<String> webPages, String name, String alphaTwoCode, Object stateProvince, String country) {
        super();
        this.domains = domains;
        this.webPages = webPages;
        this.name = name;
        this.alphaTwoCode = alphaTwoCode;
        this.stateProvince = stateProvince;
        this.country = country;
    }

    public List<String> getDomains() {
        return domains;
    }

    public void setDomains(List<String> domains) {
        this.domains = domains;
    }

    public List<String> getWebPages() {
        return webPages;
    }

    public void setWebPages(List<String> webPages) {
        this.webPages = webPages;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlphaTwoCode() {
        return alphaTwoCode;
    }

    public void setAlphaTwoCode(String alphaTwoCode) {
        this.alphaTwoCode = alphaTwoCode;
    }

    public Object getStateProvince() {
        return stateProvince;
    }

    public void setStateProvince(Object stateProvince) {
        this.stateProvince = stateProvince;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

}
