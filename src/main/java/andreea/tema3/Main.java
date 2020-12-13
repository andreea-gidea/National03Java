package andreea.tema3;

public class Main {
    public static void main(String[] args) {
        LibraryCatalog librarie =new LibraryCatalog();
        Book novel1=new Novel("Marile Sperante", 200,"Clasic");
        Book novel2=new Novel("Cerneala", 200,"Young fiction");
        Book artAlbum1=new Novel("Foci", 20,"Medium Quality paper");
        Book artAlbum2=new Novel("Camile", 50,"Premium Quality paper");
        System.out.println("Lista goala  " + librarie.toString());

        librarie.addBook(novel1);
        librarie.addBook(novel2);
        librarie.addBook(artAlbum1);
        librarie.addBook(artAlbum2);
        System.out.println("Lista dupa adaugare  " + librarie.toString());

        //Book novelToBeDeleted=librarie.findByName("Cerneala");//imi aduc cartea pe care o vreau stearsa
        //librarie.deleteBook(novelToBeDeleted);//o sterg
       // System.out.println(novelToBeDeleted + "gdsfs");
        librarie.deleteByName("Cerneala");
        System.out.println("Lista dupa stergere  " + librarie.toString());

      //  Book artAlbumToBeDeleted=librarie.findByName("Foci");//imi aduc cartea pe care o vreau stearsa
        librarie.deleteByName("Foci");//o sterg
        System.out.println("Lista dupa alta stergere  " + librarie.toString());




    }
}
