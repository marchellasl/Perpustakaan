package perpustakaan;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ViewAnggota extends JFrame
{
    String agama;
    JLabel judul = new JLabel ("DATA ANGGOTA");
    JLabel lnis = new JLabel("NIS");
    JTextField tfnis = new JTextField();
    JLabel lnamaAnggota = new JLabel("Nama Anggota");
    JTextField tfnamaAnggota = new JTextField();
    JLabel ltanggalLahir = new JLabel("TTL");
    JTextField tftanggalLahir = new JTextField();
    JLabel ljenisKelamin = new JLabel("Jenis Kelamin");
    JCheckBox cbperempuan = new JCheckBox("Perempuan");
    JCheckBox cblaki = new JCheckBox("Laki-Laki");
    JLabel lagama = new JLabel("Agama");
    String[] daftarAgama = 
                {"Islam", "Kristen", "Buddha", "Hindu"};
    JComboBox cmbagama = new JComboBox(daftarAgama);
    JLabel lkelas = new JLabel("Kelas");
    JTextField tfkelas = new JTextField();
    JLabel ltanggalDaftar = new JLabel("Tanggal Daftar");
    JTextField tftanggalDaftar = new JTextField();
    JLabel ltanggalAkhir = new JLabel("Berlaku Hingga");
    JTextField tftanggalAkhir = new JTextField();
    JButton btnSimpan = new JButton("Save");
    JButton btnHapus = new JButton("Delete");
    JButton btnKeluar = new JButton("Exit");
    JButton btnRefresh = new JButton("Refresh");
    
    JTable tabel;
    DefaultTableModel tableModel; 
    JScrollPane scrollPane;
    Object namaKolom[] = {"NIS","Nama Anggota","TTL","Jenis Kelamin","Agama","Tanggal Daftar","Berlaku Hingga","Kelas"};
   
    public ViewAnggota()
    {
        tableModel = new DefaultTableModel(namaKolom, 0);
        tabel = new JTable(tableModel);
        scrollPane = new JScrollPane(tabel);
        
        setTitle("Data Anggota");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        setSize(900, 600);
        setLocation(200, 50);

        add(judul);
        judul.setBounds(400, 30, 120, 20);
        add(lnis);
        lnis.setBounds(30, 100, 120, 20);
        add(tfnis);
        tfnis.setBounds(150, 100, 150, 20);
        add(lnamaAnggota);
        lnamaAnggota.setBounds(30, 130, 120, 20);
        add(tfnamaAnggota);
        tfnamaAnggota.setBounds(150, 130, 150, 20);
        add(ltanggalLahir);
        ltanggalLahir.setBounds(30, 160, 120, 20);
        add(tftanggalLahir);
        tftanggalLahir.setBounds(150, 160, 150, 20);
        add(ljenisKelamin);
        ljenisKelamin.setBounds(30, 190, 120, 20);
        add(cbperempuan);
        cbperempuan.setBounds(150, 190, 120, 20);
        add(cblaki);
        cblaki.setBounds(270, 190, 120, 20);
        add(lagama);
        lagama.setBounds(550, 100, 120, 20);
        add(cmbagama);
        cmbagama.setBounds(670, 100, 120, 20);    
        add(lkelas);
        lkelas.setBounds(550, 130, 120, 20);
        add(tfkelas);
        tfkelas.setBounds(670, 130, 150, 20);
        add(ltanggalDaftar);
        ltanggalDaftar.setBounds(550, 160, 120, 20);
        add(tftanggalDaftar);
        tftanggalDaftar.setBounds(670, 160, 150, 20);
        add(ltanggalAkhir);
        ltanggalAkhir.setBounds(550, 190, 120, 20);
        add(tftanggalAkhir);
        tftanggalAkhir.setBounds(670, 190, 150, 20);
        add(btnSimpan);
        btnSimpan.setBounds(100, 250, 100, 40);
        add(btnHapus);
        btnHapus.setBounds(300, 250, 100, 40);
        add(btnKeluar);
        btnKeluar.setBounds(500, 250, 100, 40);
        add(btnRefresh);
        btnRefresh.setBounds(700, 250, 100, 40);
                 
        add(scrollPane);
        scrollPane.setBounds(30, 300, 830, 250);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
    }
    
    public String getNis()
    {
        return tfnis.getText();
    }
    
    public String getNama()
    {
        return tfnamaAnggota.getText();
    }
    
    public String getTanggalLahir()
    {
        return tftanggalLahir.getText();
    }
    
    public String getJk()
    {
        if(cbperempuan.isSelected())
        {
                return cbperempuan.getText();
        }
            else if(cblaki.isSelected())
        {
                return cblaki.getText();
        }
        return null;
    }
    
    public String getAgama()
    {
        agama = (String)cmbagama.getSelectedItem();
        return agama;
    }
    
    public String getKelas()
    {
        return tfkelas.getText();
    }
    
    public String getTglDaftar()
    {
        return tftanggalDaftar.getText();
    }
    
    public String getBerlakuHingga()
    {
        return tftanggalAkhir.getText();
    }
}
