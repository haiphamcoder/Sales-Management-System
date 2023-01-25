package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Objects;

public class HomePanel extends JPanel {
    private final String[] image = {"image1.jpg", "image2.png", "image3.png", "image4.png"};
    private static int index = 0;

    // components
    private JLabel lblPrevious, lblNext;
    private JLabel lblImage;

    // constructor
    public HomePanel() {
        this.setLayout(new BorderLayout());
        this.setBackground(new Color(245, 245, 251));
        initComponents();
        addEvent();
    }

    private void initComponents() {
        // implementation the top panel
        JPanel pnTop = new JPanel();
        pnTop.setLayout(new BorderLayout());
        pnTop.setBackground(new Color(245, 245, 251));
        JLabel lblTitle = new JLabel("HỆ THỐNG QUẢN LÝ BÁN HÀNG");
        lblTitle.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 26));
        lblTitle.setForeground(new Color(78, 138, 211));
        lblTitle.setHorizontalAlignment(JLabel.CENTER);
        lblTitle.setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 0));
        pnTop.add(lblTitle, BorderLayout.CENTER);

        // implementation the left panel
        JPanel pnLeft = new JPanel();
        pnLeft.setLayout(new BorderLayout());
        pnLeft.setBackground(new Color(245, 245, 251));
        pnLeft.setPreferredSize(new Dimension(50, 0));
        lblPrevious = new JLabel("<");
        lblPrevious.setForeground(new Color(245, 245, 251));
        lblPrevious.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 24));
        lblPrevious.setHorizontalAlignment(JLabel.CENTER);
        pnLeft.add(lblPrevious, BorderLayout.CENTER);

        // implementation the right panel
        JPanel pnRight = new JPanel();
        pnRight.setLayout(new BorderLayout());
        pnRight.setBackground(new Color(245, 245, 251));
        pnRight.setPreferredSize(new Dimension(50, 0));
        lblNext = new JLabel(">");
        lblNext.setForeground(new Color(245, 245, 251));
        lblNext.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 24));
        lblNext.setHorizontalAlignment(JLabel.CENTER);
        pnRight.add(lblNext, BorderLayout.CENTER);

        // implementation the center panel
        JPanel pnCenter = new JPanel();
        pnCenter.setLayout(new BorderLayout());
        pnCenter.setBackground(new Color(245, 245, 251));
        lblImage = new JLabel();
        lblImage.setIcon(new ImageIcon(Objects.requireNonNull(this.getClass().getResource(
                "/Images/" + image[index]))));
        lblImage.setHorizontalAlignment(JLabel.CENTER);
        pnCenter.add(lblImage, BorderLayout.CENTER);

        this.add(pnTop, BorderLayout.NORTH);
        this.add(pnLeft, BorderLayout.WEST);
        this.add(pnRight, BorderLayout.EAST);
        this.add(pnCenter, BorderLayout.CENTER);
    }

    private void addEvent() {
        lblPrevious.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (index == 0) {
                    index = 3;
                } else {
                    index--;
                }
                lblImage.setIcon(new ImageIcon(Objects.requireNonNull(this.getClass().getResource(
                        "/Images/" + image[index]))));
                lblImage.updateUI();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                lblPrevious.setForeground(Color.LIGHT_GRAY);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                lblPrevious.setForeground(new Color(245, 245, 251));
            }
        });

        lblNext.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (index == 3) {
                    index = 0;
                } else {
                    index++;
                }
                lblImage.setIcon(new ImageIcon(Objects.requireNonNull(this.getClass().getResource(
                        "/Images/" + image[index]))));
                lblImage.updateUI();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                lblNext.setForeground(Color.LIGHT_GRAY);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                lblNext.setForeground(new Color(245, 245, 251));
            }
        });
    }

    // Test HomePanel

    public static void main(String[] args) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (UnsupportedLookAndFeelException | ClassNotFoundException |
                 InstantiationException |
                 IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        JFrame test = new JFrame();
        test.setSize(900, 600);
        test.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        test.setLocationRelativeTo(null);
        test.setExtendedState(JFrame.MAXIMIZED_BOTH);
        test.getContentPane().add(new HomePanel());
        test.setVisible(true);
    }
}
