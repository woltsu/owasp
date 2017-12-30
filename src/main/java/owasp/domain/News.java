package owasp.domain;

public class News {

    private String content;
    private String publisher;
    
    public News(String content, String publisher) {
        this.content = content;
        this.publisher = publisher;
    }
    
    public void setContent(String content) {
        this.content = content;
    }
    
    public String getContent() {
        return this.content;
    }

    @Override
    public String toString() {
        return this.content + " ~" + this.publisher;
    }
    
}
