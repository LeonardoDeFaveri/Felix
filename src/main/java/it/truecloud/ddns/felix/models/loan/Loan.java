package it.truecloud.ddns.felix.models.loan;

import java.util.Objects;

import it.truecloud.ddns.felix.models.Registered.Registered;
import it.truecloud.ddns.felix.models.items.Item;
import it.truecloud.ddns.felix.models.location.Location;

/**
 * The class represents a loan of either a book, Cd or DVD to
 * a registered user.
 */
public class Loan {
    private Item item;
    private String itemType;
    private Location location;
    private Registered registered;
    private Long pickUpDate, filingDate;
    
    public Loan(Item item, String itemType, Location location, Registered registered, Long pickUpDate,
            Long filingDate) {
        this.item = item;
        this.itemType = itemType;
        this.location = location;
        this.registered = registered;
        this.pickUpDate = pickUpDate;
        this.filingDate = filingDate;
    }

    public Loan() {}

    public Item getItem() {
        return item;
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

    public void setItem(Item item) {
        this.item = item;
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
        return Objects.hash(item, itemType, location, registered, pickUpDate);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        
        Loan loan = (Loan) obj;
        return (loan.item.equals(item) && loan.itemType.equals(itemType) &&
            loan.location.equals(location) && loan.registered.equals(registered) &&
            loan.pickUpDate == pickUpDate);
    }
}