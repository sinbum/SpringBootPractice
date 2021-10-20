package jpastudy.jpashop.domain.item;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("A")
public class Album extends Item {
    private String artist;
    private String etc;

    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    public String getArtist() {
        return this.artist;
    }

    @SuppressWarnings("all")
    public String getEtc() {
        return this.etc;
    }

    @SuppressWarnings("all")
    public void setArtist(final String artist) {
        this.artist = artist;
    }

    @SuppressWarnings("all")
    public void setEtc(final String etc) {
        this.etc = etc;
    }
    //</editor-fold>
}
