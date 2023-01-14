package company;

public class Book {
    private String title;
    private String body;
    private String userId;
    private String id;

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public String getUserId() {
        return userId;
    }

    Book(BookBuilder builder) {
        this.title = builder.title;
        this.body = builder.body;
        this.userId = builder.userId;
        this.id = builder.id;
    }

    public static class BookBuilder{
        private String title;
        private String body;
        private String userId;
        private String id;

        public BookBuilder setTitle(String title) {
            this.title = title;
            return this;
        }

        public BookBuilder setBody(String body) {
            this.body = body;
            return this;
        }

        public BookBuilder setUserId(String userId) {
            this.userId = userId;
            return this;
        }

        public BookBuilder setId(String id) {
            this.id = id;
            return this;
        }

        public Book build(){
            return new Book(this);
        }
    }

}