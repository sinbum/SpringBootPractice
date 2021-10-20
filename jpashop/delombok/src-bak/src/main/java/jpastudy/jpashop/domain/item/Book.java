package jpastudy.jpashop.domain.item;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("B")
public class Book extends Item {
    private String author;
    private String isbn;

    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    public String getAuthor() {
        return this.author;
    }

    @SuppressWarnings("all")
    public String getIsbn() {
        return this.isbn;
    }

    @SuppressWarnings("all")
    public void setAuthor(final String author) {
        this.author = author;
    }

    @SuppressWarnings("all")
    public void setIsbn(final String isbn) {
        this.isbn = isbn;
    }
    //</editor-fold>
}
