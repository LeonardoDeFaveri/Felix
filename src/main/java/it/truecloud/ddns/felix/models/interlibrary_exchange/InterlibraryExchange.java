package it.truecloud.ddns.felix.models.interlibrary_exchange;

import java.util.Objects;

import it.truecloud.ddns.felix.models.items.Item;
import it.truecloud.ddns.felix.models.location.Location;

public class InterlibraryExchange {
    private Item item;
    private String itemType;
    private Location sender, recepient;
    private Long exchangeDate;

    public InterlibraryExchange(Item item, String itemType, Location sender, Location recepient, Long exchangeDate) {
        this.item = item;
        this.itemType = itemType;
        this.sender = sender;
        this.recepient = recepient;
        this.exchangeDate = exchangeDate;
    }

    public InterlibraryExchange() {}

    public Item getItem() {
        return item;
    }

    public String getItemType() {
        return itemType;
    }

    public Location getSender() {
        return sender;
    }

    public Location getRecepient() {
        return recepient;
    }

    public Long getExchangeDate() {
        return exchangeDate;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public void setSender(Location sender) {
        this.sender = sender;
    }

    public void setRecepient(Location recepient) {
        this.recepient = recepient;
    }

    public void setExchangeDate(Long exchangeDate) {
        this.exchangeDate = exchangeDate;
    }

    @Override
    public int hashCode() {
        return Objects.hash(item, itemType, sender, recepient, exchangeDate);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;

        InterlibraryExchange interlibraryExchange = (InterlibraryExchange) obj;
        return (interlibraryExchange.item.equals(item) &&
            interlibraryExchange.itemType.equals(itemType) &&
            interlibraryExchange.sender.equals(sender) &&
            interlibraryExchange.recepient.equals(recepient) &&
            interlibraryExchange.exchangeDate == exchangeDate);
    }    
}