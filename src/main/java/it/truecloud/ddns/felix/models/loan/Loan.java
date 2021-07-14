package it.truecloud.ddns.felix.models.loan;

import java.util.Objects;

import it.truecloud.ddns.felix.models.Registered.Registered;
import it.truecloud.ddns.felix.models.location.Location;

public class Loan {
    private long itemId;
    private String itemType;
    private Location location;
    private Registered registered;
    private long pickUpDate, filingDate;
    
    public Loan(long itemId, String itemType, Location location, Registered registered, long pickUpDate,
            long filingDate) {
        this.itemId = itemId;
        this.itemType = itemType;
        this.location = location;
        this.registered = registered;
        this.pickUpDate = pickUpDate;
        this.filingDate = filingDate;
    }

    public long getItemId() {
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

    public long getPickUpDate() {
        return pickUpDate;
    }

    public long getFilingDate() {
        return filingDate;
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