package View;

import Controller.LoginController;
import Model.LoginModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Objects;

public class LoginView extends JFrame {
    // attributes
    private int mouseX;
    private int mouseY;
    private final Color colorBackground = new Color(25, 118, 211);

    // components
    private JPanel pnMain;
    private JLabel lblBtnClose;
    private JTextField txtUsername;
    private JPasswordField txtPassword;

    private JCheckBox chkShowPassword;
    private JButton btnLogin;

    // constructor
    public LoginView() {
        super();
        initComponents();
        addEvents();
        showWindow();
    }

    private void initComponents() {
        // implementation the left panel
        JPanel pnLeft = new JPanel();
        pnLeft.setLayout(new BoxLayout(pnLeft, BoxLayout.Y_AXIS));
        pnLeft.setBackground(Color.WHITE);
        pnLeft.setPreferredSize(new Dimension(450, 0));

        JLabel lblTitle = new JLabel("HỆ THỐNG QUẢN LÝ BÁN HÀNG");
        lblTitle.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 26));
        lblTitle.setForeground(colorBackground);
        JPanel pnLblLogo = new JPanel();
        pnLblLogo.setLayout(new FlowLayout(FlowLayout.CENTER));
        pnLblLogo.setBackground(Color.WHITE);
        pnLblLogo.add(lblTitle);

        JLabel lblImage = new JLabel();
        lblImage.setIcon(new ImageIcon(Objects.requireNonNull(this.getClass().getResource(
                "/Images/bg-login.png"))));
        JPanel pnLblImage = new JPanel();
        pnLblImage.setLayout(new FlowLayout(FlowLayout.CENTER));
        pnLblImage.setBackground(Color.WHITE);
        pnLblImage.add(lblImage);

        JLabel lblDevInfo = new JLabel("Created by Haiqqez");
        lblDevInfo.setFont(new Font(Font.SANS_SERIF, Font.BOLD | Font.ITALIC, 15));
        lblDevInfo.setForeground(colorBackground);
        JPanel pnLblDevInfo = new JPanel();
        pnLblDevInfo.setLayout(new FlowLayout(FlowLayout.CENTER));
        pnLblDevInfo.setBackground(Color.WHITE);
        pnLblDevInfo.add(lblDevInfo);

        pnLeft.add(Box.createVerticalGlue());
        pnLeft.add(pnLblLogo);
        pnLeft.add(pnLblImage);
        pnLeft.add(pnLblDevInfo);
        pnLeft.add(Box.createVerticalGlue());

        // implementation the right panel
        JPanel pnRight = new JPanel();
        pnRight.setLayout(new BorderLayout());
        pnRight.setBackground(colorBackground);

        lblBtnClose = new JLabel();
        lblBtnClose.setIcon(new ImageIcon(Objects.requireNonNull(this.getClass().getResource(
                "/Images/ic_close_24px.png"))));
        lblBtnClose.setBorder(BorderFactory.createLineBorder(colorBackground, 2));
        JPanel pnTopRight = new JPanel();
        pnTopRight.setLayout(new FlowLayout(FlowLayout.RIGHT));
        pnTopRight.setBackground(colorBackground);
        pnTopRight.add(lblBtnClose);

        JLabel lblLogin = new JLabel("Đăng nhập");
        lblLogin.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 34));
        lblLogin.setForeground(Color.WHITE);
        JPanel pnLblLogin = new JPanel();
        pnLblLogin.setLayout(new FlowLayout(FlowLayout.CENTER));
        pnLblLogin.setBackground(colorBackground);
        pnLblLogin.add(lblLogin);

        JLabel lblUsername = new JLabel("Tên đăng nhập: ");
        lblUsername.setFont(new Font(Font.SANS_SERIF, Font.ITALIC, 16));
        lblUsername.setForeground(new Color(119, 226, 255));
        lblUsername.setBorder(BorderFactory.createEmptyBorder(0, 30, 0, 0));
        JPanel pnLblUsername = new JPanel();
        pnLblUsername.setLayout(new FlowLayout(FlowLayout.LEFT));
        pnLblUsername.setBackground(colorBackground);
        pnLblUsername.add(lblUsername);

        txtUsername = new JTextField(18);
        txtUsername.setForeground(Color.BLACK);
        txtUsername.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 15));
        txtUsername.setBackground(Color.WHITE);
        JLabel lblIconUsername = new JLabel();
        lblIconUsername.setIcon(new ImageIcon(Objects.requireNonNull(this.getClass().getResource(
                "/Images/user.png"))));
        lblIconUsername.setBorder(BorderFactory.createEmptyBorder(0, 30, 0, 0));
        lblIconUsername.setBackground(colorBackground);
        JPanel pnTxtUsername = new JPanel();
        pnTxtUsername.setLayout(new FlowLayout(FlowLayout.LEFT));
        pnTxtUsername.setBackground(colorBackground);
        pnTxtUsername.add(lblIconUsername);
        pnTxtUsername.add(txtUsername);

        JLabel lblPassword = new JLabel("Mật khẩu: ");
        lblPassword.setFont(new Font(Font.SANS_SERIF, Font.ITALIC, 16));
        lblPassword.setForeground(new Color(119, 226, 255));
        lblPassword.setBorder(BorderFactory.createEmptyBorder(0, 30, 0, 0));
        JPanel pnLblPassword = new JPanel();
        pnLblPassword.setLayout(new FlowLayout(FlowLayout.LEFT));
        pnLblPassword.setBackground(colorBackground);
        pnLblPassword.add(lblPassword);

        txtPassword = new JPasswordField(18);
        txtPassword.setForeground(Color.BLACK);
        txtPassword.setBackground(Color.WHITE);
        txtPassword.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 15));
        txtPassword.setEchoChar('\u25cf');
        JLabel lblIconPassword = new JLabel();
        lblIconPassword.setIcon(new ImageIcon(Objects.requireNonNull(this.getClass().getResource(
                "/Images/password.png"))));
        lblIconPassword.setBorder(BorderFactory.createEmptyBorder(0, 30, 0, 0));
        lblIconPassword.setBackground(colorBackground);
        JPanel pnTxtPassword = new JPanel();
        pnTxtPassword.setLayout(new FlowLayout(FlowLayout.LEFT));
        pnTxtPassword.setBackground(colorBackground);
        pnTxtPassword.add(lblIconPassword);
        pnTxtPassword.add(txtPassword);

        chkShowPassword = new JCheckBox();
        chkShowPassword.setText("Hiển thị mật khẩu");
        chkShowPassword.setSelected(false);
        chkShowPassword.setBackground(colorBackground);
        chkShowPassword.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 15));
        chkShowPassword.setForeground(Color.WHITE);
        chkShowPassword.setBorder(BorderFactory.createEmptyBorder(0, 30, 0, 0));
        JPanel pnChkShowPassword = new JPanel();
        pnChkShowPassword.setLayout(new FlowLayout(FlowLayout.LEFT));
        pnChkShowPassword.setBackground(colorBackground);
        pnChkShowPassword.add(chkShowPassword);

        btnLogin = new JButton("Đăng nhập");
        btnLogin.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 14));
        btnLogin.setForeground(colorBackground);
        JPanel pnBtnLogin = new JPanel();
        pnBtnLogin.setLayout(new FlowLayout(FlowLayout.RIGHT));
        pnBtnLogin.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 35));
        pnBtnLogin.setBackground(colorBackground);
        pnBtnLogin.add(btnLogin);

        JPanel pnInforLogin = new JPanel();
        pnInforLogin.setLayout(new BoxLayout(pnInforLogin, BoxLayout.Y_AXIS));
        pnInforLogin.setBackground(colorBackground);
        pnInforLogin.add(Box.createVerticalGlue());
        pnInforLogin.add(pnLblLogin);
        pnInforLogin.add(pnLblUsername);
        pnInforLogin.add(pnTxtUsername);
        pnInforLogin.add(pnLblPassword);
        pnInforLogin.add(pnTxtPassword);
        pnInforLogin.add(pnChkShowPassword);
        pnInforLogin.add(pnBtnLogin);
        pnInforLogin.add(Box.createVerticalGlue());

        pnRight.add(pnTopRight, BorderLayout.NORTH);
        pnRight.add(pnInforLogin, BorderLayout.CENTER);

        // implementation the main panel
        pnMain = new JPanel();
        pnMain.setLayout(new BorderLayout());
        pnMain.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createRaisedBevelBorder(),
                BorderFactory.createLineBorder(new Color(240, 240, 240), 10)));
        pnMain.setBackground(Color.WHITE);
        pnMain.add(pnLeft, BorderLayout.WEST);
        pnMain.add(pnRight, BorderLayout.CENTER);

        // Add main panel to the content pane
        Container con = this.getContentPane();
        con.setLayout(new BorderLayout());
        con.add(pnMain, BorderLayout.CENTER);
    }

    private void addEvents() {
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent event) {
                for (double i = 0.0; i <= 1.0; i = i + 0.1) {
                    LoginView.this.setOpacity((float) i);
                    try {
                        Thread.sleep(25);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        pnMain.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                mouseX = e.getX();
                mouseY = e.getY();
            }
        });

        pnMain.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent event) {
                setLocation(LoginView.this.getX() + event.getX() - mouseX,
                        LoginView.this.getY() + event.getY() - mouseY);
            }
        });

        lblBtnClose.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                lblBtnClose.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 2));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                lblBtnClose.setBorder(BorderFactory.createLineBorder(colorBackground, 2));
            }
        });

        chkShowPassword.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                txtPassword.setEchoChar((char) 0);
            } else {
                txtPassword.setEchoChar('\u25cf');
            }
        });

        btnLogin.addActionListener(e -> Login());

        btnLogin.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    Login();
                }
            }
        });
    }

    public LoginModel getUser() {
        return new LoginModel(txtUsername.getText(), String.valueOf(txtPassword.getPassword()));
    }

    public boolean checkInput() {
        if (txtUsername.getText().isEmpty() || txtUsername.getText() == null) {
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập Tên đăng nhập!", "Error",
                    JOptionPane.ERROR_MESSAGE);
            txtUsername.requestFocus();
            return false;
        } else if (String.valueOf(txtPassword.getPassword()).isEmpty() || txtPassword.getPassword() == null) {
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập Mật khẩu!", "Error",
                    JOptionPane.ERROR_MESSAGE);
            txtPassword.requestFocus();
            return false;
        }
        return true;
    }

    private void Login() {
        if (checkInput()) {
            LoginModel user = getUser();
            if (LoginController.checkData(user)) {
                new MainUI("Hệ thống Quản lý bán hàng");
                setVisible(false);
            } else {
                JOptionPane.showMessageDialog(LoginView.this,
                        "Tên đăng nhập hoặc Mật khẩu không đúng!", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void showWindow() {
        this.setSize(820, 450);
        this.setIconImage(new ImageIcon(Objects.requireNonNull(this.getClass().getResource(
                "/Images/icon.png"))).getImage());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setUndecorated(true);
        this.setLocationRelativeTo(null);
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
        SwingUtilities.invokeLater(LoginView::new);
    }
}
