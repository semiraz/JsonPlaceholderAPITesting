package company;

public class Photo {

    private String title;
    private String url;
    private String thumbnailUrl;
    private int id;

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    Photo(PhotoBuilder builder) {
        this.title = builder.title;
        this.url = builder.url;
        this.thumbnailUrl = builder.thumbnailUrl;
        this.id = builder.id;
    }

    public static class PhotoBuilder{
        private String title;
        private String url;
        private String thumbnailUrl;
        private int id;

        public PhotoBuilder setId(int id) {
            this.id = id;
            return this;
        }
        public PhotoBuilder setTitle(String title) {
            this.title = title;
            return this;
        }

        public PhotoBuilder setUrl(String url) {
            this.url = url;
            return this;
        }

        public PhotoBuilder setThumbnailUrl(String thumbnailUrl) {
            this.thumbnailUrl = thumbnailUrl;
            return this;
        }

        public Photo build() {
            return new Photo(this);
        }
    }
}
