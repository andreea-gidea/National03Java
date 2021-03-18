package andreea.tema3;

import org.junit.Test;


public class LibraryCatalogTest {

    @Test

    public void addBookTest (){
        LibraryCatalog libraryCatalog=new LibraryCatalog();
        libraryCatalog.addBook(new Novel("Marile Sperante", 200,"Clasic"));


    }

}
