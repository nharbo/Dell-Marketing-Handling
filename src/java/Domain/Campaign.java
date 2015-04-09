/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

/**
 *
 * @author nicolaiharbo
 */
public class Campaign {
    
    int campaignId;
    int startDate;
    int stopDate;
    int budget;
    String status;

    public Campaign(int campaignId, int startDate, int stopDate, int budget, String status) {
        this.campaignId = campaignId;
        this.startDate = startDate;
        this.stopDate = stopDate;
        this.budget = budget;
        this.status = status;
    }
    

    public int getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(int campaignId) {
        this.campaignId = campaignId;
    }

    public int getStartDate() {
        return startDate;
    }

    public void setStartDate(int startDate) {
        this.startDate = startDate;
    }

    public int getStopDate() {
        return stopDate;
    }

    public void setStopDate(int stopDate) {
        this.stopDate = stopDate;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
    
}
