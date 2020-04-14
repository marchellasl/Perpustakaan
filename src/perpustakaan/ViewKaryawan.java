package perpustakaan;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ViewKaryawan extends JFrame
{
    JLabel judul = new JLabel("Data Karyawan");
    JLabel lnik = new JLabel("NIK");
    JTextField tfnik = new JTextField();
    JLabel lnamaKaryawan = new JLabel("Nama Karyawan");
    JTextField tfnamaKaryawan = new JTextField();
    JLabel ljenisKelamin = new JLabel("Jenis Kelamin");
    JCheckBox cbperempuan = new JCheckBox("Perempuan");
    JCheckBox cblaki = new JCheckBox("Laki-Laki");
    JLabel lgolongan = new JLabel("Golongan");
    JTextField tfgolongan = new JTextField();
    JLabel ljabatan = new JLabel("Jabatan");
    JLabel tfjabatan = new JLabel();
    JLabel ltunjangan = new JLabel("Tunjangan");
    JLabel tftunjangan = new JLabel();
    JLabel ljumlahGaji = new JLabel("Jumlah Gaji");
    JLabel tfjumlahGaji = new JLabel();
    JButton btnSimpan = new JButton("Save");
    JButton btnHapus = new JButton("Delete");
    JButton btnCari = new JButton("Search");
    JButton btnKeluar = new JButton("Exit");
    JButton btnRefresh = new JButton("Refresh");
    
    JTable tabel;
    DefaultTableModel tableModel; 
    JScrollPane scrollPane;
    Object namaKolom[] = {"NIK", "Nama Karyawan", "Jenis Kelamin", "Golongan", "Jabatan", "Tunjangan", "Total Gaji"};
    public ViewKaryawan()
    {
        tableModel = new DefaultTableModel(namaKolom, 0);
        tabel = new JTable(tableModel);
        scrollPane = new JScrollPane(tabel);
        
        setTitle("Data Karyawan");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        setSize(900, 600);
        setLocation(200, 50);
        
        add(judul);
        judul.setBounds(400, 30, 120, 20);
        add(lnik);
        lnik.setBounds(30, 100, 120, 20);
        add(tfnik);
        tfnik.setBounds(150, 100, 150, 20);
        add(lnamaKaryawan);
        lnamaKaryawan.setBounds(30, 130, 120, 20);
        add(tfnamaKaryawan);
        tfnamaKaryawan.setBounds(150, 130, 150, 20);
        add(ljenisKelamin);
        ljenisKelamin.setBounds(30, 160, 120, 20);
        add(cbperempuan);
        cbperempuan.setBounds(150, 160, 120, 20);
        add(cblaki);
        cblaki.setBounds(270, 160, 120, 20);
        add(lgolongan);
        lgolongan.setBounds(30, 190, 120, 20);
        add(tfgolongan);
        tfgolongan.setBounds(150, 190, 150, 20);
        add(ljabatan);
        ljabatan.setBounds(30, 220, 120, 20);
        add(tfjabatan);
        tfjabatan.setBounds(150, 220, 150, 20);
        add(ltunjangan);
        ltunjangan.setBounds(30, 250, 120, 20);
        add(tftunjangan);
        tftunjangan.setBounds(150, 250, 150, 20);
        add(ljumlahGaji);
        ljumlahGaji.setBounds(30, 280, 120, 20);
        add(tfjumlahGaji);
        tfjumlahGaji.setBounds(150, 280, 150, 20);
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
        scrollPane.setBounds(30, 315, 830, 240);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);     
    }
        
    public String getNik()
    {
        return tfnik.getText();
    }
    
    public String getNama()
    {
        return tfnamaKaryawan.getText();
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
    
    public String getGolongan()
    {
        return tfgolongan.getText();
    }
}
