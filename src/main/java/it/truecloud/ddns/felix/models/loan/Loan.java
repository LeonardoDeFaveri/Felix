package it.truecloud.ddns.felix.models.loan;

import java.util.Objects;

import it.truecloud.ddns.felix.models.Registered.Registered;
import it.truecloud.ddns.felix.models.location.Location;

public class Loan {
    private Long itemId;
    private String itemType;
    private Location location;
    private Registered registered;
    private Long pickUpDate, filingDate;
    
    public Loan(Long itemId, String itemType, Location location, Registered registered, Long pickUpDate,
            Long filingDate) {
        this.itemId = itemId;
        this.itemType = itemType;
        this.location = location;
        this.registered = registered;
        this.pickUpDate = pickUpDate;
        this.filingDate = filingDate;
    }

    public Loan() {}

    public Long getItemId() {
        return itemId;
    }

    public String getItemType() {
        return itemType;
    }

    public Location getLocation() {
        return location;
    }

    public Registered getRegistered() {
        return registered;
    }

    public Long getPickUpDate() {
        return pickUpDate;
    }

    public Long getFilingDate() {
        return filingDate;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setRegistered(Registered registered) {
        this.registered = registered;
    }

    public void setPickUpDate(Long pickUpDate) {
        this.pickUpDate = pickUpDate;
    }

    public void setFilingDate(Long filingDate) {
        this.filingDate = filingDate;
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemId, itemType, location, registered, pickUpDate);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        
        Loan loan = (Loan) obj;
        return (loan.itemId == itemId && loan.itemType.equals(itemType) &&
            loan.location.equals(location) && loan.registered.equals(registered) &&
            loan.pickUpDate == pickUpDate);
    }
}