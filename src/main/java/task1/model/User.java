package task1.model;

import javax.servlet.http.HttpSession;

public class User {

    public HttpSession getSession() {
        return session;
    }

    public void setSession(HttpSession session) {
        this.session = session;
    }

    private HttpSession session;

    public User(HttpSession session) {
        this.session = session;
    }
}
