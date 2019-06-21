package com.rota.kongresistem.model;

public class Items {

    private int id;
    private String clock;
    private String baskan;
    private String spekaer;

    public Items() {
        super();
    }

    public Items(int id, String clock, String baskan, String speaker) {
        super();
        this.id = id;
        this.clock = clock;
        this.baskan = baskan;
        this.spekaer = speaker;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClock() {
        return clock;
    }

    public void setClock(String clock) {
        this.clock = clock;
    }

    public String getBaskan() {
        return baskan;
    }

    public void setBaskan(String baskan) {
        this.baskan = baskan;
    }

    public String getSpekaer() {
        return spekaer;
    }

    public void setSpekaer(String spekaer) {
        this.spekaer = spekaer;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Items other = (Items) obj;
        if (id != other.id)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Product [id=" + id + ", clock=" + clock + ", baskan="
                + baskan + ", speaker=" + spekaer + "]";
    }
}
