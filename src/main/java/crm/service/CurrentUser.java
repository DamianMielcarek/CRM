package crm.service;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class CurrentUser extends User {

    private final long userID;

    public CurrentUser(String username, String password,
                       Collection<? extends GrantedAuthority> authorities, long userID) {
        super(username, password, authorities);
        this.userID = userID;
    }

    public long getUserID() {
        return userID;
    }

}
