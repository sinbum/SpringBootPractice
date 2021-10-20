package jpastudy.jpashop.domain.item;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("C")
public class Movie extends Item {
    private String director;
    private String actor;

    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    public String getDirector() {
        return this.director;
    }

    @SuppressWarnings("all")
    public String getActor() {
        return this.actor;
    }

    @SuppressWarnings("all")
    public void setDirector(final String director) {
        this.director = director;
    }

    @SuppressWarnings("all")
    public void setActor(final String actor) {
        this.actor = actor;
    }
    //</editor-fold>
}
