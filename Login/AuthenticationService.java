public class AuthenticationService implements LoginService {
    private User currentUser;

    @Override
    public boolean login(String username, String password) {
        // Autenticação simples: usuário "denys" e senha "poo123456"
        if ("denys".equals(username) && "poo123456".equals(password)) {
            currentUser = new User(username);
            return true;
        }
        currentUser = null;
        return false;
    }

    @Override
    public User getCurrentUser() {
        return currentUser;
    }
}