/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import java.sql.Date;

/**
 *
 * @author nicolaiharbo
 */
public class Campaign {

    int campaignId;
    int partnerId;
    Date startDate;
    Date stopDate;
    int budget;
    String status;

    public Campaign(int campaignId, int partnerId, Date startDate, Date stopDate, int budget, String status) {
        this.campaignId = campaignId;
        this.partnerId = partnerId;
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

    public int getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(int partnerId) {
        this.partnerId = partnerId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getStopDate() {
        return stopDate;
    }

    public void setStopDate(Date stopDate) {
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

    @Override
    public String toString() {
        return "Campaign{" + "campaignId=" + campaignId + ", partnerId=" + partnerId + ", startDate=" + startDate + ", stopDate=" + stopDate + ", budget=" + budget + ", status=" + status + '}';
    }

    
    
}
