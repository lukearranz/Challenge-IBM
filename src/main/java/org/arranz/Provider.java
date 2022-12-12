package org.arranz;

import java.util.Date;

public class Provider {

    private int providerId;
    private Date creationDateTime;
    private String name;
    private int clientId;

    public void setProviderId(int providerId) {
        this.providerId = providerId;
    }

    public void setCreationDateTime(Date creationDateTime) {
        this.creationDateTime = creationDateTime;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    @Override
    public String toString() {
        return  providerId +
                ", " + creationDateTime +
                ", " + name +
                ", " + clientId;
    }
}
