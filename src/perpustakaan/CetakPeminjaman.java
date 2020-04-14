package perpustakaan;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class CetakPeminjaman extends JFrame
{
    JLabel title = new JLabel("NOTA PEMINJAMAN BUKU");
    JLabel lnoPinjam = new JLabel("Nomor Pinjam");
    JLabel tfnoPinjam = new JLabel();
    JLabel lnis = new JLabel("NIS");
    JLabel tfnis = new JLabel();
    JLabel lnamaAnggota = new JLabel("Nama Anggota");
    JLabel tfnamaAnggota = new JLabel();
    JLabel lkelas = new JLabel("Kelas");
    JLabel tfkelas = new JLabel();
    JLabel lkodeBuku = new JLabel("Kode Buku");
    JLabel tfkodeBuku = new JLabel();
    JLabel ljudulBuku = new JLabel("Judul Buku");
    JLabel tfjudulBuku = new JLabel();
    JLabel lnamaPenerbit = new JLabel("Nama Penerbit");
    JLabel tfnamaPenerbit = new JLabel();
    JLabel ltanggalPinjam = new JLabel("Tanggal Pinjam");
    JLabel tftanggalPinjam = new JLabel();
    JLabel ltanggalKembali = new JLabel("Tanggal Kembali");
    JLabel tftanggalKembali = new JLabel();
    JLabel llamaPinjam = new JLabel("Lama Pinjam");
    JLabel tflamaPinjam = new JLabel();
    JLabel ldenda = new JLabel("Denda");
    JLabel tfdenda = new JLabel();
    JLabel lnik = new JLabel("NIK");
    JLabel tfnik = new JLabel();
    JLabel lnamaKaryawan = new JLabel("Karyawan yang bertugas");
    JLabel tfnamaKaryawan = new JLabel();
    JButton btnKembali = new JButton("Back");
    JButton btnCetak = new JButton("Print");
    
    public CetakPeminjaman(String no, String nis, String nama, String kelas, String kode, String judul, String penerbit, String pinjam, String kembali, String lama, String denda, String karyawan, String nik)
    {
        setTitle("Nota Pengembalian Buku");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        setSize(450, 550);
        setLocation(350, 40);
        
        add(title);
        title.setBounds(150, 5, 150, 20);
        add(lnoPinjam);
        lnoPinjam.setBounds(30, 50, 120, 20);
        add(tfnoPinjam);
        tfnoPinjam.setBounds(300, 50, 150, 20);
        add(lnis);
        lnis.setBounds(30, 80, 120, 20);
        add(tfnis);
        tfnis.setBounds(300, 80, 150, 20);
        add(lnamaAnggota);
        lnamaAnggota.setBounds(30, 110, 120, 20);
        add(tfnamaAnggota);
        tfnamaAnggota.setBounds(300, 110, 150, 20);
        add(lkelas);
        lkelas.setBounds(30, 140, 120, 20);
        add(tfkelas);
        tfkelas.setBounds(300, 140, 150, 20);
        add(lkodeBuku);
        lkodeBuku.setBounds(30, 170, 120, 20);
        add(tfkodeBuku);
        tfkodeBuku.setBounds(300, 170, 150, 20);
        add(ljudulBuku);
        ljudulBuku.setBounds(30, 200, 120, 20);
        add(tfjudulBuku);
        tfjudulBuku.setBounds(300, 200, 150, 20);
        add(lnamaPenerbit);
        lnamaPenerbit.setBounds(30, 230, 120, 20);
        add(tfnamaPenerbit);
        tfnamaPenerbit.setBounds(300, 230, 150, 20);
        add(ltanggalPinjam);
        ltanggalPinjam.setBounds(30, 260, 120, 20);
        add(tftanggalPinjam);
        tftanggalPinjam.setBounds(300, 260, 150, 20);
        add(ltanggalKembali);
        ltanggalKembali.setBounds(30, 290, 120, 20);
        add(tftanggalKembali);
        tftanggalKembali.setBounds(300, 290, 150, 20);
        add(llamaPinjam);
        llamaPinjam.setBounds(30, 320, 120, 20);
        add(tflamaPinjam);
        tflamaPinjam.setBounds(300, 320, 150, 20);
        add(ldenda);
        ldenda.setBounds(30, 350, 120, 20);
        add(tfdenda);
        tfdenda.setBounds(300, 350, 150, 20);
        add(lnik);
        lnik.setBounds(30, 380, 120, 20);
        add(tfnik);
        tfnik.setBounds(300, 380, 150, 20);
        add(lnamaKaryawan);
        lnamaKaryawan.setBounds(30, 410, 145, 20);
        add(tfnamaKaryawan);
        tfnamaKaryawan.setBounds(300, 410, 150, 20);
        add(btnKembali);
        btnKembali.setBounds(275, 450, 100, 40);
        add(btnCetak);
        btnCetak.setBounds(50, 450, 100, 40);
        
        tfnoPinjam.setText(no);
        tfnis.setText(nis);
        tfnamaAnggota.setText(nama);
        tfkelas.setText(kelas);
        tfkodeBuku.setText(kode);
        tfjudulBuku.setText(judul);
        tfnamaPenerbit.setText(penerbit);
        tftanggalPinjam.setText(pinjam);
        tftanggalKembali.setText(kembali);
        tflamaPinjam.setText(lama);
        tfdenda.setText(denda);
        tfnik.setText(nik);
        tfnamaKaryawan.setText(karyawan);
        
        btnKembali.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                MVC_Peminjaman mvcPeminjaman = new MVC_Peminjaman();
                dispose();
            }
        });
        
        
        
        
        
    }
    

    
    
}
