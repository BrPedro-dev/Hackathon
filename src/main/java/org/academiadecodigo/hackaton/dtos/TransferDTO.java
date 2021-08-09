package org.academiadecodigo.hackaton.dtos;


import org.academiadecodigo.hackaton.models.User;
import org.academiadecodigo.hackaton.models.resources.Resource;

public class TransferDTO {

    private String resourceSrc;
    private String resourceDst;
    private Integer amount;

    public String getResourceSrc() {
        return resourceSrc;
    }

    public void setResourceSrc(String resourceSrc) {
        this.resourceSrc = resourceSrc;
    }

    public String getResourceDst() {
        return resourceDst;
    }

    public void setResourceDst(String resourceDst) {
        this.resourceDst = resourceDst;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

}
