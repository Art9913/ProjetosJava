public class UserSession {

    private static User currentUser; // Atributo estático 

    public static User getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(User user) {
        UserSession.currentUser = user;
    }
}