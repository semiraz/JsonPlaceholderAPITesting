package company;

public class Album {
    private String title;
    private int id;
    private int userId;

    public String getTitle() {
        return title;
    }

    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    Album(AlbumBuilder builder) {
        this.title = builder.title;
        this.id = builder.id;
        this.userId = builder.userId;
    }

    public static class AlbumBuilder{
        private String title;
        private int id;
        private int userId;

        public AlbumBuilder setTitle(String title) {
            this.title = title;
            return this;
        }

        public AlbumBuilder setId(int id) {
            this.id = id;
            return this;
        }

        public AlbumBuilder setUserId(int userId) {
            this.userId = userId;
            return this;
        }

        public Album build() {
            return new Album(this);
        }
    }

}
