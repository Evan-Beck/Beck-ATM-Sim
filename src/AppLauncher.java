import guis.LoginGui;
import javax.swing.SwingUtilities;
import guis.RegisterGui;
import guis.BankingAppGui;
import db_objs.User;
import java.math.BigDecimal;





public class AppLauncher {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @java.lang.Override
            public void run() {
            new LoginGui().setVisible(true);
      //           new RegisterGui().setVisible(true);
//                new BankingAppGui(
//                        new User(1, "username", "password", new BigDecimal("20.00"))
//                ).setVisible(true);
            }
    });
}
}
