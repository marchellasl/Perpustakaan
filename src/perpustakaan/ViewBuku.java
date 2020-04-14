package perpustakaan;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ViewBuku extends JFrame
{
    JLabel judul = new JLabel("Data Buku");
    JLabel lkodeBuku = new JLabel("Kode Buku");
    JTextField tfkodeBuku = new JTextField();
    JLabel ljudulBuku = new JLabel("Judul Buku");
    JTextField tfjudulBuku = new JTextField();
    JLabel lnamaPengarang = new JLabel("Nama Pengarang");
    JTextField tfnamaPengarang = new JTextField();
    JLabel lnamaPenerbit = new JLabel("Nama Penerbit");
    JTextField tfnamaPenerbit = new JTextField();
    JLabel ltahunTerbit = new JLabel("Tahun Terbit");
    JTextField tftahunTerbit = new JTextField();
    JButton btnSimpan = new JButton("Save");
    JButton btnHapus = new JButton("Delete");
    JButton btnCari = new JButton("Search");
    JButton btnKeluar = new JButton("Exit");
    JButton btnRefresh = new JButton("Refresh");
    
    JTable tabel;
    DefaultTableModel tableModel; 
    JScrollPane scrollPane;
    Object namaKolom[] = {"Kode Buku", "Judul Buku", "Nama Pengarang", "Nama Penerbit", "Tahun Terbit"};
     
    public ViewBuku()
    {
        tableModel = new DefaultTableModel(namaKolom, 0);
        tabel = new JTable(tableModel);
        scrollPane = new JScrollPane(tabel);
        
        setTitle("Data Buku");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        setSize(900, 600);
        setLocation(200, 50);
        
        add(judul);
        judul.setBounds(400, 30, 120, 20);
        add(lkodeBuku);
        lkodeBuku.setBounds(30, 100, 120, 20);
        add(tfkodeBuku);
        tfkodeBuku.setBounds(150, 100, 150, 20);
        add(ljudulBuku);
        ljudulBuku.setBounds(30, 130, 120, 20);
        add(tfjudulBuku);
        tfjudulBuku.setBounds(150, 130, 150, 20);
        add(lnamaPengarang);
        lnamaPengarang.setBounds(30, 160, 120, 20);
        add(tfnamaPengarang);
        tfnamaPengarang.setBounds(150, 160, 150, 20);
        add(lnamaPenerbit);
        lnamaPenerbit.setBounds(30, 190, 120, 20);
        add(tfnamaPenerbit);
        tfnamaPenerbit.setBounds(150, 190, 150, 20);
        add(ltahunTerbit);
        ltahunTerbit.setBounds(30, 220, 120, 20);
        add(tftahunTerbit);
        tftahunTerbit.setBounds(150, 220, 150, 20);
        add(btnSimpan);
        btnSimpan.setBounds(550, 130, 100, 30);
        add(btnHapus);
        btnHapus.setBounds(675, 130, 100, 30);
        add(btnCari);
        btnCari.setBounds(500, 170, 100, 30);
        add(btnKeluar);
        btnKeluar.setBounds(625, 170, 100, 30);
        add(btnRefresh);
        btnRefresh.setBounds(750, 170, 100, 30);
        
        add(scrollPane);
        scrollPane.setBounds(30, 275, 830, 275);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
    }
    
    public String getKode()
    {
        return tfkodeBuku.getText();
    }
    
    public String getJudul()
    {
        return tfjudulBuku.getText();
    }
    
    public String getPengarang()
    {
        return tfnamaPengarang.getText();
    }
    
    public String getPenerbit()
    {
        return tfnamaPenerbit.getText();
    }
    
    public String getTahun()
    {
        return tftahunTerbit.getText();
    }
            
}
