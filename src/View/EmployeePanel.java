package View;

import javax.swing.*;
import java.awt.*;

public class EmployeePanel extends JPanel {

    // constructor
    public EmployeePanel(){
        this.setLayout(new BorderLayout());
        this.setBackground(new Color(245,245,251));
        initComponents();
    }

    private void initComponents() {
        // implementation the top panel
        JPanel pnTop = new JPanel();
        pnTop.setLayout(new BorderLayout());
        pnTop.setBackground(new Color(245,245,251));
        JLabel lblTitle = new JLabel("QUẢN LÝ NHÂN VIÊN");
        lblTitle.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 26));
        lblTitle.setForeground(new Color(78,138,211));
        lblTitle.setHorizontalAlignment(JLabel.CENTER);
        lblTitle.setBorder(BorderFactory.createEmptyBorder(5,0,0,0));
        pnTop.add(lblTitle, BorderLayout.CENTER);

        this.add(pnTop, BorderLayout.NORTH);
    }

    // Test HomePanel
    private static class Test extends JFrame{
        public Test(){
            this.setSize(900,600);
            this.setDefaultCloseOperation(EXIT_ON_CLOSE);
            this.setLocationRelativeTo(null);
            this.setExtendedState(JFrame.MAXIMIZED_BOTH);
            this.getContentPane().add(new EmployeePanel());
            this.setVisible(true);
        }

        public static void main(String[] args) {
            try {
                for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                    if ("Nimbus".equals(info.getName())) {
                        UIManager.setLookAndFeel(info.getClassName());
                        break;
                    }
                }
            } catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException |
                     IllegalAccessException e) {
                throw new RuntimeException(e);
            }
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    new Test();
                }
            });
        }
    }
}
