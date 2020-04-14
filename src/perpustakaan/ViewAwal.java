package perpustakaan;

import java.awt.event.*;
import javax.swing.*;

public class ViewAwal extends JFrame 
{

    JButton btnAnggota = new JButton("Input Anggota");
    JButton btnBuku = new JButton("Input Data Buku");
    JButton btnKaryawan = new JButton("Input Karyawan");
    JButton btnPeminjaman = new JButton("Peminjaman");
    
    public ViewAwal()
    {
        setTitle("BERANDA");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        setSize(400, 300);
        setLocation(500, 100);
        
        add(btnAnggota);
        btnAnggota.setBounds(30, 30, 130, 75);
        add(btnBuku);
        btnBuku.setBounds(225, 30, 130, 75);
        add(btnKaryawan);
        btnKaryawan.setBounds(30, 150, 130, 75);
        add(btnPeminjaman);
        btnPeminjaman.setBounds(225, 150, 130, 75);
        
        btnAnggota.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                MVC_Anggota mvcAnggota = new MVC_Anggota();
                dispose();
            }
        });
        
        btnBuku.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                MVC_Buku mvcBuku = new MVC_Buku();
                dispose();
            }
        });
        
        btnKaryawan.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                MVC_Karyawan mvcKaryawan = new MVC_Karyawan();
                dispose();
            }
        });
        
        btnPeminjaman.addActionListener(new ActionListener()
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
