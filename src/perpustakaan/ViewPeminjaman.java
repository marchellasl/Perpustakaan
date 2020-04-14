package perpustakaan;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ViewPeminjaman extends JFrame
{
    JLabel judul = new JLabel("Data Pengembalian Buku");
    JLabel lnoPinjam = new JLabel("Nomor Pinjam");
    JTextField tfnoPinjam = new JTextField();
    JLabel lnis = new JLabel("NIS");
    JTextField tfnis = new JTextField();
    JLabel lnamaAnggota = new JLabel("Nama Anggota");
    JLabel tfnamaAnggota = new JLabel();
    JLabel lkelas = new JLabel("Kelas");
    JLabel tfkelas = new JLabel();
    JLabel lkodeBuku = new JLabel("Kode Buku");
    JTextField tfkodeBuku = new JTextField();
    JLabel ljudulBuku = new JLabel("Judul Buku");
    JLabel tfjudulBuku = new JLabel();
    JLabel lnamaPenerbit = new JLabel("Nama Penerbit");
    JLabel tfnamaPenerbit = new JLabel();
    JLabel ltanggalPinjam = new JLabel("Tanggal Pinjam");
    JTextField tftanggalPinjam = new JTextField();
    JLabel ltanggalKembali = new JLabel("Tanggal Kembali");
    JTextField tftanggalKembali = new JTextField();
    JLabel llamaPinjam = new JLabel("Lama Pinjam");
    JLabel tflamaPinjam = new JLabel();
    JLabel ldenda = new JLabel("Denda");
    JLabel tfdenda = new JLabel();
    JLabel lnik = new JLabel("NIK");
    JTextField tfnik = new JTextField();
    JLabel lnamaKaryawan = new JLabel("Karyawan yang bertugas");
    JLabel tfnamaKaryawan = new JLabel();
    
    JButton btnSimpan = new JButton("Save");
    JButton btnCari = new JButton("Search");
    JButton btnPrint = new JButton("Print");
    JButton btnRefresh = new JButton("Refresh");
    JButton btnHapus = new JButton("Delete");
    JButton btnKeluar = new JButton("Exit");
    
    JTable tabel;
    DefaultTableModel tableModel; 
    JScrollPane scrollPane;
    Object namaKolom[] = {"No. Pinjam", "NIS", "Nama Anggota", "Kelas", "Kode Buku", "Judul Buku", "Penerbit", "Tgl Pinjam", "Tgl Kembali", "Lama Pinjam", "Denda", "Petugas", "NIK"};
    
    
    public ViewPeminjaman()
    {
        tableModel = new DefaultTableModel(namaKolom, 0);
        tabel = new JTable(tableModel);
        scrollPane = new JScrollPane(tabel);
        
        setTitle("Data Pengembalian Buku");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        setSize(950, 650);
        setLocation(200, 40);
        
        add(judul);
        judul.setBounds(400, 20, 150, 20);
        add(lnoPinjam);
        lnoPinjam.setBounds(30, 50, 120, 20);
        add(tfnoPinjam);
        tfnoPinjam.setBounds(150, 50, 150, 20);
        add(lnis);
        lnis.setBounds(30, 80, 120, 20);
        add(tfnis);
        tfnis.setBounds(150, 80, 150, 20);
        add(lnamaAnggota);
        lnamaAnggota.setBounds(30, 110, 120, 20);
        add(tfnamaAnggota);
        tfnamaAnggota.setBounds(150, 110, 150, 20);
        add(lkelas);
        lkelas.setBounds(30, 140, 120, 20);
        add(tfkelas);
        tfkelas.setBounds(150, 140, 150, 20);
        add(lkodeBuku);
        lkodeBuku.setBounds(30, 170, 120, 20);
        add(tfkodeBuku);
        tfkodeBuku.setBounds(150, 170, 150, 20);
        add(ljudulBuku);
        ljudulBuku.setBounds(30, 200, 120, 20);
        add(tfjudulBuku);
        tfjudulBuku.setBounds(150, 200, 150, 20);
        add(lnamaPenerbit);
        lnamaPenerbit.setBounds(30, 230, 120, 20);
        add(tfnamaPenerbit);
        tfnamaPenerbit.setBounds(150, 230, 150, 20);
        add(ltanggalPinjam);
        ltanggalPinjam.setBounds(30, 260, 120, 20);
        add(tftanggalPinjam);
        tftanggalPinjam.setBounds(150, 260, 150, 20);
        add(ltanggalKembali);
        ltanggalKembali.setBounds(30, 290, 120, 20);
        add(tftanggalKembali);
        tftanggalKembali.setBounds(150, 290, 150, 20);
        add(llamaPinjam);
        llamaPinjam.setBounds(30, 320, 120, 20);
        add(tflamaPinjam);
        tflamaPinjam.setBounds(150, 320, 150, 20);
        add(ldenda);
        ldenda.setBounds(400, 260, 120, 20);
        add(tfdenda);
        tfdenda.setBounds(620, 260, 150, 20);
        add(lnik);
        lnik.setBounds(400, 290, 120, 20);
        add(tfnik);
        tfnik.setBounds(620, 290, 150, 20);
        add(lnamaKaryawan);
        lnamaKaryawan.setBounds(400, 320, 145, 20);
        add(tfnamaKaryawan);
        tfnamaKaryawan.setBounds(620, 320, 150, 20);
        add(btnSimpan);
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
        add(btnPrint);
        btnPrint.setBounds(625, 210, 100, 30);
        
        add(scrollPane);
        scrollPane.setBounds(30, 350, 870, 240);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
    }
    
    public String getNoPinjam()
    {
        return tfnoPinjam.getText();
    }
    
    public String getNis()
    {
        return tfnis.getText();
    }
    
    public String getKodeBuku()
    {
        return tfkodeBuku.getText();
    }
    
    public String getTanggalPinjam()
    {
        return tftanggalPinjam.getText();
    }
    
    public String getTanggalKembali()
    {
        return tftanggalKembali.getText();
    }
    
    public String getNik()
    {
        return tfnik.getText();
    }
    
}
