package it.truecloud.ddns.felix.models.interlibrary_exchange;

import java.util.Objects;

import it.truecloud.ddns.felix.models.location.Location;

public class InterlibraryExchange {
    private long itemId;
    private String itemType;
    private Location sender, recepient;
    private long exchangeDate;

    public InterlibraryExchange(long itemId, String itemType, Location sender, Location recepient, long exchangeDate) {
        this.itemId = itemId;
        this.itemType = itemType;
        this.sender = sender;
        this.recepient = recepient;
        this.exchangeDate = exchangeDate;
    }

    public long getItemId() {
        return itemId;
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

    public long getExchangeDate() {
        return exchangeDate;
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemId, itemType, sender, recepient, exchangeDate);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;

        InterlibraryExchange interlibraryExchange = (InterlibraryExchange) obj;
        return (interlibraryExchange.itemId == itemId &&
            interlibraryExchange.itemType.equals(itemType) &&
            interlibraryExchange.sender.equals(sender) &&
            interlibraryExchange.recepient.equals(recepient) &&
            interlibraryExchange.exchangeDate == exchangeDate);
    }    
}