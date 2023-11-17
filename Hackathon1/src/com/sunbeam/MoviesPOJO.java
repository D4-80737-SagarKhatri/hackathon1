package com.sunbeam;

import java.util.Date;
import java.util.Objects;

public class MoviesPOJO {
    private int id;
    private String title;
    java.util.Date released ;
    public MoviesPOJO(){}
    public MoviesPOJO(int id, String title, Date released) {
        this.id = id;
        this.title = title;
        this.released = released;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MoviesPOJO that = (MoviesPOJO) o;
        return id == that.id && Objects.equals(title, that.title) && Objects.equals(released, that.released);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, released);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("MoviesPOJO{");
        sb.append("id=").append(id);
        sb.append(", title='").append(title).append('\'');
        sb.append(", released=").append(released);
        sb.append('}');
        return sb.toString();
    }
}
