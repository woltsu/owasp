package owasp.domain;

public class News {

    private String content;
    
    public News(String content) {
        this.content = content;
    }
    
    public void setContent(String content) {
        this.content = content;
    }
    
    public String getContent() {
        return this.content;
    }

    @Override
    public String toString() {
        return this.content;
    }
    
}
