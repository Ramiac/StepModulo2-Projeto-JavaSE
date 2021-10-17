
import static control.servicos.DeletaDat.deletaDatOnExit;
import static view.Login.login;

public class Main {

    public static void main(String[] args) {

        login();

        deletaDatOnExit();
    }
}
