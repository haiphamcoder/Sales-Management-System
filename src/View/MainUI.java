package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.util.Objects;

public class MainUI extends JFrame {
    // attributes

    // components
    private JLabel lblBtnLogout;
    private CustomJLabel lblTrangChu, lblNhanVien, lblSanPham, lblKhachHang, lblNhaCungCap;
    private JMenuItem menuItemGithub, menuItemInformation, menuItemExit;
    private JPanel pnCenter;

    public static JFrame frame;

    // constructor
    public MainUI(String title) {
        super(title);
        frame = this;
        initComponents();
        addEvents();
        showWindow();
    }

    private void initComponents() {
        // implementation the menubar
        JMenuBar menuBar = new JMenuBar();

        JMenu menuFile = new JMenu("File");
        menuFile.setMnemonic('F');
        menuItemExit = new JMenuItem("Exit");
        menuItemExit.setIcon(new ImageIcon(Objects.requireNonNull(this.getClass().getResource(
                "/Images/ic_close_24px.png"))));
        menuItemExit.setAccelerator(KeyStroke.getKeyStroke('Q',
                Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()));
        menuFile.add(menuItemExit);

        JMenu menuHelp = new JMenu("Help");
        menuHelp.setMnemonic('H');
        menuItemInformation = new JMenuItem("Information");
        menuItemInformation.setIcon(new ImageIcon(Objects.requireNonNull(this.getClass().getResource("/Images/info_24px.png"))));
        menuItemInformation.setAccelerator(KeyStroke.getKeyStroke('I',
                Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()));
        menuItemGithub = new JMenuItem("Github");
        menuItemGithub.setIcon(new ImageIcon(Objects.requireNonNull(this.getClass().getResource(
                "/Images/github_24px.png"))));
        menuItemGithub.setAccelerator(KeyStroke.getKeyStroke('G',
                Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()));
        menuHelp.add(menuItemGithub);
        menuHelp.add(menuItemInformation);

        menuBar.add(menuFile);
        menuBar.add(menuHelp);
        this.setJMenuBar(menuBar);

        // implementation the left panel
        JPanel pnLeft = new JPanel();
        pnLeft.setLayout(new BorderLayout());
        pnLeft.setBackground(Color.WHITE);
        pnLeft.setPreferredSize(new Dimension(200, 0));

        JLabel lblImage = new JLabel();
        lblImage.setIcon(new ImageIcon(Objects.requireNonNull(this.getClass().getResource(
                "/Images/sales-manager.png"))));
        lblImage.setBorder(BorderFactory.createLineBorder(new Color(75, 102, 147), 2));
        JPanel pnLblImage = new JPanel();
        pnLblImage.setBackground(new Color(244, 247, 254));
        pnLblImage.setLayout(new BorderLayout());
        pnLblImage.add(lblImage, BorderLayout.CENTER);

        lblTrangChu = new CustomJLabel("Trang chủ");
        lblTrangChu.setIcon(new ImageIcon(Objects.requireNonNull(this.getClass().getResource(
                "/Images/home_32px.png"))));
        lblTrangChu.setBackground(new Color(78, 138, 201));
        lblTrangChu.setForeground(Color.WHITE);
        lblTrangChu.setSelected(true);
        JPanel pnLblTrangChu = new JPanel();
        pnLblTrangChu.setLayout(new BorderLayout());
        pnLblTrangChu.add(lblTrangChu, BorderLayout.CENTER);

        lblSanPham = new CustomJLabel("Sản phẩm");
        lblSanPham.setIcon(new ImageIcon(Objects.requireNonNull(this.getClass().getResource(
                "/Images/product_32px.png"))));
        JPanel pnLblSanPham = new JPanel();
        pnLblSanPham.setLayout(new BorderLayout());
        pnLblSanPham.add(lblSanPham, BorderLayout.CENTER);

        lblNhanVien = new CustomJLabel("Nhân viên");
        lblNhanVien.setIcon(new ImageIcon(Objects.requireNonNull(this.getClass().getResource(
                "/Images/employee_32px.png"))));
        JPanel pnLblNhanVien = new JPanel();
        pnLblNhanVien.setLayout(new BorderLayout());
        pnLblNhanVien.add(lblNhanVien, BorderLayout.CENTER);

        lblKhachHang = new CustomJLabel("Khách hàng");
        lblKhachHang.setIcon(new ImageIcon(Objects.requireNonNull(this.getClass().getResource(
                "/Images/customer_32px.png"))));
        JPanel pnLblKhachHang = new JPanel();
        pnLblKhachHang.setLayout(new BorderLayout());
        pnLblKhachHang.add(lblKhachHang, BorderLayout.CENTER);

        lblNhaCungCap = new CustomJLabel("Nhà cung cấp");
        lblNhaCungCap.setIcon(new ImageIcon(Objects.requireNonNull(this.getClass().getResource(
                "/Images/supplier_32px.png"))));
        JPanel pnLblNhaCungCap = new JPanel();
        pnLblNhaCungCap.setLayout(new BorderLayout());
        pnLblNhaCungCap.add(lblNhaCungCap, BorderLayout.CENTER);

        JPanel pnOption = new JPanel();
        pnOption.setLayout(new BoxLayout(pnOption, BoxLayout.Y_AXIS));
        pnOption.add(Box.createVerticalGlue());
        pnOption.add(pnLblTrangChu);
        pnOption.add(pnLblSanPham);
        pnOption.add(pnLblNhanVien);
        pnOption.add(pnLblKhachHang);
        pnOption.add(pnLblNhaCungCap);
        pnOption.add(Box.createVerticalGlue());

        pnLeft.add(pnLblImage, BorderLayout.NORTH);
        pnLeft.add(pnOption, BorderLayout.CENTER);

        // implementation the top panel
        JPanel pnTop = new JPanel();
        pnTop.setLayout(new BoxLayout(pnTop, BoxLayout.X_AXIS));
        pnTop.setBackground(Color.WHITE);
        pnTop.setPreferredSize(new Dimension(0, 30));

        JPanel pnTitle = new JPanel();
        pnTitle.setBackground(Color.WHITE);
        pnTitle.setPreferredSize(new Dimension(200, 0));

        lblBtnLogout = new JLabel("Đăng xuất");
        lblBtnLogout.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 14));
        lblBtnLogout.setIcon(new ImageIcon(Objects.requireNonNull(this.getClass().getResource(
                "/Images/Logout_32px.png"))));
        lblBtnLogout.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 20));
        lblBtnLogout.setBackground(new Color(151, 195, 243));
        lblBtnLogout.setOpaque(true);

        pnTop.add(Box.createHorizontalGlue());
        pnTop.add(lblBtnLogout);

        // implementation the center panel
        pnCenter = new JPanel();
        pnCenter.setLayout(new BorderLayout());
        pnCenter.setBackground(new Color(245, 245, 251));
        pnCenter.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(0,
                5, 0, 0), BorderFactory.createLineBorder(new Color(78, 138, 201), 4)));
        pnCenter.add(new HomePanel(), BorderLayout.CENTER);

        // implementation the main panel
        JPanel pnMain = new JPanel();
        pnMain.setLayout(new BorderLayout());
        pnMain.add(pnLeft, BorderLayout.WEST);
        pnMain.add(pnTop, BorderLayout.NORTH);
        pnMain.add(pnCenter, BorderLayout.CENTER);

        // Add main panel to the content pane
        Container con = this.getContentPane();
        con.setLayout(new BorderLayout());
        con.add(pnMain, BorderLayout.CENTER);
    }

    private void addEvents() {
        lblBtnLogout.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                MainUI.this.setVisible(false);
                new LoginView();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                lblBtnLogout.setBackground(Color.YELLOW);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                lblBtnLogout.setBackground(new Color(151, 195, 243));
            }
        });

        lblTrangChu.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                lblTrangChu.setSelected(true);
                lblNhaCungCap.setSelected(false);
                lblNhanVien.setSelected(false);
                lblKhachHang.setSelected(false);
                lblSanPham.setSelected(false);
                pnCenter.removeAll();
                pnCenter.add(new HomePanel(), BorderLayout.CENTER);
                pnCenter.updateUI();
            }
        });

        lblNhanVien.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                lblTrangChu.setSelected(false);
                lblNhaCungCap.setSelected(false);
                lblNhanVien.setSelected(true);
                lblKhachHang.setSelected(false);
                lblSanPham.setSelected(false);
                pnCenter.removeAll();
                pnCenter.add(new EmployeePanel(), BorderLayout.CENTER);
                pnCenter.updateUI();
            }
        });

        lblSanPham.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                lblTrangChu.setSelected(false);
                lblNhaCungCap.setSelected(false);
                lblNhanVien.setSelected(false);
                lblKhachHang.setSelected(false);
                lblSanPham.setSelected(true);
                pnCenter.removeAll();
                pnCenter.add(new ProductPanel(), BorderLayout.CENTER);
                pnCenter.updateUI();
            }
        });

        lblKhachHang.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                lblTrangChu.setSelected(false);
                lblNhaCungCap.setSelected(false);
                lblNhanVien.setSelected(false);
                lblKhachHang.setSelected(true);
                lblSanPham.setSelected(false);
                pnCenter.removeAll();
                pnCenter.add(new CustomerPanel(), BorderLayout.CENTER);
                pnCenter.updateUI();
            }
        });

        lblNhaCungCap.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                lblTrangChu.setSelected(false);
                lblNhaCungCap.setSelected(true);
                lblNhanVien.setSelected(false);
                lblKhachHang.setSelected(false);
                lblSanPham.setSelected(false);
                pnCenter.removeAll();
                pnCenter.add(new SupplierPanel(), BorderLayout.CENTER);
                pnCenter.updateUI();
            }
        });

        menuItemGithub.addActionListener(e -> {
            try {
                Desktop.getDesktop().browse(URI.create(
                        "https://github.com/ngochai285bkit/Sales-Management-System"));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        menuItemExit.addActionListener(e -> System.exit(0));

        menuItemInformation.addActionListener(e -> new InformationDialog(this, "Information"));

    }

    private void showWindow() {
        this.setSize(900, 650);
        this.setIconImage(new ImageIcon(Objects.requireNonNull(this.getClass().getResource(
                "/Images/icon.png"))).getImage());
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private static class CustomJLabel extends JLabel {
        public CustomJLabel(String text) {
            super(text);
            this.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 16));
            this.setHorizontalAlignment(JLabel.CENTER);
            this.setBorder(BorderFactory.createLineBorder(new Color(75, 102, 147), 2));
            this.setBackground(Color.WHITE);
            this.setForeground(Color.BLACK);
            this.setOpaque(true);
            this.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    CustomJLabel.this.setBackground(new Color(78, 138, 201));
                    CustomJLabel.this.setForeground(Color.BLACK);
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    CustomJLabel.this.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 2));
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    CustomJLabel.this.setBorder(BorderFactory.createLineBorder(new Color(75, 102,
                            147), 2));
                }
            });
        }

        public void setSelected(boolean selected) {
            if (selected) {
                this.setBackground(new Color(78, 138, 201));
                this.setForeground(Color.WHITE);
            } else {
                this.setBackground(Color.WHITE);
                this.setForeground(Color.BLACK);
            }
        }
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException |
                 IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        SwingUtilities.invokeLater(() -> new MainUI("Hệ thống Quản lý bán hàng"));
    }
}
