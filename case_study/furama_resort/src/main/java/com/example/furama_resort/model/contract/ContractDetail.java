package com.example.furama_resort.model.contract;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ContractDetail {
    @Id
    private int id;
    private int quanlity;
    @ManyToOne
    @JoinColumn(name = "contract_id", referencedColumnName = "id")
    private Contract contract;
    @ManyToOne
    @JoinColumn(name = "attach_facility_id", referencedColumnName = "id")
    private AttachFacility attachFacility;

    public ContractDetail() {
    }

    public ContractDetail(int id, int quanlity, Contract contract, AttachFacility attachFacility) {
        this.id = id;
        this.quanlity = quanlity;
        this.contract = contract;
        this.attachFacility = attachFacility;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuanlity() {
        return quanlity;
    }

    public void setQuanlity(int quanlity) {
        this.quanlity = quanlity;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public AttachFacility getAttachFacility() {
        return attachFacility;
    }

    public void setAttachFacility(AttachFacility attachFacility) {
        this.attachFacility = attachFacility;
    }
}
