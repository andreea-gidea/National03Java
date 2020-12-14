package andreea.tema3;

public class ArtAlbum extends Book {
    private String paperQuality;

    public ArtAlbum(String name, int numberOfPages, String paperQuality) {
        super(name, numberOfPages);
        this.paperQuality = paperQuality;
    }

    public ArtAlbum(String name, int numberOfPages) {
        super(name, numberOfPages);
    }

    public String getPaperQuality() {
        return paperQuality;
    }

    public void setPaperQuality(String paperQuality) {
        this.paperQuality = paperQuality;
    }

    @Override
    public String toString() {
        return " ArtAlbum{" +
                "name='" + getName() + '\'' +
                "numberOfPages='" + getNumberOfPages() + '\'' +
                "paperQuality='" + paperQuality + '\'' +
                '}';
    }
}
