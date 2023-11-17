package com.sunbeam;

import java.util.Date;
import java.util.Objects;

public class MoviesPOJO {
    private int id;
    private String title;
    java.util.Date releaseD ;
    public MoviesPOJO(){}
    public MoviesPOJO(int id, String title, Date released) {
        this.id = id;
        this.title = title;
        this.releaseD = releaseD;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MoviesPOJO that = (MoviesPOJO) o;
        return id == that.id && Objects.equals(title, that.title) && Objects.equals(releaseD, that.releaseD);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, releaseD);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("MoviesPOJO{");
        sb.append("id=").append(id);
        sb.append(", title='").append(title).append('\'');
        sb.append(", released=").append(releaseD);
        sb.append("}\n");
        return sb.toString();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getReleased() {
        return releaseD;
    }

    public void setReleased(Date releaseD) {
        this.releaseD = releaseD;
    }
}
