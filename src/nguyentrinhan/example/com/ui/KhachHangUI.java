package nguyentrinhan.example.com.ui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;

import nguyentrinhan.example.com.model.KhachHang;
import nguyentrinhan.example.com.model.NhomKhachHang;

public class KhachHangUI<DefaulMutableTreeNode> extends JFrame {
	DefaultMutableTreeNode root = null;
	JTree treeNhom;

	DefaultTableModel dtm;
	JTable tblKhachHang;

	JTextField txtMa, txtTen, txtPhone, txtEmail;
	JButton btnLuu, btnXoa, btnThoat;

	ArrayList<NhomKhachHang> dsNhom;
	ArrayList<KhachHang> dsKhach;

	NhomKhachHang nhomSelected = null;

	public KhachHangUI(String title) {
		super(title);
		addControls();
		addEvents();
		fakeData();
	}

	public void addControls() {
		// TODO Auto-generated method stub
		Container con = getContentPane();
		JPanel pnLeft = new JPanel();
		pnLeft.setPreferredSize(new Dimension(300, 0));
		JPanel pnRight = new JPanel();
		JSplitPane sp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, pnLeft, pnRight);
		con.setLayout(new BorderLayout());
		con.add(sp, BorderLayout.CENTER);

		pnRight.setLayout(new BorderLayout());
		JPanel pnTopOfRight = new JPanel();
		pnTopOfRight.setPreferredSize(new Dimension(0, 350));
		JPanel pnBottomOfRight = new JPanel();
		JSplitPane spRight = new JSplitPane(JSplitPane.VERTICAL_SPLIT, pnTopOfRight, pnBottomOfRight);
		pnRight.add(spRight, BorderLayout.CENTER);

		// Đưa vào cây
		pnLeft.setLayout(new BorderLayout());
		root = new DefaultMutableTreeNode("Công ty Minh Hằng");

		treeNhom = new JTree(root);

		JScrollPane scTree = new JScrollPane(treeNhom, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		pnLeft.add(scTree, BorderLayout.CENTER);

		// Đưa bảng vào top of right
		pnTopOfRight.setLayout(new BorderLayout());
		dtm = new DefaultTableModel();
		dtm.addColumn("Mã khách hàng");
		dtm.addColumn("Tên khách hàng");
		dtm.addColumn("Số điện thoại");
		dtm.addColumn("Thư điện tử");
		tblKhachHang = new JTable(dtm);
		JScrollPane scTable = new JScrollPane(tblKhachHang, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		pnTopOfRight.add(scTable, BorderLayout.CENTER);

		pnBottomOfRight.setLayout(new BoxLayout(pnBottomOfRight, BoxLayout.Y_AXIS));

		JPanel pnMa = new JPanel();
		pnMa.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel lblMa = new JLabel("Mã khách hàng: ");

		txtMa = new JTextField(20);
		pnMa.add(lblMa);
		pnMa.add(txtMa);
		pnBottomOfRight.add(pnMa);

		JPanel pnTen = new JPanel();
		pnTen.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel lblTen = new JLabel("Tên khách hàng: ");
		txtTen = new JTextField(20);
		pnTen.add(lblTen);
		pnTen.add(txtTen);
		pnBottomOfRight.add(pnTen);

		JPanel pnPhone = new JPanel();
		pnPhone.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel lblPhone = new JLabel("Phone khách hàng: ");
		txtPhone = new JTextField(20);
		pnMa.add(lblPhone);
		pnMa.add(txtPhone);
		pnBottomOfRight.add(pnPhone);

		JPanel pnEmail = new JPanel();
		pnEmail.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel lblEmail = new JLabel("Email khách hàng: ");
		txtEmail = new JTextField(20);
		pnMa.add(lblEmail);
		pnMa.add(txtEmail);
		pnBottomOfRight.add(pnEmail);

		JPanel pnButton = new JPanel();
		pnButton.setLayout(new FlowLayout());
		btnLuu = new JButton("Lưu khách hàng");
		btnXoa = new JButton("Xóa khách hàng");
		btnThoat = new JButton("Thoát");
		pnButton.add(btnLuu);
		pnButton.add(btnXoa);
		pnButton.add(btnThoat);
		pnBottomOfRight.add(pnButton);

		lblMa.setPreferredSize(lblEmail.getPreferredSize());
		lblTen.setPreferredSize(lblEmail.getPreferredSize());
		lblPhone.setPreferredSize(lblEmail.getPreferredSize());
	}

	public void addEvents() {

		treeNhom.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				
				 DefaultMutableTreeNode nodeSelected= (DefaultMutableTreeNode)
				  treeNhom.getLastSelectedPathComponent(); if(nodeSelected!=null &&
				  nodeSelected.getLevel()==1) { nhomSelected = (NhomKhachHang)
				  nodeSelected.getUserObject(); hienThiDanhSachKhachHangTheoNhom(); }
				 			
			}
		});

		tblKhachHang.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {

				int rowSelected = tblKhachHang.getSelectedRow();
				if (rowSelected == -1)
					return;
				String ma = tblKhachHang.getValueAt(rowSelected, 0) + "";
				String ten = tblKhachHang.getValueAt(rowSelected, 1) + "";
				String phone = tblKhachHang.getValueAt(rowSelected, 2) + "";
				String email = tblKhachHang.getValueAt(rowSelected, 3) + "";

				txtMa.setText(ma);
				txtTen.setText(ten);
				txtPhone.setText(phone);
				txtEmail.setText(email);

			}
		});
		
		btnLuu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				KhachHang kh = new KhachHang(txtMa.getText(), txtTen.getText(),
						txtPhone.getText(), txtEmail.getText());
				nhomSelected.themKhachHang(kh);
			}
		});
	}

	protected void hienThiDanhSachKhachHangTheoNhom() {

		dtm.setRowCount(0);
		for (KhachHang kh : nhomSelected.getKhachHangs()) {
			Vector<String> vec = new Vector<String>();
			vec.add(kh.getMa());
			vec.add(kh.getTen());
			vec.add(kh.getPhone());
			vec.add(kh.getEmail());
			dtm.addRow(vec);
		}
	}

	public void fakeData() {

		dsNhom = new ArrayList<NhomKhachHang>();
		NhomKhachHang vip = new NhomKhachHang("n1", "Khách hàng vip");
		NhomKhachHang tiemnang = new NhomKhachHang("n2", "Khách hàng tiền năng");
		NhomKhachHang khotinh = new NhomKhachHang("n3", "Khách hàng khó tính");
		dsNhom.add(vip);
		dsNhom.add(tiemnang);
		dsNhom.add(khotinh);

		vip.getKhachHangs().add(new KhachHang("k1", "Nguyễn Trí Nhân", "0919367857", "nguyentrinhan70@gmail.com"));
		vip.getKhachHangs()
				.add(new KhachHang("k2", "Nguyễn Trần Khánh Hà", "0913367857", "nguyentrankhanhhadp@gmail.com"));
		vip.getKhachHangs()
				.add(new KhachHang("k3", "Nguyễn Khánh Ngân", "0919367857", "nguyenkhanhngan2012@gmail.com"));
		for (NhomKhachHang nhom : dsNhom) {
			DefaulMutableTreeNode nodeNhom = (DefaulMutableTreeNode) new DefaultMutableTreeNode(nhom);
			root.add((MutableTreeNode) nodeNhom);
			for (KhachHang khach : nhom.getKhachHangs()) {
				DefaultMutableTreeNode nodeKhach = new DefaultMutableTreeNode(khach);
				((DefaultMutableTreeNode) nodeNhom).add(nodeKhach);
			}

		}
		treeNhom.expandRow(0);
		btnThoat.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}

	public void showWindow() {
		this.setSize(600, 600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
