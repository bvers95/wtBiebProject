package working.talent.bieb.Books;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class BookItem extends Book {

    @Column(nullable = false) // to prevent saving a null bookname
    private String bookname;

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }
}
